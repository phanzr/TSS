
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class MetodoRechazo2b {
    public static void main(String[] args) {
        // Crear las funciones a graficar
        Function2D f1 = new Function2D() {
            public double getValue(double x) {
                if (x >= 0 && x <= 1) {
                    return 0.25;
                } else {
                    return Double.NaN;
                }
            }
        };

        Function2D f2 = new Function2D() {
            public double getValue(double x) {
                if (x >= 1 && x <= 1.5) {
                    return 3 * x - 2.75;
                } else {
                    return Double.NaN;
                }
            }
        };

        // Crear los datasets y agregar las funciones
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = DatasetUtilities.sampleFunction2DToSeries(f1, 0, 1, 100, "f(x) = 1/4");
        XYSeries series2 = DatasetUtilities.sampleFunction2DToSeries(f2, 1, 1.5, 100, "f2(x) = 3x - 11/4");
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de funciones",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Crear la ventana y agregar el gráfico
        JFrame frame = new JFrame("Gráfico de funciones");
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
