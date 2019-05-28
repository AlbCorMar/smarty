package com.project.smarty.model.services;

import com.project.smarty.beans.ScannerBean;

import java.util.List;

public interface ISaveScannerSrv {

    void SaveScanner(List<ScannerBean> listScanner) throws Exception;
}
