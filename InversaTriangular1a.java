import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
//import org.jfree.*;

public class InversaTriangular1a{
    public static void main(String[] args) {
        double a = 2; // Valor de a
        double b = 4; // Valor de b
        double c = 6; // Valor de c

        double[] x1 = new double[101]; // Valores de x para la función 1
        double[] y1 = new double[101]; // Valores de la función 1
        double[] x2 = new double[101]; // Valores de x para la función 2
        double[] y2 = new double[101]; // Valores de la función 2

        // Calcula los valores para la función 1
        for (int i = 0; i <= 100; i++) {
            double x = a + (b - a) * i / 100;
            if (x <= b) {
                x1[i] = x;
                y1[i] = 2 * (x - a) / Math.pow(b - a, 2);
            }
        }

        // Calcula los valores para la función 2
        for (int i = 0; i <= 100; i++) {
            double x = b + (c - b) * i / 100;
            if (x <= c) {
                x2[i] = x;
                y2[i] = -2 * (x - c) / Math.pow(c - b, 2);
            }
        }

        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data1 = { x1, y1 };
        double[][] data2 = { x2, y2 };
        dataset.addSeries("f(x) = 2(x-a)/(b-a)^2", data1);
        dataset.addSeries("f2(x) = -2(x-c)/(c-b)^2",data2);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "a)Metodo rechazo",
                "x", // Etiqueta eje x
                "y", // Etiqueta eje y
                dataset // Datos
        );
        
        ChartFrame frame = new ChartFrame("", chart);
        frame.pack();
        frame.setVisible(true);
    }
}