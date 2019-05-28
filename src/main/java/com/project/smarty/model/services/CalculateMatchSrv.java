package com.project.smarty.model.services;

import com.project.smarty.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculateMatchSrv implements ICalculateMatchSrv {


    public List<Double> calculateProbability(List<Double> values) throws Exception {
        List<Double> probabilities = new ArrayList<>();
        Double suma = new Double(0);

        if (values.size()==3){
            suma = ((1/values.get(0))+(1/values.get(1))+(1/values.get(2)));
            for (int i=0; i<3; i++) {
                probabilities.add((1 / values.get(i)) / suma);
            }
        }


        if (values.size()==2){
            suma = ((1/values.get(0))+(1/values.get(1)));
            for (int i=0; i<2; i++) {
                probabilities.add((1 / values.get(i)) / suma);
            }
        }
        return probabilities;
    }

    public Double calculateEv(List<Double> value, List<Double> prob) throws Exception {

        Double ev = new Double(0);

        if (prob.size()==3){
            for (int i=0; i<3; i++){
                ev+=prob.get(i)*(value.get(i)-1)-(1-prob.get(i));
            }
            ev/=3;
        }

        if (prob.size()==2) {
            for (int i=0; i<2; i++){
                ev+=prob.get(i)*(value.get(i)-1)-(1-prob.get(i));
            }
            ev/=3;
        }

        return ev;
    }
}
