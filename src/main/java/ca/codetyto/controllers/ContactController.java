package ca.codetyto.controllers;

import java.util.*;
import java.io.*;


import it.ozimov.springboot.mail.model.*;
import it.ozimov.springboot.mail.service.*;
import it.ozimov.springboot.mail.model.defaultimpl.*;

import javax.mail.internet.*;
import java.nio.charset.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.fasterxml.jackson.databind.*;

import static com.google.common.collect.Lists.*;

import org.slf4j.*;

@Controller
public class ContactController {

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Value("${app.mailTemplate.mailto}")
	private String toEmail;

	@Value("${app.mailTemplate.subject}")
	private String subject;

	private final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private EmailService emailService;

 	@RequestMapping(value = {"/contact"}, method = RequestMethod.POST)
	public ResponseEntity contact(@RequestParam Map<String, String> allRequestParams) {
		try {
			sendEmail(buildEmailBody(allRequestParams));
			return ResponseEntity.status(200).build();
		} catch (Exception e){
			log.error(e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	private String buildEmailBody(Map<String, String> allRequestParams) throws IllegalArgumentException {
		String name = allRequestParams.get("name");
		String subject = allRequestParams.get("subject");
		String body = allRequestParams.get("body");

		if(name == null || subject == null || body == null)
		    throw new IllegalArgumentException("Illegal Format in request parameters");

		return buildEmailBody(name, subject, body);
	}

	private String buildEmailBody(String name, String subject, String body) {
		return "Message from " + name + "\n" +
			   "Subject : " + subject + "\n" + 
			   body;
	}

	private void sendEmail(String body) throws UnsupportedEncodingException, AddressException {
		System.out.println(body);

   		final Email email = DefaultEmail.builder()
        .from(new InternetAddress(fromEmail))
        .replyTo(new InternetAddress(fromEmail))
        .to(Arrays.asList(new InternetAddress(toEmail)))
        .subject(subject)
        .body(body)
        .encoding("UTF-8").build();

   		emailService.send(email);
	}
}