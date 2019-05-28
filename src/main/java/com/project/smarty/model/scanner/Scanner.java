package com.project.smarty.model.scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import com.project.smarty.beans.ScannerBean;
import com.project.smarty.utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class Scanner implements IScanner {

    @Override
    public List<ScannerBean> escanearBwin(String url, String deporte, WebDriver firefox) throws Exception {
        List<ScannerBean> scannerList = new ArrayList<>();
        firefox.get(url);
        String url1 = firefox.getCurrentUrl();
        if (url.compareTo(url1) == 0) {
            Document doc = Jsoup.parse(firefox.getPageSource());
            scannerList = loadValueBwin(doc, ".events-table-league .event-row", deporte);
        }
        Thread.sleep(2000);


        return scannerList;
    }

    private List<ScannerBean> loadValueBwin(Document doc,String docTable, String deporte){

        List<ScannerBean> scannerList = new ArrayList<>();
        Object[] eventRow = doc.select(docTable).toArray();
        List<Object> list = Arrays.asList(eventRow);
        list.forEach(element -> {
            ScannerBean scanner = new ScannerBean();
            Element newElement = (Element) element;
            Object[] players = newElement.getElementsByClass("player-name").toArray();
            if (players.length == 2){
                scanner.setLocal(((Element) players[0]).text());
                scanner.setVisitante(((Element) players[1]).text());
            } else if (players.length == 1){
                String[] div = ((Element) players[0]).text().split(" - ");
                scanner.setLocal(div[0]);
                scanner.setVisitante(div[1]);
            }
            Object[] results = newElement.select(".market-column--3-0 .option-button-odds").toArray();

            if (results.length == 3) {
                scanner.setValor1(Double.parseDouble(((Element) results[0]).text()));
                scanner.setValorx(Double.parseDouble(((Element) results[1]).text()));
                scanner.setValor2(Double.parseDouble(((Element) results[2]).text()));
            } else if (results.length == 2) {
                scanner.setValor1(Double.parseDouble(((Element) results[0]).text()));
                scanner.setValor2(Double.parseDouble(((Element) results[1]).text()));
            }
            scanner.setCasaApuesta("Bwin");
            scanner.setDeporte(deporte);
            Object time = newElement.getElementsByClass("event-time-period");
            scanner.setFecha(new Date());
            scannerList.add(scanner);
        });
        return scannerList;
    }

    @Override
    public List<ScannerBean> escanearB888(String url, String deporte, WebDriver firefox) throws Exception {

        List<ScannerBean> scannerList = new ArrayList<>();
        firefox.get(url);
        Thread.sleep(2000);
        List<WebElement> url1 = firefox.findElements(By.className("KambiBC-event-groups-no-events-available-title"));
        if (url1.size() == 0) {
            List<WebElement> hideElements = firefox.findElements(By.cssSelector(".KambiBC-collapsible-container.KambiBC-mod-event-group-container.KambiBC-mod-event-group-container--live"));
            for (WebElement element: hideElements) {
                String string = element.getAttribute("class");
                if (string.indexOf("KambiBC-expanded") == -1) {
                    element.findElement(By.cssSelector(".KambiBC-collapsible-header.KambiBC-mod-event-group-header")).click();
                }
            }
            Document doc = Jsoup.parse(firefox.getPageSource());
            scannerList = loadValueB888(doc,deporte);
        }
        Thread.sleep(2000);
        return scannerList;
    }

    private List<ScannerBean> loadValueB888(Document doc, String deporte){
        List<ScannerBean> scannerList = new ArrayList<>();
        Object[] eventRow = doc.select(".KambiBC-event-item__event-wrapper").toArray();
        List<Object> list = Arrays.asList(eventRow);
        list.forEach(element -> {
            ScannerBean scanner = new ScannerBean();
            Element newElement = (Element) element;
            Object[] players = newElement.getElementsByClass("KambiBC-event-participants__name").toArray();
            if (players.length == 2) {
                scanner.setLocal(((Element) players[0]).text());
                scanner.setVisitante(((Element) players[1]).text());
            }
            Object[] results = newElement.getElementsByClass("KambiBC-mod-outcome__odds").toArray();

            if (results.length == 3) {
                if ("—".compareTo(((Element) results[0]).text()) != 0){
                    scanner.setValor1(Double.parseDouble(((Element) results[0]).text()));
                }
                if ("—".compareTo(((Element) results[1]).text()) != 0){
                    scanner.setValorx(Double.parseDouble(((Element) results[1]).text()));
                }
                if ("—".compareTo(((Element) results[2]).text()) != 0){
                    scanner.setValor2(Double.parseDouble(((Element) results[2]).text()));
                }
            } else if (results.length == 2) {
                if ("—".compareTo(((Element) results[0]).text()) != 0){
                    scanner.setValor1(Double.parseDouble(((Element) results[0]).text()));
                }
                if ("—".compareTo(((Element) results[1]).text()) != 0){
                    scanner.setValor2(Double.parseDouble(((Element) results[1]).text()));
                }
            }
            scanner.setCasaApuesta("888Sport");
            scanner.setDeporte(deporte);
            scanner.setFecha(new Date());
            scannerList.add(scanner);
        });
        return scannerList;
    }

}
