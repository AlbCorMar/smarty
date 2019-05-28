package com.project.smarty.beans;

import lombok.Data;

import java.util.Date;

@Data
public class ScannerBean {

    private String local;
    private String visitante;
    private Date fecha;
    private Double valor1;
    private Double valorx;
    private Double valor2;
    private String casaApuesta;
    private String deporte;

}
