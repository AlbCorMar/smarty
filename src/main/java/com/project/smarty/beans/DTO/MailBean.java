package com.project.smarty.beans.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MailBean {
    private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List<Object> attachments;
    private Map<String, Object> model;

    public MailBean() {
        this.contentType = "text/plain";
    }
}
