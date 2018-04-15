package mg.studio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvName;
    private ListView listView;
    private SessionManager session;
    /* 定义数组来表示listView*/
    private static final String[] commonFunList = new String[]{
            "00_LifeCycle", "01_UserName", "01_UserName_Final", "02_Layout", "02_Layout_Final", "03_Button_Design", "03_Button_Toast", "04_Button_Intent", "05_Button_StartActivity", "05_Button_StartActivity_extra", "06_ImageButton", "07_EditText", "08_RadioButtons_listener", "08_RadioButtons_onclick", "09_listView", "10_GetColor", "11_GradientBackground", "12_AppIntentCaller","12_AppIntentReceiver", "13_Weather_App_Design", "15_ListView", "16_ListViewCustomAdapter", "17_AudioRecorder", "19_DataBase", "20_FragmentOne", "21_Webview", "22_ServiceDemo", "23_Service", "24_Fingerprint", "25_AppPrivateDirectory", "26_AssetsFolder", "27_IntentExtras"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.user_name);
        listView = findViewById(R.id.app_list);

        /**
         * Only logged in users should access this activity
         */
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            logout();
        }

        /**
         * If the user just registered an account from Register.class,
         * the parcelable should be retrieved
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve the parcelable
            Feedback feedback = bundle.getParcelable("feedback");
            // Get the from the object
            String userName = feedback.getName();
            tvName.setText(userName);
        }

        //set listview content
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                commonFunList));

        //监听listview中item的点击事件
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //emmmm令人窒息的操作
                        switch (position){
                            case 0: startActivity(new Intent(getApplicationContext(), MainActivity_00.class));break;
                            case 1: startActivity(new Intent(getApplicationContext(), MainActivity_01.class));break;
                            case 2: startActivity(new Intent(getApplicationContext(), MainActivity_02.class));break;
                            case 3: startActivity(new Intent(getApplicationContext(), MainActivity_03.class));break;
                            case 4: startActivity(new Intent(getApplicationContext(), MainActivity_04.class));break;
                            case 5: startActivity(new Intent(getApplicationContext(), MainActivity_05.class));break;
                            case 6: startActivity(new Intent(getApplicationContext(), MainActivity_06.class));break;
                            case 7: startActivity(new Intent(getApplicationContext(), MainActivity_07.class));break;
                            case 8: startActivity(new Intent(getApplicationContext(), MainActivity_08.class));break;
                            case 9: startActivity(new Intent(getApplicationContext(), MainActivity_09.class));break;
                            case 10: startActivity(new Intent(getApplicationContext(), MainActivity_10.class));break;
                            case 11: startActivity(new Intent(getApplicationContext(), MainActivity_11.class));break;
                            case 12: startActivity(new Intent(getApplicationContext(), MainActivity_12.class));break;
                            case 13: startActivity(new Intent(getApplicationContext(), MainActivity_13.class));break;
                            case 14: startActivity(new Intent(getApplicationContext(), MainActivity_14.class));break;
                            case 15: startActivity(new Intent(getApplicationContext(), MainActivity_15.class));break;
                            case 16: startActivity(new Intent(getApplicationContext(), MainActivity_16.class));break;
                            case 17: startActivity(new Intent(getApplicationContext(), MainActivity_17.class));break;
                            case 18: startActivity(new Intent(getApplicationContext(), MainActivity_18.class));break;
                            case 19: startActivity(new Intent(getApplicationContext(), MainActivity_19.class));break;
                            case 20: startActivity(new Intent(getApplicationContext(), MainActivity_20.class));break;
                            case 21: startActivity(new Intent(getApplicationContext(), MainActivity_21.class));break;
                            case 22: startActivity(new Intent(getApplicationContext(), MainActivity_22.class));break;
                            case 23: startActivity(new Intent(getApplicationContext(), MainActivity_23.class));break;
                            case 24: startActivity(new Intent(getApplicationContext(), MainActivity_24.class));break;
                            case 25: startActivity(new Intent(getApplicationContext(), MainActivity_25.class));break;
                            case 26: startActivity(new Intent(getApplicationContext(), MainActivity_26.class));break;
                            case 27: startActivity(new Intent(getApplicationContext(), MainActivity_27.class));break;
                            case 28: startActivity(new Intent(getApplicationContext(), MainActivity_28.class));break;
                            case 29: startActivity(new Intent(getApplicationContext(), MainActivity_29.class));break;
                            case 30: startActivity(new Intent(getApplicationContext(), MainActivity_30.class));break;
                            case 31: startActivity(new Intent(getApplicationContext(), MainActivity_31.class));break;
                        }
                    }
                }
        );


    }

    /**
     * Logging out the user:
     * - Will set isLoggedIn flag to false in SharedPreferences
     * - Clears the user data from SqLite users table
     */

    public void btnLogout(View view) {
        logout();
    }

    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, Login.class));
        finish();
    }
}