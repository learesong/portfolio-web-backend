package com.learesong.email;

import com.learesong.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private WebConfig webConfig;

    @PostMapping(path="/email")
    @ResponseBody
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest) throws Exception {
        return emailService.sendEmail(emailRequest);
    }
}
