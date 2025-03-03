package study.service_abstract.service.impl;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import study.service_abstract.service.MailSender;

//@Service
public class JavaMailSenderImpl implements MailSender {
    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {

    }

    @Override
    public void send(SimpleMailMessage[] simpleMessages) throws MailException {

    }
}
