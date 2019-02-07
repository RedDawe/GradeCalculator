package etlantis.gradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
/*
        ImageButton backB = (ImageButton) findViewById(R.id.imageButton);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backI = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backI);
            }
        });*/
    }
}
