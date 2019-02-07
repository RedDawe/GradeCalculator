package etlantis.gradecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.EventListener;
import java.util.regex.Pattern;

public class TabCalc extends Fragment {
    //static boolean tbB;
    //static boolean swB;
    static boolean cbB;
    static String min;
    static String pls;
    static int irh;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_main, container, false);

        final SharedPreferences sharedPrefe = getContext().getSharedPreferences("vall", Context.MODE_PRIVATE);

/*

        ImageButton linkw = (ImageButton) view.findViewById(R.id.imageButton3);
        linkw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openw = new Intent(Intent.ACTION_VIEW, Uri.parse("https://etlantis.bitballoon.com/"));
                startActivity(openw);
            }
        });

        ImageButton help = (ImageButton) view.findViewById(R.id.imageButton2);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(2);
            }
        });

        ImageButton sett = (ImageButton) view.findViewById(R.id.imageButton5);
        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(0);
            }
        });
*/
        Button calculate = (Button) view.findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditText sO = (EditText) view.findViewById(R.id.editText);
                //String S = sO.getText().toString();
                String S = ((EditText) view.findViewById(R.id.editText)).getText().toString();
                EditText tO = (EditText) view.findViewById(R.id.editText2);
                String T =  tO.getText().toString();
                // T = T.substring(0, S.lenght())
                TextView txtView = (TextView) view.findViewById(R.id.textView);
                EditText dGO = (EditText) view.findViewById(R.id.editText5);
                String Dg = dGO.getText().toString();
                EditText sGO = (EditText) view.findViewById(R.id.editText3);
                String sG = sGO.getText().toString();
                EditText sGWO = (EditText) view.findViewById(R.id.editText4);
                String sGW = sGWO.getText().toString();

                String output;

                float numberOfGrades = 0;
                float sum = 0;
                int count = 0;
                float desiredGrade = (float) (3.5);
                float scaredGrade = 5;
                float scaredGradeWeight = 1;
                float average;
                boolean hopeididntusethiselsewhere = true;

                //tbB = sharedPrefe.getBoolean("tbs", false);
                //swB = sharedPrefe.getBoolean("sws", false);
                cbB = sharedPrefe.getBoolean("cbs", true);
                irh = sharedPrefe.getInt("sbI", 1);

                switch (irh){
                    case 0:
                        hopeididntusethiselsewhere = false;
                        break;
                    case 1:
                        if (S.contains("A")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("B")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("C")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("D")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("E")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("F")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("a")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("b")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("c")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("d")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("e")) {
                            hopeididntusethiselsewhere = false;
                        }
                        if (S.contains("f")) {
                            hopeididntusethiselsewhere = false;
                        }
                        break;
                    default:
                        break;

                }

/*
                if (!tbB) {
                    if (S.contains("A")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("B")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("C")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("D")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("E")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("F")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("a")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("b")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("c")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("d")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("e")) {
                        hopeididntusethiselsewhere = false;
                    }
                    if (S.contains("f")) {
                        hopeididntusethiselsewhere = false;
                    }
                }
                else {
                    hopeididntusethiselsewhere = swB;
                }
*/

                if(cbB){
                    if(hopeididntusethiselsewhere){
                        if(Float.parseFloat(sharedPrefe.getString("minus", "-0.3")) < 0){
                            min = String.valueOf(Float.parseFloat(sharedPrefe.getString("minus", "-0.3")) * -1);
                        }
                        else {
                            min = sharedPrefe.getString("minus", "-0.3");
                        }
                        if( Float.parseFloat(sharedPrefe.getString("plus", "0.3")) > 0){
                            pls = String.valueOf(Float.parseFloat(sharedPrefe.getString("plus", "0.3")) * -1);
                        }
                        else {
                            pls = sharedPrefe.getString("plus", "0.3");
                        }
                    }
                    else {
                        if(Float.parseFloat(sharedPrefe.getString("minus", "-0.3")) > 0){
                            min = String.valueOf(Float.parseFloat(sharedPrefe.getString("minus", "-0.3")) * -1);
                        }
                        else {
                            min = sharedPrefe.getString("minus", "-0.3");
                        }
                        if( Float.parseFloat(sharedPrefe.getString("plus", "0.3")) < 0){
                            pls = String.valueOf(Float.parseFloat(sharedPrefe.getString("plus", "0.3")) * -1);
                        }
                        else {
                            pls = sharedPrefe.getString("plus", "0.3");
                        }
                    }
                }
                else {
                    min = sharedPrefe.getString("minus", "-0.3");
                    pls = sharedPrefe.getString("plus", "0.3");
                }


                try {

                        S = S.replaceAll(",", ".");
                        S = S.replaceAll("a", "A");
                        S = S.replaceAll("b", "B");
                        S = S.replaceAll("c", "C");
                        S = S.replaceAll("d", "D");
                        S = S.replaceAll("e", "E");
                        S = S.replaceAll("f", "F");
                        S = S.replaceAll("/2", ".5");
                        S = S.replaceAll("/3", ".5");
                        S = S.replaceAll("/4", ".5");
                        S = S.replaceAll("/5", ".5");


                    if (!T.isEmpty() && T.length()!=0) {
                        T = T.replaceAll(",", ".");
                        T = T.replaceAll("a", "A");
                        T = T.replaceAll("b", "B");
                        T = T.replaceAll("c", "C");
                        T = T.replaceAll("d", "D");
                        T = T.replaceAll("e", "E");
                        T = T.replaceAll("f", "F");
                        T = T.replaceAll("/2", ".5");
                        T = T.replaceAll("/3", ".5");
                        T = T.replaceAll("/4", ".5");
                        T = T.replaceAll("/5", ".5");
                    }

                    if (!Dg.isEmpty() && Dg.length()!=0) {
                        Dg = Dg.replaceAll(",", ".");
                        Dg = Dg.replaceAll("a", "A");
                        Dg = Dg.replaceAll("b", "B");
                        Dg = Dg.replaceAll("c", "C");
                        Dg = Dg.replaceAll("d", "D");
                        Dg = Dg.replaceAll("e", "E");
                        Dg = Dg.replaceAll("f", "F");
                        Dg = Dg.replaceAll("/2", ".5");
                        Dg = Dg.replaceAll("/3", ".5");
                        Dg = Dg.replaceAll("/4", ".5");
                        Dg = Dg.replaceAll("/5", ".5");

                        if (Dg.equals("A+")){
                            Dg = String.valueOf(4 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("A")){
                            Dg = String.valueOf(4);
                        }
                        if (Dg.equals("A-")){
                            Dg = String.valueOf(4 + Float.parseFloat(min));
                        }
                        if (Dg.equals("B+")){
                            Dg = String.valueOf(3 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("B")){
                            Dg = String.valueOf(3);
                        }
                        if (Dg.equals("B-")){
                            Dg = String.valueOf(3 + Float.parseFloat(min));
                        }
                        if (Dg.equals("C+")){
                            Dg = String.valueOf(2 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("C")){
                            Dg = String.valueOf(2);
                        }
                        if (Dg.equals("C-")){
                            Dg = String.valueOf(2 + Float.parseFloat(min));
                        }
                        if (Dg.equals("D+")){
                            Dg = String.valueOf(1 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("D")){
                            Dg = String.valueOf(1);
                        }
                        if (Dg.equals("D-")){
                            Dg = String.valueOf(1 + Float.parseFloat(min));
                        }
                        if (Dg.equals("E+")){
                            Dg = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("E")){
                            Dg = String.valueOf(0);
                        }
                        if (Dg.equals("F+")){
                            Dg = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (Dg.equals("F")){
                            Dg = String.valueOf(0);
                        }
                        if (Dg.contains("-")){
                            Dg = Dg.replace("-", "");
                            Dg = String.valueOf(Float.parseFloat(Dg) + min);
                        }
                        if (Dg.contains("+")){
                            Dg = Dg.replace("+", "");
                            Dg = String.valueOf(Float.parseFloat(Dg) + pls);
                        }
                    }

                    if (!sG.isEmpty() && sG.length()!=0) {
                        sG = sG.replaceAll(",", ".");
                        sG = sG.replaceAll("a", "A");
                        sG = sG.replaceAll("b", "B");
                        sG = sG.replaceAll("c", "C");
                        sG = sG.replaceAll("d", "D");
                        sG = sG.replaceAll("e", "E");
                        sG = sG.replaceAll("f", "F");
                        sG = sG.replaceAll("/2", ".5");
                        sG = sG.replaceAll("/3", ".5");
                        sG = sG.replaceAll("/4", ".5");
                        sG = sG.replaceAll("/5", ".5");

                        if (sG.equals("A+")){
                            sG = String.valueOf(4 + Float.parseFloat(pls));
                        }
                        if (sG.equals("A")){
                            sG = String.valueOf(4);
                        }
                        if (sG.equals("A-")){
                            sG = String.valueOf(4 + Float.parseFloat(min));
                        }
                        if (sG.equals("B+")){
                            sG = String.valueOf(3 + Float.parseFloat(pls));
                        }
                        if (sG.equals("B")){
                            sG = String.valueOf(3);
                        }
                        if (sG.equals("B-")){
                            sG = String.valueOf(3 + Float.parseFloat(min));
                        }
                        if (sG.equals("C+")){
                            sG = String.valueOf(2 + Float.parseFloat(pls));
                        }
                        if (sG.equals("C")){
                            sG = String.valueOf(2);
                        }
                        if (sG.equals("C-")){
                            sG = String.valueOf(2 + Float.parseFloat(min));
                        }
                        if (sG.equals("D+")){
                            sG = String.valueOf(1 + Float.parseFloat(pls));
                        }
                        if (sG.equals("D")){
                            sG = String.valueOf(1);
                        }
                        if (sG.equals("D-")){
                            sG = String.valueOf(1 + Float.parseFloat(min));
                        }
                        if (sG.equals("E+")){
                            sG = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (sG.equals("E")){
                            sG = String.valueOf(0);
                        }
                        if (sG.equals("F+")){
                            sG = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (sG.equals("F")){
                            sG = String.valueOf(0);
                        }
                        if (sG.contains("-")){
                            sG = sG.replace("-", "");
                            sG = String.valueOf(Float.parseFloat(sG) + min);
                        }
                        if (sG.contains("+")){
                            sG = sG.replace("+", "");
                            sG = String.valueOf(Float.parseFloat(sG) + pls);
                        }
                    }

                    if (!sGW.isEmpty() && sGW.length()!=0) {
                        sGW = sGW.replaceAll(",", ".");
                        sGW = sGW.replaceAll("a", "A");
                        sGW = sGW.replaceAll("b", "B");
                        sGW = sGW.replaceAll("c", "C");
                        sGW = sGW.replaceAll("d", "D");
                        sGW = sGW.replaceAll("e", "E");
                        sGW = sGW.replaceAll("f", "F");
                        sGW = sGW.replaceAll("/2", ".5");
                        sGW = sGW.replaceAll("/3", ".5");
                        sGW = sGW.replaceAll("/4", ".5");
                        sGW = sGW.replaceAll("/5", ".5");

                        if (sGW.equals("A+")){
                            sGW = String.valueOf(4 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("A")){
                            sGW = String.valueOf(4);
                        }
                        if (sGW.equals("A-")){
                            sGW = String.valueOf(4 + Float.parseFloat(min));
                        }
                        if (sGW.equals("B+")){
                            sGW = String.valueOf(3 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("B")){
                            sGW = String.valueOf(3);
                        }
                        if (sGW.equals("B-")){
                            sGW = String.valueOf(3 + Float.parseFloat(min));
                        }
                        if (sGW.equals("C+")){
                            sGW = String.valueOf(2 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("C")){
                            sGW = String.valueOf(2);
                        }
                        if (sGW.equals("C-")){
                            sGW = String.valueOf(2 + Float.parseFloat(min));
                        }
                        if (sGW.equals("D+")){
                            sGW = String.valueOf(1 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("D")){
                            sGW = String.valueOf(1);
                        }
                        if (sGW.equals("D-")){
                            sGW = String.valueOf(1 + Float.parseFloat(min));
                        }
                        if (sGW.equals("E+")){
                            sGW = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("E")){
                            sGW = String.valueOf(0);
                        }
                        if (sGW.equals("F+")){
                            sGW = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (sGW.equals("F")){
                            sGW = String.valueOf(0);
                        }
                        if (sGW.contains("-")){
                            sGW = sGW.replace("-", "");
                            sGW = String.valueOf(Float.parseFloat(sGW) + min);
                        }
                        if (sGW.contains("+")){
                            sGW = sGW.replace("+", "");
                            sGW = String.valueOf(Float.parseFloat(sGW) + pls);
                        }
                    }





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

                        if (arrayS[i].equals("A+")){
                            arrayS[i] = String.valueOf(4 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("A")){
                            arrayS[i] = String.valueOf(4);
                        }
                        if (arrayS[i].equals("A-")){
                            arrayS[i] = String.valueOf(4 + Float.parseFloat(min));
                        }
                        if (arrayS[i].equals("B+")){
                            arrayS[i] = String.valueOf(3 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("B")){
                            arrayS[i] = String.valueOf(3);
                        }
                        if (arrayS[i].equals("B-")){
                            arrayS[i] = String.valueOf(3 + Float.parseFloat(min));
                        }
                        if (arrayS[i].equals("C+")){
                            arrayS[i] = String.valueOf(2 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("C")){
                            arrayS[i] = String.valueOf(2);
                        }
                        if (arrayS[i].equals("C-")){
                            arrayS[i] = String.valueOf(2 + Float.parseFloat(min));
                        }
                        if (arrayS[i].equals("D+")){
                            arrayS[i] = String.valueOf(1 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("D")){
                            arrayS[i] = String.valueOf(1);
                        }
                        if (arrayS[i].equals("D-")){
                            arrayS[i] = String.valueOf(1 + Float.parseFloat(min));
                        }
                        if (arrayS[i].equals("E+")){
                            arrayS[i] = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("E")){
                            arrayS[i] = String.valueOf(0);
                        }
                        if (arrayS[i].equals("F+")){
                            arrayS[i] = String.valueOf(0 + Float.parseFloat(pls));
                        }
                        if (arrayS[i].equals("F")){
                            arrayS[i] = String.valueOf(0);
                        }
                        if (arrayS[i].contains("-")){
                            arrayS[i] = arrayS[i].replace("-", "");
                            arrayS[i] = String.valueOf(Float.parseFloat(arrayS[i]) + Float.parseFloat(min));
                        }
                        if (arrayS[i].contains("+")){
                            arrayS[i] = arrayS[i].replace("+", "");
                            arrayS[i] = String.valueOf(Float.parseFloat(arrayS[i]) + Float.parseFloat(pls));
                        }


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
                            if (arrayTmp[i].equals("A+")){
                                arrayT[i] = String.valueOf(4 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("A")){
                                arrayT[i] = String.valueOf(4);
                            }
                            else if (arrayTmp[i].equals("A-")){
                                arrayT[i] = String.valueOf(4 + Float.parseFloat(min));
                            }
                            else if (arrayTmp[i].equals("B+")){
                                arrayT[i] = String.valueOf(3 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("B")){
                                arrayT[i] = String.valueOf(3);
                            }
                            else if (arrayTmp[i].equals("B-")){
                                arrayT[i] = String.valueOf(3 + Float.parseFloat(min));
                            }
                            else if (arrayTmp[i].equals("C+")){
                                arrayT[i] = String.valueOf(2 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("C")){
                                arrayT[i] = String.valueOf(2);
                            }
                            else if (arrayTmp[i].equals("C-")){
                                arrayT[i] = String.valueOf(2 + Float.parseFloat(min));
                            }
                            else if (arrayTmp[i].equals("D+")){
                                arrayT[i] = String.valueOf(1 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("D")){
                                arrayT[i] = String.valueOf(1);
                            }
                            else if (arrayTmp[i].equals("D-")){
                                arrayT[i] = String.valueOf(1 + Float.parseFloat(min));
                            }
                            else if (arrayTmp[i].equals("E+")){
                                arrayT[i] = String.valueOf(0 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("E")){
                                arrayT[i] = String.valueOf(0);
                            }
                            else if (arrayTmp[i].equals("F+")){
                                arrayT[i] = String.valueOf(0 + Float.parseFloat(pls));
                            }
                            else if (arrayTmp[i].equals("F")){
                                arrayT[i] = String.valueOf(0);
                            }
                            else if (arrayTmp[i].contains("-")){
                                arrayTmp[i] = arrayTmp[i].replace("-", "");
                                arrayT[i] = String.valueOf(Float.parseFloat(arrayTmp[i]) + min);
                            }
                            else if (arrayTmp[i].contains("+")){
                                arrayTmp[i] = arrayTmp[i].replace("+", "");
                                arrayT[i] = String.valueOf(Float.parseFloat(arrayTmp[i]) + pls);
                            }
                            else {
                                arrayT[i] = arrayTmp[i];
                            }
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
                    //////////////////////////////////////////////////////////////////////////////////

                    ///*
                    if (!(Dg.length() > 0 || sG.length() > 0 || sGW.length() > 0)) {

                        if(hopeididntusethiselsewhere){
                            if (!((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade))) {
                                if (!(Dg.length() > 0 || sG.length() > 0 || sGW.length() > 0)) {

                                    desiredGrade = 4;

                                    if (!((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade))) {
                                        scaredGrade = 1;
                                        desiredGrade = (float) 1.5;
                                        if (!((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade))) {
                                            desiredGrade = (float) 2.5;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            scaredGrade = 4;

                            if (!((scaredGrade >= desiredGrade-1 && average < desiredGrade-1) || (scaredGrade < desiredGrade-1 && average >= desiredGrade-1))){
                                desiredGrade = 4;

                                if (!((scaredGrade >= desiredGrade-1 && average < desiredGrade-1) || (scaredGrade < desiredGrade-1 && average >= desiredGrade-1))){
                                    scaredGrade = 1;
                                    desiredGrade = (float) 2.5;
                                    if (!((scaredGrade >= desiredGrade-1 && average < desiredGrade-1) || (scaredGrade < desiredGrade-1 && average >= desiredGrade-1))){
                                        scaredGrade = 0;
                                        desiredGrade = (float) 1.5;
                                    }
                                }
                            }

                        }

                    }
                    //*/

                    if (((scaredGrade > desiredGrade && average < desiredGrade) || (scaredGrade < desiredGrade && average >= desiredGrade)) && hopeididntusethiselsewhere){


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
                    else if ((scaredGrade >= desiredGrade-1 && average < desiredGrade-1) || (scaredGrade < desiredGrade-1 && average >= desiredGrade-1)){
                        if (scaredGrade >= desiredGrade-1 && average < desiredGrade-1) {
                            while (sum / numberOfGrades < desiredGrade - 1) {
                                sum += scaredGrade * scaredGradeWeight;
                                numberOfGrades += scaredGradeWeight;
                                count++;
                            }
                        }
                        if (scaredGrade < desiredGrade-1 && average >=  desiredGrade-1) {
                            while (sum / numberOfGrades >= desiredGrade - 1) {
                                sum += scaredGrade * scaredGradeWeight;
                                numberOfGrades += scaredGradeWeight;
                                count++;
                            }
                            sum -= (scaredGrade*scaredGradeWeight);
                            numberOfGrades -= scaredGradeWeight;
                            count--;

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
        });


        return view;
    }
}
