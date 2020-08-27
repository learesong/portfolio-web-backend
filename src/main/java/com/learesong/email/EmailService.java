package com.learesong.email;

import com.learesong.common.Constants;
import com.learesong.config.EmailConfig;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    SendGrid sendGrid;

    @Autowired
    private EmailConfig emailConfig;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public ResponseEntity sendEmail(EmailRequest request) throws Exception {
        logger.info("Received email request by {} with message {}", request.getEmail(), request.getMessage());
        Request sgRequest = buildRequest(request);
        Response sgResponse = callSendGrid(sgRequest);
        logger.info("Response from SendGrid | Status Code: {}, Header: {}, Body: {}",
                    sgResponse.getStatusCode(), sgResponse.getHeaders(), sgResponse.getBody());
        return ResponseEntity.ok().build();
    }

    private Request buildRequest(EmailRequest emailRequest) throws IOException {
        Email from = new Email(Constants.EMAIL_FROM);
        Email to = new Email(Constants.EMAIL_TO);
        Email replyTo = new Email(emailRequest.getEmail());

        String subject = String.format("Email request from: %s (%s)", emailRequest.getName(), emailRequest.getEmail());
        Content content = new Content(Constants.EMAIL_CONTENT_TYPE, emailRequest.getMessage());

        Mail mail = new Mail(from, subject, to, content);
            mail.setReplyTo(replyTo);

        Request sendRequest = new Request();
            sendRequest.addHeader(Constants.REPLY_TO, emailRequest.getEmail());
            sendRequest.setMethod(Method.POST);
            sendRequest.setEndpoint(Constants.MAIL_SEND);
            sendRequest.setBody(mail.build());

        return sendRequest;
    }

    private Response callSendGrid(Request request) throws Exception {
        try {
            SendGrid sg = emailConfig.getSendGridKey();
            Response sgResponse = sg.api(request);
            return sgResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
