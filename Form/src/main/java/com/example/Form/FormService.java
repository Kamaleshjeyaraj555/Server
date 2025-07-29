
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


    	
    	String image = Base64.getEncoder().encodeToString(photo);

 
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


    }
}
