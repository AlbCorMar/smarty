package com.project.smarty.model.mail;

import com.project.smarty.beans.DTO.MailBean;

public interface IEmailSrv {
    void sendMail(MailBean mail) throws Exception;
    void configAndSendMail(Integer idUser) throws Exception;
}
