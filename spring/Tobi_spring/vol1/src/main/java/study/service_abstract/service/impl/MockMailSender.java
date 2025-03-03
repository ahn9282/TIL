package study.service_abstract.service.impl;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import study.service_abstract.service.MailSender;

import java.util.ArrayList;
import java.util.List;

public class MockMailSender implements MailSender {
    private List<String> requests = new ArrayList<>();

    public List<String> getRequest(){
        return this.requests;
    }

    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {
        System.out.println("mock mail sends.....");
    }

    @Override
    public void send(SimpleMailMessage[] simpleMessages) throws MailException {
        System.out.println("mock mails send.....");
    }
}
