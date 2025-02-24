package study.service_abstract.service.impl;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import study.service_abstract.service.MailSender;

public class DummyMainSender implements MailSender {
    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {

    }

    @Override
    public void send(SimpleMailMessage[] simpleMessages) throws MailException {

    }
}
