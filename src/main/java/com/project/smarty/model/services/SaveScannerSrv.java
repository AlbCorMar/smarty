package com.project.smarty.model.services;

import com.project.smarty.beans.PartidoBean;
import com.project.smarty.beans.ResultadoBean;
import com.project.smarty.beans.ScannerBean;
import com.project.smarty.model.repository.ResultadoRepository;
import com.project.smarty.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaveScannerSrv implements ISaveScannerSrv {

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Autowired
    private ICalculateMatchSrv calculateMatch;

    @Override
    public void SaveScanner(List<ScannerBean> listScanner) throws Exception {
        
        for (ScannerBean scanner:listScanner){
        	List<Double> values = new ArrayList<>();
            List<Double> probabilities = new ArrayList<>();
            ResultadoBean resultado = new ResultadoBean();
            PartidoBean partido = new PartidoBean();
            //se guarda los datos de resultado
            resultado.setIdResultado(null);
            if ((Constant.FUTBOL_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.BALONMANO_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.RUGBY_SPORT.compareTo(scanner.getDeporte()) == 0)){
                if (scanner.getValor1()!=null && scanner.getValorx() != null && scanner.getValor2() != null){
                    values.add(scanner.getValor1()!=null?scanner.getValor1():null);
                    values.add(scanner.getValorx()!=null?scanner.getValorx():null);
                    values.add(scanner.getValor2()!=null?scanner.getValor2():null);
                    resultado.setValor1(scanner.getValor1());
                    resultado.setValorx(scanner.getValorx());
                    resultado.setValor2(scanner.getValor2());
                    // cálculo probabilididades
                    probabilities = calculateMatch.calculateProbability(values);
                    resultado.setProbability1(probabilities.get(0));
                    resultado.setProbabilityx(probabilities.get(1));
                    resultado.setProbability2(probabilities.get(2));
                    //se calcula ev y se guarda en resultados
                    Double ev = calculateMatch.calculateEv(values,probabilities);
                    resultado.setEv(ev);
                }
            }
            if ((Constant.TENIS_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.BALONCESTO_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.VOLEIBOL_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.TENIS_SPORT.compareTo(scanner.getDeporte()) == 0)
                    || (Constant.FUTBOL_AMERICANO_SPORT.compareTo(scanner.getDeporte()) == 0)) {
                if (scanner.getValor1()!=null && scanner.getValor2() != null){
                    values.add(scanner.getValor1());
                    values.add(scanner.getValor2());
                    resultado.setValor1(scanner.getValor1());
                    resultado.setValorx(null);
                    resultado.setValor2(scanner.getValor2());
                    // cálculo probabilididades
                    probabilities = calculateMatch.calculateProbability(values);
                    resultado.setProbability1(probabilities.get(0));
                    resultado.setProbabilityx(null);
                    resultado.setProbability2(probabilities.get(1));
                    //se calcula ev y se guarda en resultados
                    Double ev = calculateMatch.calculateEv(values,probabilities);
                    resultado.setEv(ev);
                }
            }
            resultado.setCasaApuesta(scanner.getCasaApuesta());
            resultado.setDeporte(scanner.getDeporte());
           
            // se guardan los datos del partido
            partido.setIdPartido(null);
            partido.setLocal(scanner.getLocal());
            partido.setVisitante(scanner.getVisitante());
            partido.setFecha(scanner.getFecha());
            // se guarda los datos del partido en el resultado (relacion muchos a uno entre resultados y partido)
            resultado.setPartido(partido);
            // se guardan los datos del resultado en la base de datos
            resultadoRepository.save(resultado);
        }

    }
}
