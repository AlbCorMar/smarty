package com.project.smarty.model.mail;

import com.project.smarty.beans.DTO.MailBean;
import com.project.smarty.beans.UsuarioBean;
import com.project.smarty.model.repository.UsuarioRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmailSrv implements IEmailSrv {

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    Configuration fremaker;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void sendMail(MailBean mail) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Template t = fremaker.getTemplate("emailTemplate.jsp");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

        helper.setTo(mail.getMailTo());
        helper.setText(html, true);
        helper.setSubject(mail.getMailSubject());
        helper.setFrom(mail.getMailFrom());

        emailSender.send(message);
    }

    public void configAndSendMail(Integer idUser) throws Exception{
        UsuarioBean user = usuarioRepository.findById(idUser).get();
        MailBean mail = new MailBean();
        mail.setMailFrom("albertocorderomartinez@gmail.com");
        mail.setMailTo(user.getEmail());
        mail.setMailSubject("Cambiar contraseña");

        Map<String, Object> model = new HashMap<>();
        model.put("idUsuario",user.getIdUsuario());
        this.sendMail(mail);
    }

}
