package com.jfx.kbDemo;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

/**
 * @author Rajesh Yelnare
 */
public class BirthdayStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();

        monthNames.addAll(Arrays.asList(months));

        xAxis.setCategories(monthNames);
        xAxis.setLabel(" MONTHS ");
        setKiodexTeamsData();
    }

    // set the x and y axis
    public void setKiodexTeamsData() {
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
		monthCounter[1] = 10;
		monthCounter[2] = 4;
		monthCounter[3] = 1;
		monthCounter[5] = 9;
		monthCounter[6] = 6;
		monthCounter[7] = 3;
		monthCounter[7] = 2;
		monthCounter[9] = 5;
		monthCounter[10] = 4;
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        series.setName("Count ");
        barChart.getData().add(series);
        barChart.setLegendSide(Side.LEFT);
    }

}
