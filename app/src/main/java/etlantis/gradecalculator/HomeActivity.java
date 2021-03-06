package etlantis.gradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent homeIntent = new Intent(HomeActivity.this, TabbedActivity.class);
                                          startActivity(homeIntent);
                                          finish();

                                      }
                                  }, SPLASH_TIME_OUT
        );

    }
}
