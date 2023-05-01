package tss4;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;


public class InversaExponencial1d{
    public static void main(String[] args) {
        double lambda = 1.0; // valor de lambda
        XYSeries series = createDataset(lambda);

        JFreeChart chart = ChartFactory.createXYLineChart(
            "InversaExponencial",
            "x",
            "f(x)",
            new XYSeriesCollection(series),
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(0, 10);
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(-1, 1);

        ChartPanel panel = new ChartPanel(chart);
        JFrame window = new JFrame("");
        window.setContentPane(panel);
        window.pack();
        window.setVisible(true);
    }


public static double f(double x, double lambda){
    return (-Math.exp(-2*lambda*x))*((2*lambda*x)+1);
}

public static XYSeries createDataset(double lambda){
    XYSeries series = new XYSeries("f(x)");
    for(double x = 0; x <= 10; x += 0.1) {
        series.add(x, f(x, lambda));
    }
    return series;
}

}
  




