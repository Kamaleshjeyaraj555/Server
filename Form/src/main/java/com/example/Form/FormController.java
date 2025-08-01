package com.example.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/api")

public class FormController {
	@Autowired
    private FormService  formSerives;


	@PostMapping("/register")
	public Student register(
	        @ModelAttribute FormEntity formEntity,
	        @RequestParam("photo") MultipartFile photoFile) throws Exception {



	    return formSerives.saveRegistration(formEntity,photoFile.getBytes());
	}


}
