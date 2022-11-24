package com.duobank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private Driver(){}

    public static synchronized WebDriver getDriver(){

        if(drivers.get() == null){

            String browser =  System.getProperty("browser");  // read the browser from cmd

            if( browser == null){   // if no browser is passed thru cmd
                browser = ConfigReader.getProperty("browser"); // read the browser from properties file
            }


            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    drivers.set( new ChromeDriver() );
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                case "chromeHeadless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    drivers.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefoxHeadless":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    drivers.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "edgeHeadless":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setHeadless(true);
                    drivers.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    throw new RuntimeException("Unsupported Browser");

            }


        }

        return drivers.get();




    }


    public static synchronized void quitDriver(){

        if(drivers.get() != null){
            drivers.get().quit();
            drivers.remove();
        }
    }





}
