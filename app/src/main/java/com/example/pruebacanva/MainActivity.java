package com.example.pruebacanva;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSlope, editTextIntercept;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSlope = findViewById(R.id.editTextSlope);
        editTextIntercept = findViewById(R.id.editTextIntercept);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén los valores de la pendiente y la ordenada al origen
                float slope = Float.parseFloat(editTextSlope.getText().toString());
                float intercept = Float.parseFloat(editTextIntercept.getText().toString());

                // Envía los valores a la segunda pantalla
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                intent.putExtra("slope", slope);
                intent.putExtra("intercept", intercept);
                startActivity(intent);
            }
        });
    }
}
