package com.project.smarty.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.smarty.beans.ResultadoBean;
import com.project.smarty.model.repository.ResultadoRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ResultadoSrv implements IResultadoSrv {

	@Autowired
	ResultadoRepository resultadoRepository;
	
	@Override
	public Page<ResultadoBean> getResultadosPageable(String sport, String sort, String order, int offset, int limit)
			throws Exception {
		offset = offset/limit;
		if (sport.compareTo("All")== 0){
			Pageable pag = specifyPagination(sort, order, offset, limit);
			return resultadoRepository.findAll(pag);
		}else{
			Pageable pag = specifyPagination(sort, order, offset, limit);
			return resultadoRepository.findByDeporte(sport, pag);
		}
	}

	@Override
	public Page<ResultadoBean> getResultsToday(String sport, String sort, String order, int offset, int limit) throws Exception {
		Date date = new Date();
		offset = offset/limit;
		if (sport.compareTo("All")== 0){
			Pageable pag = specifyPagination(sort, order, offset, limit);
			return resultadoRepository.findByPartido_FechaGreaterThanEqual(date, pag);
		}else{
			Pageable pag = specifyPagination(sort, order, offset, limit);
			return resultadoRepository.findByDeporteAndPartido_FechaGreaterThanEqual(sport, date, pag);
		}
	}

	private Pageable specifyPagination(String sort, String order, int offset, int limit) {
		Pageable pag = null;
		if (sort != null) {
			if ("asc".compareTo(order) == 0) {
				pag = PageRequest.of(offset, limit, Sort.by(sort).ascending());
			} else if ("desc".compareTo(order) == 0) {
				pag = PageRequest.of(offset, limit, Sort.by(sort).descending());
			} else {
				pag = PageRequest.of(offset, limit);
			}
		} else {
			pag = PageRequest.of(offset, limit);
		}
		return pag;
	}

}
