package com.project.smarty.model.repository;

import com.project.smarty.beans.ResultadoBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ResultadoRepository extends JpaRepository<ResultadoBean,  Integer> {

    Page<ResultadoBean> findByDeporte(String sport, Pageable pag);
    Page<ResultadoBean> findByPartido_FechaGreaterThanEqual(Date fecha, Pageable page);
    Page<ResultadoBean> findByDeporteAndPartido_FechaGreaterThanEqual(String sport, Date fecha, Pageable page);


}
