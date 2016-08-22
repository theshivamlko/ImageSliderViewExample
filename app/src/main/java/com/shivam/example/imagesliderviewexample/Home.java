package com.shivam.example.imagesliderviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.shivam.example.imagesliderviewexample.R;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    TextView dp;
    String anim;
    Spinner spinner;
    SeekBar seekBar;
    int dpValue=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

        dp=(TextView) findViewById(R.id.textView);
        seekBar=(SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dp.setText("Indicator size: "+progress+"dp");
                dpValue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinner=(Spinner)findViewById(R.id.spinner);
        String[] items={"Default","Card Stack","Parallax","Fade"};
        spinner.setAdapter(new ArrayAdapter(Home.this,android.R.layout.simple_spinner_dropdown_item,android.R.id.text1,items));

    }

    @Override
    public void onClick(View v) {
        Bundle bundle=new Bundle();
        anim=spinner.getSelectedItem().toString();
        intent=new Intent(Home.this,MainActivity.class);
        // conditions for different view of ImageSlider

        switch (v.getId()) {
            case R.id.button:
                bundle.putBoolean("button1",true);
                break;
            case R.id.button2:
                int[] indicators={R.mipmap.indicator1,R.mipmap.indicator2};
                bundle.putBoolean("button2",true);
                bundle.putIntArray("indicator",indicators);      // putting 2 ids of custom indicator

                break;
            case R.id.button3:

                // putting all ids of custom indicator if you want every indicataor to be different
                // here ids_array==no of pages set in ImageSlide
                int[] indicators2={R.mipmap.home,R.mipmap.address,R.mipmap.contacts,R.mipmap.mapmarker};
                bundle.putBoolean("button3",true);
                bundle.putIntArray("indicator",indicators2);

                break;
            case R.id.button4:
                // no indicator can be used as ImageViewer array of images can be shown
                bundle.putBoolean("button4",true);
                break;

        }

        bundle.putInt("size",dpValue);
        bundle.putString("anim",anim);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
