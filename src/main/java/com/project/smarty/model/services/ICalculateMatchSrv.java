package com.project.smarty.model.services;

import java.util.List;

public interface ICalculateMatchSrv {

    List<Double> calculateProbability(List<Double> values) throws Exception;

    Double calculateEv(List<Double> values, List<Double> prob) throws Exception;
}
