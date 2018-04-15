package mg.studio.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity_31 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_31);

    }

    public void btnClick(View view) {
        String value = "Hello World! - This message was from the first activity.";
        Intent intent = new Intent(getApplicationContext(), NewActivity_31.class);
        intent.putExtra("keyword", value);
        startActivity(intent);
    }
}
