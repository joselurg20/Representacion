package com.example.pruebacanva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;
    private SeekBar seekBarSlope, seekBarIntercept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = findViewById(R.id.customView);
        seekBarSlope = findViewById(R.id.seekBarSlope);
        seekBarIntercept = findViewById(R.id.seekBarIntercept);

        // Configura los rangos de las SeekBars según tus necesidades
        seekBarSlope.setMax(10);
        seekBarSlope.setProgress(5);
        seekBarIntercept.setMax(100);
        seekBarIntercept.setProgress(50);

        // Configura los listeners de las SeekBars
        seekBarSlope.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float slope = (float) (progress - 5) / 5;
                customView.setEquation(slope, customView.getIntercept());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarIntercept.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float intercept = (float) (progress - 50);
                customView.setEquation(customView.getSlope(), intercept);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}