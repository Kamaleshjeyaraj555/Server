//package com.example.Form;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//
//
//
//
//
//@Service
//public class FormSerives {
//	 @Autowired
//	    private FormRepository formRepository ;
//
//	    @Autowired
//	    private JavaMailSender mailSender;
//
//	    public FormEntity saveRegistration(FormEntity formEntity, MultipartFile photo)
//	    		throws IOException {
//	        // Save photo to disk (optional)
//	        if (photo != null && !photo.isEmpty()) {
//	            String uploadDir = "uploads/";
//	            File uploadFolder = new File(uploadDir);
//	            if (!uploadFolder.exists()) uploadFolder.mkdirs();
//	            String filePath = uploadDir + photo.getOriginalFilename();
//	            photo.transferTo(new File(filePath));
//	            formEntity.setPhoto(filePath);
//	        }
//	        FormEntity saved = formRepository.save(formEntity);
//
//	        // Send email
//	        sendEmail(saved);
//
//	        return saved;
//	    }
//
//	    private void sendEmail(FormEntity formEntity) {
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo("kamaleshj555@gmail.com"); // Change to HR email
//	        message.setSubject("14th Graduation Day - 2025 Registration");
//	        message.setText(
//	                "Name: " + formEntity.getName() + "\n" +
//	                "Email: " + formEntity.getEmail() + "\n" +
//	                "Contact Number: " + formEntity.getContactNumber() + "\n" +
//	                "Whatsapp Number: " + formEntity.getWhatsappNumber() + "\n" +
//	                "Gender: " + formEntity.getGender() + "\n" +
//	                "Batch Year: " + formEntity.getBatchYear() + "\n" +
//	                "Register Number: " + formEntity.getRegisterNumber() + "\n" +
//	                "Place: " + formEntity.getPlace() + "\n" +
//	                "College Name: " + formEntity.getCollegeName() + "\n" +
//	                "Food Token: " + formEntity.getFoodToken() + "\n" +
//	                "Family Members: " + formEntity.getFamilyMembers()
//	        );
//	        mailSender.send(message);
//	    }
//}
package com.example.Form;
import java.util.*;
import java.io.File;
import java.io.IOException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Student saveRegistration(FormEntity formEntity,byte[] photo)
            throws IOException, MessagingException {

        // Save photo to disk
    	
//    	byte[] photo =  formEntity.getPhoto();
    	
    	String image = Base64.getEncoder().encodeToString(photo);
//        formEntity.setPhoto(photo);
 
    	Student student= new Student(); 
    	student.setBatchYear(formEntity.getBatchYear());
    	student.setCollegeName(formEntity.getCollegeName());
    	student.setEmail(formEntity.getEmail());
    	student.setFamilyMembers(formEntity.getFamilyMembers());
    	student.setFoodToken(formEntity.getFoodToken());
    	student.setGender(formEntity.getGender());
      	student.setId(formEntity.getId());
      	student.setName(formEntity.getName());
     	student.setPlace(formEntity.getPlace());
       	student.setWhatsappNumber(formEntity.getWhatsappNumber());
       	student.setRegisterNumber(formEntity.getRegisterNumber());
       	student.setContactNumber(formEntity.getContactNumber());
       	
     	student.setPhoto(photo);
        Student saved = formRepository.save(student);

        // Send email with photo attachment
//        sendEmail(saved);
//        String content = "Dear Admin,\n\nHere are the registration details:\n\n" +
//                "Name: " + saved.getName() + "\n" +
//                "Email: " + saved.getEmail() + "\n" +
//                "Contact Number: " + saved.getContactNumber() + "\n" +
//                "Whatsapp Number: " + saved.getWhatsappNumber() + "\n" +
//                "Gender: " + saved.getGender() + "\n" +
//                "Batch Year: " + saved.getBatchYear() + "\n" +
//                "Register Number: " + saved.getRegisterNumber() + "\n" +
//                "Place: " + saved.getPlace() + "\n" +
//                "College Name: " + saved.getCollegeName() + "\n" +
//                "Food Token: " + saved.getFoodToken() + "\n" +
//                "Family Members: " + saved.getFamilyMembers() + "\n"
//                + "<img src='data:image/png;base64," +image + "'  style='width:200px;height:200px;' alt='Image'>"
//                ; 
        String content = "<html><body>" +
                "<p>Dear Admin,</p>" +
                "<p>Here are the registration details:</p>" +
                "Name: " + saved.getName() + "<br>" +
                "Email: " + saved.getEmail() + "<br>" +
                "Contact Number: " + saved.getContactNumber() + "<br>" +
                "Whatsapp Number: " + saved.getWhatsappNumber() + "<br>" +
                "Gender: " + saved.getGender() + "<br>" +
                "Batch Year: " + saved.getBatchYear() + "<br>" +
                "Register Number: " + saved.getRegisterNumber() + "<br>" +
                "Place: " + saved.getPlace() + "<br>" +
                "College Name: " + saved.getCollegeName() + "<br>" +
                "Food Token: " + saved.getFoodToken() + "<br>" +
                "Family Members: " + saved.getFamilyMembers() + "<br><br>" +
                "<img src='data:image/png;base64," + image + "' style='width:200px;height:200px;' alt='Image'>" +
                "</body></html>";

         Mail.sendMail("kamaleshj555@gmail.com",content);
        return saved;
    }

    private void sendEmail(FormEntity form) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

//        helper.setTo("kamaleshj555@gmail.com"); // Change to admin email
//        helper.setSubject("14th Graduation Day - 2025 Registration");

        String content = "Dear Admin,\n\nHere are the registration details:\n\n" +
                "Name: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n" +
                "Contact Number: " + form.getContactNumber() + "\n" +
                "Whatsapp Number: " + form.getWhatsappNumber() + "\n" +
                "Gender: " + form.getGender() + "\n" +
                "Batch Year: " + form.getBatchYear() + "\n" +
                "Register Number: " + form.getRegisterNumber() + "\n" +
                "Place: " + form.getPlace() + "\n" +
                "College Name: " + form.getCollegeName() + "\n" +
                "Food Token: " + form.getFoodToken() + "\n" +
                "Family Members: " + form.getFamilyMembers() + "\n"
                + "<img src='data:image/png;base64," + form.getImage() + "'  style='width:200px;height:200px;' alt='Image'>"
                ; 

//        helper.setText(content);

        // Attach photo if exists
//        if (form.getPhoto() != null) {
//            File file = new File("uploads/" + form.getPhoto());
//            if (file.exists()) {
//                helper.addAttachment(form.getPhoto(), new FileSystemResource(file));
//            }
//        }
        
//        if (form.getPhoto() != null) {
//            String tempFilePath = "uploads/temp_" + System.currentTimeMillis() + ".jpg";
//            File tempFile = new File(tempFilePath);
//            java.nio.file.Files.write(tempFile.toPath(), form.getPhoto());
//
//            helper.addAttachment("photo.jpg", new FileSystemResource(tempFile));
//        }


//        mailSender.send(message);
    }
}