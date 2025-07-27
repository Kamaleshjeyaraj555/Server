package com.example.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import jakarta.servlet.annotation.MultipartConfig;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/api")
//@MultipartConfig(
//	    maxFileSize = 80485760, // Set to 10 MB in bytes (adjust as needed)
//	    maxRequestSize = 80971520, // Set to 20 MB in bytes (adjust as needed)
//	    fileSizeThreshold = 3048576 // 1 MB in bytes
//	)
public class FormController {
	@Autowired
    private FormService  formSerives;

//    @PostMapping("/register")
//    public FormEntity  register(
//            @ModelAttribute FormEntity formEntity)
//             throws Exception {
//        return formSerives.saveRegistration(formEntity);
//    }
	@PostMapping("/register")
	public Student register(
	        @ModelAttribute FormEntity formEntity,
	        @RequestParam("photo") MultipartFile photoFile) throws Exception {

//	    if (photoFile != null && !photoFile.isEmpty()) {
//	        formEntity.setPhoto(photoFile.getBytes());
//	    }

	    return formSerives.saveRegistration(formEntity,photoFile.getBytes());
	}


}
