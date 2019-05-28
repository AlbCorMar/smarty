package com.project.smarty.controllers;

import com.project.smarty.model.services.ISaveScannerSrv;
import com.project.smarty.model.services.IScannerSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
public class ScannerController {

    @Autowired
    IScannerSrv scannerSrv;

    @Autowired
    ISaveScannerSrv saveScannerSrv;

    @RequestMapping("/Scanner")
    public Map scanner() {
        HashMap<String, Object> res= new HashMap<>();
        try {
            // hacer estos métodos en hilos
            saveScannerSrv.SaveScanner(scannerSrv.LoadBwin());
            saveScannerSrv.SaveScanner(scannerSrv.Load888Sport());
            res.put("msg", "Datos guardados en la base de datos");

        }catch (Exception e){
            res.put("error","Error: " + e.getMessage());
        }
        return res;
    }
}
