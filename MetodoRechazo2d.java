import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MetodoRechazo2d {
    
    public static void main(String[] args) {
        double x1min = 4;
        double x1max = 5;
        double x2min = 5;
        double x2max = 6;
        double y1 = 5.0/4.0;
        double y2 = -9.0/4.0;
        
        XYSeries series1 = new XYSeries("f(x) = -x/2 + 5/4");
        XYSeries series2 = new XYSeries("f2(x) = x/2 - 9/4");
        
        // Agregar puntos para la primera función
        for(double x = x1min; x <= x1max; x += 0.01) {
            double y = -x/2.0 + y1;
            series1.add(x, y);
        }
        
        // Agregar puntos para la segunda función
        for(double x = x2min; x <= x2max; x += 0.01) {
            double y = x/2.0 + y2;
            series2.add(x, y);
        }
        
        // Crear el conjunto de datos
        XYSeriesCollection dataset = new XYSeriesCollection();
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
        
        // Mostrar el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Gráfico de funciones", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
