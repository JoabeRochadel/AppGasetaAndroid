package devandroid.joabe.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.joabe.appgaseta.R;
import devandroid.joabe.appgaseta.database.GasEtaDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        screenSpash();
    }

    private void screenSpash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GasEtaDB db = new GasEtaDB(SplashActivity.this);
                Intent mainScreen = new Intent(SplashActivity.this, GasEtaActivity.class);

                startActivity(mainScreen);

                finish();
            }
        }, TIME_OUT_SPLASH);

    }
}