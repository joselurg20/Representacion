package com.example.pruebacanva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pruebacanva.CustomView;


public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // Obtén los valores de la pendiente y la ordenada al origen de la intención
        float slope = getIntent().getFloatExtra("slope", 0.0f);
        float intercept = getIntent().getFloatExtra("intercept", 0.0f);

        // Envía los valores a la vista CustomView para dibujar la gráfica
        CustomView customView = findViewById(R.id.customView);
        customView.setEquation(slope, intercept);
    }
}

