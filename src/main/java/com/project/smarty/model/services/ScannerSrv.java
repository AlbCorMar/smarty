
package com.project.smarty.model.services;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.project.smarty.model.scanner.IScanner;
import com.project.smarty.model.scanner.Scanner;
import com.project.smarty.beans.ScannerBean;
import com.project.smarty.utils.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScannerSrv implements IScannerSrv {

    private static String PATH_DRIVER = "src/main/java/com/project/smarty/drivers/geckodriver.exe";

    @Autowired
    IScanner scanner;

    @Override
    public List<ScannerBean> LoadBwin() throws Exception {

        List<ScannerBean> listScanner = new ArrayList<>();
        try {
            System.setProperty("webdriver.gecko.driver", PATH_DRIVER);
            final WebDriver firefox = new FirefoxDriver(new FirefoxOptions().setHeadless(true));

            listScanner.addAll(scanner.escanearBwin(Constant.FUTBOL_BWIN, Constant.FUTBOL_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.TENIS_BWIN, Constant.TENIS_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.BALOMCESTO_BWIN,Constant.BALONCESTO_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.BALONMANO_BWIN,Constant.BALONMANO_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.VOLEIBOL_BWIN,Constant.VOLEIBOL_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.BEISBOL_BWIN,Constant.BALONMANO_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.RUGBY_BWIN,Constant.RUGBY_SPORT, firefox));
            listScanner.addAll(scanner.escanearBwin(Constant.FUTBOL_AMERICANO_BWIN, Constant.FUTBOL_AMERICANO_SPORT, firefox));

            firefox.quit();

        } catch (Exception e){
        	System.out.println("Error : " + e.getMessage());
        }
        return listScanner;
    }

    
    @Override
    public List<ScannerBean> Load888Sport() throws Exception {
        List<ScannerBean> listScanner = new ArrayList<>();
    	try {
            System.setProperty("webdriver.gecko.driver", PATH_DRIVER);
            final WebDriver firefox = new FirefoxDriver(new FirefoxOptions().setHeadless(true));

            listScanner.addAll(scanner.escanearB888(Constant.FUTBOL_888, Constant.FUTBOL_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.TENIS_888, Constant.TENIS_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.BALONCESTO_888, Constant.BALONCESTO_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.BALONMANO_888, Constant.BALONMANO_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.VOLEIBOL_888, Constant.VOLEIBOL_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.BEISBOL_888, Constant.BEISBOL_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.RUGBY_888, Constant.RUGBY_SPORT, firefox));
            listScanner.addAll(scanner.escanearB888(Constant.FUTBOL_AMERICANO_888, Constant.FUTBOL_AMERICANO_SPORT, firefox));

            firefox.quit();

    	}catch(Exception e) {
    		System.out.println("Error : "+ e.getMessage());
    	}
        return listScanner;
    }
}
