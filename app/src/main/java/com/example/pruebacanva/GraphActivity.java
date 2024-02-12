package com.example.pruebacanva;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class GraphActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // Obtén los coeficientes de la parábola de la intención
        float a = getIntent().getFloatExtra("a", 0.0f);
        float b = getIntent().getFloatExtra("b", 0.0f);
        float c = getIntent().getFloatExtra("c", 0.0f);

        // Obtén el color seleccionado de la intención
        int color = getIntent().getIntExtra("color", Color.BLUE); // Color predeterminado si no se recibe nada

        // Envía los coeficientes a la vista CustomView para dibujar la parábola
        CustomView customView = findViewById(R.id.customView);
        customView.setParabolaParams(a, b, c);
        customView.setLineColor(color); // Establecer el color de la línea

        // Agregar el OnClickListener al botón "Volver"
        Button volverButton = findViewById(R.id.button);
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a MainActivity
                Intent intent = new Intent(GraphActivity.this, MainActivity.class);
                startActivity(intent);
                // Finalizar la actividad actual
                finish();
            }
        });
    }
    }

