package utils;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public String converteDataEmMesEAno(String data) {
        Date date = null;
        String dataFormatada = "";

        // 31/05/2022
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            date = sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Maio 2022
        SimpleDateFormat sdfNovo = new SimpleDateFormat("MMMM yyyy");
        dataFormatada = sdfNovo.format(date);

        return dataFormatada; // Maio 2022
    }

//    public void waitUntilIsVisible(WebElement element, int timeout){
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeout);
//        WebElement elementToWait = wait.until(ExpectedConditions.visibilityOf(element));
//    }



}
