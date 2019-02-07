package etlantis.gradecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TabSet extends Fragment {
    //ToggleButton owTB;
    //Switch sw1;
    EditText etm;
    EditText etp;
    Button rsB;
    SeekBar seekB;
    //Button czB;
    CheckBox chB;



    @Override
    public void onPause() {
        super.onPause();
        save();
    }

    public void save() {
        final SharedPreferences sharedPref = getContext().getSharedPreferences("vall", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("minus", etm.getText().toString());
        editor.putString("plus", etp.getText().toString());
        editor.apply();
        TabCalc.min = etm.getText().toString();
        TabCalc.pls = etp.getText().toString();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.settings, container, false);

        final SharedPreferences sharedPref = getContext().getSharedPreferences("vall", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();



        //owTB = view.findViewById(R.id.toggleButton);
        //sw1 = view.findViewById(R.id.switch1);
        etm = view.findViewById(R.id.editText6);
        etp = view.findViewById(R.id.editText7);
        rsB = view.findViewById(R.id.button2);
        //czB = view.findViewById(R.id.button4);
        chB = view.findViewById(R.id.checkBox);
        seekB = view.findViewById(R.id.seekBar);

        String sTm = sharedPref.getString("minus", "-0.3");
        etm.setText(sTm, TextView.BufferType.EDITABLE);
        etp.setText(sharedPref.getString("plus", "0.3"), TextView.BufferType.EDITABLE);

        seekB.setProgress(sharedPref.getInt("sbI", 1));
        chB.setChecked(sharedPref.getBoolean("cbs", true));

        /*
        apB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("minus", etm.getText().toString());
                editor.putString("plus", etp.getText().toString());
                editor.apply();
                TabCalc.min = etm.getText().toString();
                TabCalc.pls = etp.getText().toString();
            }
        });


*/
        ImageButton ltwp = (ImageButton) view.findViewById(R.id.imageButton);
        ltwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openwp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://etlantis.bitballoon.com/"));
                startActivity(openwp);
            }
        });
/*
        czB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("minus", "0.3");
                editor.putString("plus", "-0.3");
                editor.apply();
                etm.setText(sharedPref.getString("minus", "0.3"));
                etp.setText(sharedPref.getString("plus", "-0.3"));
                TabCalc.min = etm.getText().toString();
                TabCalc.pls = etp.getText().toString();
            }
        });
*/

        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TabCalc.irh = i;
                editor.putInt("sbI", i);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("minus", "-0.3");
                editor.putString("plus", "0.3");
                editor.putBoolean("cbs", true);
                editor.putInt("sbI", 1);
                editor.apply();
                etm.setText(sharedPref.getString("minus", "-0.3"));
                etp.setText(sharedPref.getString("plus", "0.3"));
                TabCalc.min = etm.getText().toString();
                TabCalc.pls = etp.getText().toString();
                chB.setChecked(true);
                seekB.setProgress(1);
                TabCalc.cbB = true;
                TabCalc.irh = 1;
            }
        });

        chB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TabCalc.cbB = b;
                editor.putBoolean("cbs", b);
                editor.apply();
            }
        });
/*
        ImageButton backB = (ImageButton) view.findViewById(R.id.imageButton4);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(1);
            }
        });

        ImageButton help = (ImageButton) view.findViewById(R.id.imageButton6);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(2);
            }
        });*/
        return view;
    }
}
