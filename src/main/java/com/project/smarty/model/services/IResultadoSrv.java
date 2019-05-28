package com.project.smarty.model.services;

import org.springframework.data.domain.Page;

import com.project.smarty.beans.ResultadoBean;

public interface IResultadoSrv {

	Page<ResultadoBean> getResultadosPageable(String sport, String sort, String order, int offset, int limit) throws Exception;

	Page<ResultadoBean> getResultsToday(String sport, String sort, String order, int offset, int limit) throws Exception;
}
