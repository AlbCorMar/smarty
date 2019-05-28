package com.project.smarty.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "resultados")
public class ResultadoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_resultado")
    private Integer idResultado;

    @Column(name = "valor1")
    private Double valor1;

    @Column(name = "valorx")
    private Double valorx;

    @Column(name = "valor2")
    private Double valor2;

    @Column(name = "p1")
    private Double probability1;

    @Column(name = "px")
    private Double probabilityx;

    @Column(name = "p2")
    private Double probability2;

    @Column(name = "casaApuesta")
    private String casaApuesta;

    @Column(name = "Deporte")
    private String deporte;

    @Column(name = "ev")
    private Double ev;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "idPartido")
    private PartidoBean partido;
}
