
package tss4;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
import javax.swing.*;

public class MetodoRechazo2a {
    public static void main(String[] args) {
        // Crear la colección de series de datos
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Crear la primera serie de datos
        XYSeries series1 = new XYSeries("f(x) = 3/4");

        // Agregar los puntos a la primera serie de datos
        for (double x = 0; x <= 1; x += 0.01) {
            double y = 0.75;
            series1.add(x, y);
        }

        // Agregar la primera serie de datos a la colección
        dataset.addSeries(series1);

        // Crear la segunda serie de datos
        XYSeries series2 = new XYSeries("f2(x) = 15/8 - 9/8x");

        // Agregar los puntos a la segunda serie de datos
        for (double x = 1; x <= 5.0/3; x += 0.01) {
            double y = 15.0/8 - 9.0/8 * x;
            series2.add(x, y);
        }

        // Agregar la segunda serie de datos a la colección
        dataset.addSeries(series2);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "1a) Metodo de rechazo", // Título del gráfico
                "x", // Etiqueta del eje x
                "y", // Etiqueta del eje y
                dataset, // Colección de series de datos
                PlotOrientation.VERTICAL, // Orientación del gráfico
                true, // Mostrar leyenda
                true, // Mostrar tooltips
                false // No usar URLs
        );

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);

        // Crear el marco para el gráfico
        JFrame frame = new JFrame("");

        // Agregar el panel del gráfico al marco
        frame.getContentPane().add(chartPanel);

        // Configurar el marco
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
