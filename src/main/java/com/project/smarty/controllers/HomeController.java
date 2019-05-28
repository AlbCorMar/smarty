package com.project.smarty.controllers;

import com.project.smarty.beans.ResultadoBean;
import com.project.smarty.model.services.IResultadoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private IResultadoSrv resultadoSrv;

    @GetMapping("/Home/{sport}")
    public Map listhistorical(@PathVariable("sport") String sport, String sort, String order, int offset, int limit) {
        HashMap<String, Object> res=new HashMap<>();
        try {
            Page<ResultadoBean> result = resultadoSrv.getResultsToday(sport, sort, order, offset, limit);
            res.put("rows", result.getContent());
            res.put("total", result.getTotalElements());
        }catch(Exception e) {
            res.put("error", "Error: " + e.getMessage());
        }
        return res;
    }
}
