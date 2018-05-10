package ca.codetyto.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.fasterxml.jackson.databind.*;

@Controller
public class AppController {

 	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}