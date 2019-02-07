package etlantis.gradecalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        ImageButton linkw = (ImageButton) findViewById(R.id.imageButton3);
        linkw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openw = new Intent(Intent.ACTION_VIEW, Uri.parse("https://etlantis.bitballoon.com/"));
                startActivity(openw);
            }
        });

        ImageButton help = (ImageButton) findViewById(R.id.imageButton2);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(startIntent);
            }
        });

        Button calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText sO = (EditText) findViewById(R.id.editText);
                String S = sO.getText().toString();
                EditText tO = (EditText) findViewById(R.id.editText2);
                String T =  tO.getText().toString();
                // T = T.substring(0, S.lenght())
                TextView txtView = (TextView) findViewById(R.id.textView);
                EditText dGO = (EditText) findViewById(R.id.editText5);
                String Dg = dGO.getText().toString();
                EditText sGO = (EditText) findViewById(R.id.editText3);
                String sG = sGO.getText().toString();
                EditText sGWO = (EditText) findViewById(R.id.editText4);
                String sGW = sGWO.getText().toString();

                String output;

                float numberOfGrades = 0;
                float sum = 0;
                int count = 0;
                float desiredGrade = (float) (3.5);
                float scaredGrade = 5;
                float scaredGradeWeight = 1;
                float average;
                //boolean hopeididntusethiselsewhere = true;



                try {
                    S = S.replaceAll(",", ".");
                    S = S.replaceAll ("-", ".5");
                    S = S.replaceAll("A", "4");
                    S = S.replaceAll("B", "3");
                    S = S.replaceAll("C", "2");
                    S = S.replaceAll("D", "1");
                    S = S.replaceAll("E", "0");
                    S = S.replaceAll("F", "0");
                    S = S.replaceAll("a", "4");
                    S = S.replaceAll("b", "3");
                    S = S.replaceAll("c", "2");
                    S = S.replaceAll("d", "1");
                    S = S.replaceAll("e", "0");
                    S = S.replaceAll("f", "0");


                    T = T.replaceAll(",", ".");
                    T = T.replaceAll ("-", ".5");
                    T = T.replaceAll("A", "4");
                    T = T.replaceAll("B", "3");
                    T = T.replaceAll("C", "2");
                    T = T.replaceAll("D", "1");
                    T = T.replaceAll("E", "0");
                    T = T.replaceAll("F", "0");
                    T = T.replaceAll("a", "4");
                    T = T.replaceAll("b", "3");
                    T = T.replaceAll("c", "2");
                    T = T.replaceAll("d", "1");
                    T = T.replaceAll("e", "0");
                    T = T.replaceAll("f", "0");

                    Dg = Dg.replaceAll(",", ".");
                    Dg = Dg.replaceAll("A", "4");
                    Dg = Dg.replaceAll("B", "3");
                    Dg = Dg.replaceAll("C", "2");
                    Dg = Dg.replaceAll("D", "1");
                    Dg = Dg.replaceAll("E", "0");
                    Dg = Dg.replaceAll("F", "0");
                    Dg = Dg.replaceAll("a", "4");
                    Dg = Dg.replaceAll("b", "3");
                    Dg = Dg.replaceAll("c", "2");
                    Dg = Dg.replaceAll("d", "1");
                    Dg = Dg.replaceAll("e", "0");
                    Dg = Dg.replaceAll("f", "0");

                    sG = sG.replaceAll(",", ".");
                    sG = sG.replaceAll ("-", ".5");
                    sG = sG.replaceAll("A", "4");
                    sG = sG.replaceAll("B", "3");
                    sG = sG.replaceAll("C", "2");
                    sG = sG.replaceAll("D", "1");
                    sG = sG.replaceAll("E", "0");
                    sG = sG.replaceAll("F", "0");
                    sG = sG.replaceAll("a", "4");
                    sG = sG.replaceAll("b", "3");
                    sG = sG.replaceAll("c", "2");
                    sG = sG.replaceAll("d", "1");
                    sG = sG.replaceAll("e", "0");
                    sG = sG.replaceAll("f", "0");

                    sGW = sGW.replaceAll(",", ".");
                    sGW = sGW.replaceAll ("-", ".5");
                    sGW = sGW.replaceAll("A", "4");
                    sGW = sGW.replaceAll("B", "3");
                    sGW = sGW.replaceAll("C", "2");
                    sGW = sGW.replaceAll("D", "1");
                    sGW = sGW.replaceAll("E", "0");
                    sGW = sGW.replaceAll("F", "0");
                    sGW = sGW.replaceAll("a", "4");
                    sGW = sGW.replaceAll("b", "3");
                    sGW = sGW.replaceAll("c", "2");
                    sGW = sGW.replaceAll("d", "1");
                    sGW = sGW.replaceAll("e", "0");
                    sGW = sGW.replaceAll("f", "0");






                    if (Dg.length() > 0){
                        desiredGrade = (float) (Float.parseFloat(Dg) + 0.5);
                    }

                    if (sG.length() > 0){
                        scaredGrade = Float.parseFloat(sG);
                    }

                    if (sGW.length() > 0){
                        scaredGradeWeight = (float) Float.parseFloat(sGW);
                    }


                    String[] arrayS = S.split(" ");

                    float[] vectorGrades = new float[arrayS.length];
                    float[] vectorWeights = new float[arrayS.length];

                    for (int i = 0; i < arrayS.length; i++) {
                        vectorGrades[i] = Float.parseFloat(arrayS[i]);

                    }



                if(T != null && !T.isEmpty()) {

                    String[] arrayT;

                    String[] arrayTmp = T.split(" ");

                    if(arrayTmp.length>arrayS.length) {
                        arrayT = new String[arrayS.length];
                    }
                    else{
                        arrayT = new String[arrayTmp.length];
                    }

                        for (int i = 0; i < arrayT.length; i++) {
                            arrayT[i] = arrayTmp[i];
                        }



                    for (int i = 0; i < arrayT.length; i++) {
                        vectorWeights[i] = Float.parseFloat(arrayT[i]);

                    }

                    if (arrayT.length < arrayS.length) {
                        for (int i = arrayT.length; i < arrayS.length; i++) {
                            vectorWeights[i] = 1;
                        }
                    }
                }
                else {
                    for (int i = 0; i < arrayS.length; i++) {
                        vectorWeights[i] = 1;
                    }
                }

                    for (int i = 0; i < vectorWeights.length; i++) {
                        numberOfGrades += vectorWeights[i];
                    }
                    for (int i = 0; i < vectorGrades.length; i++) {
                        sum += vectorWeights[i] * vectorGrades[i];
                    }

                    average = sum/numberOfGrades;
///*
                    if (!(Dg.length() > 0 || sG.length() > 0 || sGW.length() > 0)){
                        scaredGrade = 4;
                    }

                    if (!((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade))){
                        if (!(Dg.length() > 0 || sG.length() > 0 || sGW.length() > 0)) {

                            desiredGrade = 4;

                            if (!((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade))) {
                                scaredGrade = 1;
                                desiredGrade = (float) 1.5;
                            }
                        }
                    }
//*/

/*
                    if ((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade)){


                    if (scaredGrade > desiredGrade && average < desiredGrade) {
                        while (sum / numberOfGrades < desiredGrade) {
                            sum += scaredGrade * scaredGradeWeight;
                            numberOfGrades += scaredGradeWeight;
                            count++;
                        }
                        sum -= (scaredGrade*scaredGradeWeight);
                        numberOfGrades -= scaredGradeWeight;
                        count--;
                    }
                    if (scaredGrade < desiredGrade && average >=  desiredGrade) {
                        while (sum / numberOfGrades >= desiredGrade) {
                            sum += scaredGrade * scaredGradeWeight;
                            numberOfGrades += scaredGradeWeight;
                            count++;
                        }

                    }

                    int OscaredGrade = (int) scaredGrade;
                    int OdesiredGrade = (int) desiredGrade;

                    String one = getResources().getString(R.string.one);
                    String two = getResources().getString(R.string.two);
                    String three = getResources().getString(R.string.three);
                    String four = getResources().getString(R.string.four);
                    String five = getResources().getString(R.string.five);



                    output = one + " " + String.valueOf(average) + two + " "  + String.valueOf(count) + " "  +  three + " "  + String.valueOf(OscaredGrade) + " "  + four + " "  + String.valueOf(sum/numberOfGrades) + " "  + five + " "  + String.valueOf(OdesiredGrade) + ".";
                    txtView.setText(output);
                }
                 else{

                        String one = getResources().getString(R.string.one);
                        String six;
                        if (Dg.length() > 0 || sG.length() > 0 || sGW.length() > 0) {
                            six = getResources().getString(R.string.six);
                        }
                        else {
                            six = "\n";
                        }


                        output = one + " " + String.valueOf(average) + six;
                        txtView.setText(output);
                    }


                }
                catch (Exception e){
                    txtView.setText(getResources().getString(R.string.error_console));
               }
            }
        });*/
    }
}
