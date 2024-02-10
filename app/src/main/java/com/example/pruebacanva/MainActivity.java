package com.example.pruebacanva;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private Button buttonEnviar;
    private RadioGroup colorRadioGroup; // Declaración del RadioGroup

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de las vistas
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        colorRadioGroup = findViewById(R.id.colorRadioGroup); // Inicialización del RadioGroup

        // Definición del Listener del botón "Enviar"
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(editTextA.getText().toString());
                float b = Float.parseFloat(editTextB.getText().toString());
                float c = Float.parseFloat(editTextC.getText().toString());

                // Obtener el color seleccionado
                int color = Color.BLACK; // Color predeterminado si no se selecciona nada
                int selectedId = colorRadioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.redRadioButton) {
                    color = Color.RED;
                } else if (selectedId == R.id.blueRadioButton) {
                    color = Color.BLUE;
                } else if (selectedId == R.id.greenRadioButton) {
                    color = Color.GREEN;
                }

                // Enviar los valores y el color a la segunda pantalla
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                intent.putExtra("a", a);
                intent.putExtra("b", b);
                intent.putExtra("c", c);
                intent.putExtra("color", color); // Enviar el color seleccionado
                startActivity(intent);
            }
        });
    }
}
