package com.project.smarty.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarty.beans.ResultadoBean;
import com.project.smarty.model.services.IResultadoSrv;

@RestController
public class ResultsController {

	@Autowired
	private IResultadoSrv resultadoSrv;
	
	@RequestMapping("/Results/historical/{sport}")
	public Map listhistorical(@PathVariable("sport") String sport, String sort, String order, int offset, int limit) {
		HashMap<String, Object> res=new HashMap<>();
		try {
			Page<ResultadoBean> result = resultadoSrv.getResultadosPageable(sport, sort, order, offset, limit);
			res.put("rows", result.getContent());
			res.put("total", result.getTotalElements());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	

}
