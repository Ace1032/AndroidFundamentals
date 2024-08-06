package packt.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Imara's App");
    }

    public void startBackgroundService(View view){
        Intent intent=new Intent(this,MyBackgoundService.class);
        intent.putExtra("sleepTime", 10);
        startService(intent);
    }
    public void stopBackgroundService(View view){
        Intent intent=new Intent(this,MyBackgoundService.class);
        stopService(intent);
    }

    public void startIntentService(View view) {
        Intent intent=new Intent(this,MyIntentService.class);
        startService(intent);
    }
}
