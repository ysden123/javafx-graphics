/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.graphics.builder;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class LineChartBuilder {
    public static LineChart<Number, Number> buildLineChart(boolean withDots) {
        //Defining the axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X data");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y data");

        var lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setCreateSymbols(withDots); //hide dots

        var dataSeries1 = new XYChart.Series<Number, Number>();
        dataSeries1.setName("Line chart 2022 - 1");

        dataSeries1.getData().add(new XYChart.Data<>(1, 567));
        dataSeries1.getData().add(new XYChart.Data<>(5, 612));
        dataSeries1.getData().add(new XYChart.Data<>(10, 800));
        dataSeries1.getData().add(new XYChart.Data<>(20, 780));
        dataSeries1.getData().add(new XYChart.Data<>(40, 810));
        dataSeries1.getData().add(new XYChart.Data<>(80, 850));
        dataSeries1.getData().add(new XYChart.Data<>(90, 800));
        dataSeries1.getData().add(new XYChart.Data<>(100, 780));
        dataSeries1.getData().add(new XYChart.Data<>(110, 810));
        dataSeries1.getData().add(new XYChart.Data<>(120, 850));
        dataSeries1.getData().add(new XYChart.Data<>(130, 800));
        dataSeries1.getData().add(new XYChart.Data<>(140, 780));
        dataSeries1.getData().add(new XYChart.Data<>(150, 810));
        dataSeries1.getData().add(new XYChart.Data<>(160, 850));

        lineChart.getData().add(dataSeries1);

        var dataSeries2 = new XYChart.Series<Number, Number>();
        dataSeries2.setName("Line chart 2022 - 2");

        dataSeries2.getData().add(new XYChart.Data<>(1, 57));
        dataSeries2.getData().add(new XYChart.Data<>(5, 62));
        dataSeries2.getData().add(new XYChart.Data<>(10, 80));
        dataSeries2.getData().add(new XYChart.Data<>(20, 780));
        dataSeries2.getData().add(new XYChart.Data<>(40, 80));

        lineChart.getData().add(dataSeries2);

        return lineChart;
    }

    public static LineChart<Number, Number> buildLineChartDynamic() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X data");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y data");

        var lineChart = new LineChart<>(xAxis, yAxis);
        var dataSeries1 = new XYChart.Series<Number, Number>();
        dataSeries1.setName("Dynamic Line chart");
        lineChart.getData().add(dataSeries1);

        Service<Void> service = new Service<>() {
            @Override
            protected Task<Void> createTask() {
                var random = new Random();
                return new Task<Void>() {
                    @Override
                    protected Void call() {
                        for (int i = 1; i <= 10; ++i) {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception ignore) {
                            }
                            int x = i;
                            int y = random.nextInt(100);
                            Platform.runLater(() -> dataSeries1.getData().add(new XYChart.Data<>(x, y)));
                        }
                        return null;
                    }
                };
            }
        };
        service.start();
        return lineChart;
    }
}
