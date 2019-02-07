package etlantis.gradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TabHelp extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_second, container, false);
/*
        ImageButton backB = (ImageButton) view.findViewById(R.id.imageButton);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(1);
            }
        });


        ImageButton sett = (ImageButton) view.findViewById(R.id.imageButton7);
        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabbedActivity.mViewPager.setCurrentItem(0);
            }
        });
*/
        return view;
    }
}
