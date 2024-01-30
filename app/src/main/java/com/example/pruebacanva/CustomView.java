package com.example.pruebacanva;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private Paint paintAxes, paintGraph;
    private float slope = 1.0f;  // Pendiente inicial
    private float intercept = 0.0f;  // Ordenada al origen inicial

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintAxes = new Paint();
        paintAxes.setColor(Color.BLACK);
        paintAxes.setStrokeWidth(5f);

        paintGraph = new Paint();
        paintGraph.setColor(Color.BLUE);
        paintGraph.setStrokeWidth(5f);
    }

    // Método para cambiar los valores de la ecuación
    public void setEquation(float slope, float intercept) {
        this.slope = slope;
        this.intercept = intercept;
        invalidate();  // Vuelve a dibujar la vista
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibuja los ejes
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paintAxes);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paintAxes);

        // Dibuja la gráfica de la ecuación de la línea
        drawGraph(canvas);
    }

    private void drawGraph(Canvas canvas) {
        float startX = 0;
        float startY = intercept + slope * startX;

        for (float x = 1; x <= getWidth(); x++) {
            float y = intercept + slope * x;
            canvas.drawLine(startX, startY, x, y, paintGraph);
            startX = x;
            startY = y;
        }
    }

    // Método para obtener el valor de la ordenada al origen
    public float getIntercept() {
        return intercept;
    }

    // Método para obtener el valor de la pendiente
    public float getSlope() {
        return slope;
    }
}
