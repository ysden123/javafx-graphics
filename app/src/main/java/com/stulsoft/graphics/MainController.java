/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.graphics;

import com.stulsoft.graphics.builder.LineChartBuilder;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

public class MainController {
    public VBox graph;

    public void onLineWithDots() {
        var lineChart = LineChartBuilder.buildLineChart(true);
        var children = graph.getChildren();
        if (!children.isEmpty()){
            children.remove(0);
        }
        children.add(lineChart);
    }

    public void onLineWithoutDots() {
        var lineChart = LineChartBuilder.buildLineChart(false);
        var children = graph.getChildren();
        if (!children.isEmpty()){
            children.remove(0);
        }
        children.add(lineChart);
    }

    public void onQuit() {
        Platform.exit();
    }

    public void onLineDynamic() {
        var lineChart = LineChartBuilder.buildLineChartDynamic();
        var children = graph.getChildren();
        if (!children.isEmpty()){
            children.remove(0);
        }
        children.add(lineChart);
    }
}
