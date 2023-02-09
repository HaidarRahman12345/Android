package com.example.haidarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class InputControl extends AppCompatActivity {

    TextView tv_values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_control);

        SeekBar seekBar = findViewById(R.id.seekBar);
        tv_values = findViewById(R.id.tv_values);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String values = String.format("%d%%", i);
                tv_values.setText(values);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv_values.setText("Started!");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_values.setText("Stopped!");

            }
        });
    }
}