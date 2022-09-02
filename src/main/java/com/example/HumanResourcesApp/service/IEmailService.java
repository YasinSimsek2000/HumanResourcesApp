package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.EmailDetails;
public interface IEmailService {

    String sendSimpleMail(EmailDetails details) throws Exception;
    String sendMailWithAttachment(EmailDetails details);
}
