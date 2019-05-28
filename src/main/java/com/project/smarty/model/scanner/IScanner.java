package com.project.smarty.model.scanner;

import java.util.List;

import org.openqa.selenium.WebDriver;
import com.project.smarty.beans.ScannerBean;

public interface IScanner {
    
    List<ScannerBean> escanearBwin(String url, String deporte, WebDriver firefox) throws Exception;

    List<ScannerBean> escanearB888(String url, String deporte, WebDriver firefox) throws Exception;
    
}
