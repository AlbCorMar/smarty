package com.project.smarty.model.services;

import com.project.smarty.beans.ScannerBean;

import java.util.List;

public interface IScannerSrv {

    List<ScannerBean> LoadBwin() throws Exception;
    List<ScannerBean> Load888Sport() throws Exception;
    
}
