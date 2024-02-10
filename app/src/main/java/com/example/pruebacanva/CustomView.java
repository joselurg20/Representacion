package com.example.pruebacanva;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private Paint paintAxes, paintGraph;
    private float a = 0.0f;  // Coeficiente 'a' inicial
    private float b = 0.0f;  // Coeficiente 'b' inicial
    private float c = 0.0f;  // Coeficiente 'c' inicial
    private float scaleX, scaleY;

    private int lineColor = Color.BLUE; // Color predeterminado

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintAxes = new Paint();
        paintAxes.setColor(Color.BLACK);
        paintAxes.setStrokeWidth(5f);

        paintGraph = new Paint();
        paintGraph.setColor(lineColor);
        paintGraph.setStrokeWidth(5f);
    }

    // Método para establecer los coeficientes de la parábola
    public void setParabolaParams(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        invalidate();  // Vuelve a dibujar la vista
    }

    public void setLineColor(int color) {
        this.lineColor = color;
        paintGraph.setColor(color); // Establecer el color de la línea
        invalidate(); // Vuelve a dibujar la vista
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Calcula las escalas de conversión para ajustar la parábola al tamaño de la vista
        scaleX = getWidth() / 20f; // Ajusta el rango de -10 a 10
        scaleY = getHeight() / 20f; // Ajusta el rango de -10 a 10
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibuja los ejes
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paintAxes);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paintAxes);

        // Dibuja la gráfica de la parábola
        drawParabola(canvas);
    }

    private void drawParabola(Canvas canvas) {
        float prevX = -10;
        float prevY = calculateParabola(prevX);

        for (float x = -9.5f; x <= 10; x += 0.1f) { // Incremento más pequeño para una mayor resolución
            float y = calculateParabola(x);
            canvas.drawLine(prevX * scaleX + getWidth() / 2, -prevY * scaleY + getHeight() / 2,
                    x * scaleX + getWidth() / 2, -y * scaleY + getHeight() / 2, paintGraph);
            prevX = x;
            prevY = y;
        }
    }

    private float calculateParabola(float x) {
        // Calcula el valor de 'y' para la parábola utilizando la ecuación y = ax^2 + bx + c
        return a * x * x + b * x + c;
    }
}
