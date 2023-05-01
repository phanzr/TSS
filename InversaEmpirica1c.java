/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tss4;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class InversaEmpirica1c extends ApplicationFrame {

    public InversaEmpirica1c(String title) {
        super(title);
        ChartPanel chartPanel = crearPanel();
        chartPanel.setPreferredSize(new Dimension(560, 370));
        setContentPane(chartPanel);
    }

    private ChartPanel crearPanel() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("f(x)");

        for (double x = 0; x <= 6; x += 0.01) {
            double y = (Math.pow(x, 3) / 54) - (Math.pow(x, 2) / 6) + (x / 2);
            series.add(x, y);
        }

        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "1c) Tranformada inversa, distribucion empirica", "x", "y", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        XYSplineRenderer renderer = new XYSplineRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesShapesVisible(0, false);
        plot.setRenderer(renderer);

        return new ChartPanel(chart);
    }

    public static void main(String[] args) {
        InversaEmpirica1c demo = new InversaEmpirica1c("");
        demo.pack();
        demo.setVisible(true);
    }
}
