import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MetodoRechazo2e {
    public static void main(String[] args) {
        XYSeries series1 = new XYSeries("f(x) = x/2 - 15/4");
        for (double x = 8.0; x <= 9.0; x += 0.01) {
            double y = x/2 - 15/4;
            series1.add(x, y);
        }

        XYSeries series2 = new XYSeries("f2(x) = -x/2 + 21/4");
          for (double x = 9.0; x <= 10.0; x += 0.01) {
            double y = -x/2 + 21/4;
            series2.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        org.jfree.chart.JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de funciones", "X", "Y", dataset);

        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        ChartFrame frame = new ChartFrame("Gráfico de funciones", chart);
        frame.pack();
        frame.setVisible(true);

    }
}
