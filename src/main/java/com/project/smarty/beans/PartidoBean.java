package com.project.smarty.beans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.smarty.configuration.JsonFecha;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "partidos")
public class PartidoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPartido")
    private Integer idPartido;

    @Column(name = "local")
    private String local;

    @Column(name = "visitante")
    private String visitante;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @JsonSerialize(using = JsonFecha.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

}
