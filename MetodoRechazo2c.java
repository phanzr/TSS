import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
import java.awt.*;

public class MetodoRechazo2c extends JFrame {

    public MetodoRechazo2c() {
        super("");

        // Crear dataset con los valores de las funciones
        DefaultXYDataset dataset = new DefaultXYDataset();
        
        double[][] f1 = { {0, 1, 1, 0}, {0.75, 0.75, 0, 0} };
        double[][] f2 = { {1, 2, 2, 1}, {0.25, 0.25, 0, 0} };

        dataset.addSeries("f(x) = 3/4", f1);
        dataset.addSeries("f2(x) = 1/4", f2);

        // Crear el gráfico y personalizarlo
        JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, dataset);
        chart.setBackgroundPaint(Color.WHITE);
        XYPlot plot = (XYPlot) chart.getPlot();

        // Personalizar los ejes
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(0, 2);
        domain.setVerticalTickLabels(false);
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0, 1);

        // Personalizar las líneas de las funciones
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        plot.setRenderer(renderer);

        // Crear el panel que contendrá el gráfico y añadirlo a la ventana
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MetodoRechazo2c();
    }
}
