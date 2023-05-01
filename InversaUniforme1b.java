import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;

public class InversaUniforme1b {
    public static void main(String[] args) {
        double[] x1 = new double[101]; // Valores de x para la función 1
        double[] y1 = new double[101]; // Valores de la función 1
        double[] x2 = new double[101]; // Valores de x para la función 2
        double[] y2 = new double[101]; // Valores de la función 2

        // Calculo de valores para la función 1
        for (int i = 0; i <= 100; i++) {
            double x = i / 100.0;
            if (x >= 0 && x <= 1) {
                x1[i] = x;
                y1[i] = -x + 5.0 / 4.0;
            }
        }
        // Calculo de valores para la función 2
        for (int i = 0; i <= 100; i++) {
            double x = 1 + i / 100.0;
            if (x >= 1 && x <= 2) {
                x2[i] = x;
                y2[i] = 1.0 / 4.0;
            }
        }

        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data1 = { x1, y1 };
        double[][] data2 = { x2, y2 };
        dataset.addSeries("f(x) = -x + 5/4", data1);
        dataset.addSeries("f2(x) = 1/4", data2);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "1b. Transformada inversa, Distribucion Uniforme", // Título del gráfico
                "x", // Etiqueta eje x
                "y", // Etiqueta  eje y
                dataset // Datos
        );

        ChartFrame frame = new ChartFrame("1b. Transformada inversa, Distribucion Uniforme", chart);
        frame.pack();
        frame.setVisible(true);
    }
}