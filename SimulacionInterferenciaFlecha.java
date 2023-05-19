import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SimulacionInterferenciaFlecha {
    public static void main(String[] args) {
        double media1 = 1.5;
        double varianza1 = 0.0016;
        double desviacion1 = Math.sqrt(varianza1);

        double media2 = 1.48;
        double varianza2 = 0.0009;
        double desviacion2 = Math.sqrt(varianza2);

        double n = 30.0; // número de veces que se repite el experimento
        double p = 0.0; // probabilidad estimada de interferencia
        double d = 0.01; // tolerancia de error maximo
        double z = 1.96; // valor crítico de z para un nivel de confianza del 95%

        int iteraciones = 0;
        int sumatoria = 0; // variable para sumar la cantidad de veces que se produce interferencia
        int maxIteraciones = 8676; // número máximo de iteraciones

        Random rnd = new Random();
        System.out.println("Generación de variables aleatorias:");
        System.out.println("n\t       X1   \t       X2   \t       Interferencia");

        while (iteraciones < maxIteraciones) {
            double x1 = rnd.nextGaussian() * desviacion1 + media1;
            double x2 = rnd.nextGaussian() * desviacion2 + media2;
            sumatoria += ((x1 + x2) > 3) ? 1 : 0;
            iteraciones++;
            p = (double) sumatoria / iteraciones;
            double error = z * Math.sqrt(p * (1 - p) / iteraciones);
            System.out.println(iteraciones + "\t" + x1 + "\t" + x2 +"\t" + sumatoria);

        }

        System.out.println("Tras realizar " + iteraciones + " iteraciones, se obtuvo una probabilidad estimada de " + p);
    
    
    // Creacion de serie de datos para la probabilidad estimada de interferencia
    XYSeries series = new XYSeries("");

    for (int i = 1; i <= iteraciones; i++) {
        double prob = (double) (sumatoria / i);
        series.add(i, prob);
    }

    // Creacion de colección de series de datos y agregar la serie
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);

    // Creacion de gráfico
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Probabilidad de interferencia", // Título del gráfico
        "Número de iteraciones", // Etiqueta eje X
        "Probabilidad", // Etiqueta eje Y
        dataset, // Colección de series de datos
        PlotOrientation.VERTICAL, // Orientación del gráfico
        true, // Mostrar leyenda
        true, // Usar tooltips
        false // No usar URLs
    );

    // Mostrar el gráfico en una ventana
    ChartFrame frame = new ChartFrame("Gráfico de simulación", chart);
    frame.pack();
    frame.setVisible(true);
    }
}
