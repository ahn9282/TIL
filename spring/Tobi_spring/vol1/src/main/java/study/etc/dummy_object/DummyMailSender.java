package study.etc.dummy_object;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import study.service_abstract.service.MailSender;

public class DummyMailSender implements MailSender {
    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {

    }

    @Override
    public void send(SimpleMailMessage[] simpleMessages) throws MailException {

    }
}
