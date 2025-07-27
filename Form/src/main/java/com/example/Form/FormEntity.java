package com.example.Form;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.servlet.annotation.MultipartConfig;

//import lombok.Data;

//@MultipartConfig(
//	    maxFileSize = 80485760, // Set to 10 MB in bytes (adjust as needed)
//	    maxRequestSize = 80971520, // Set to 20 MB in bytes (adjust as needed)
//	    fileSizeThreshold = 3048576 // 1 MB in bytes
//	)
//@Data
@Entity

public class FormEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public long getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(String batchYear) {
		this.batchYear = batchYear;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getFoodToken() {
		return foodToken;
	}
	public void setFoodToken(String foodToken) {
		this.foodToken = foodToken;
	}
	public String getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}
//	public String getPhoto() {
//		return photo;
//	}
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
	private String name;
    private String email;
    private long contactNumber;
    private long whatsappNumber;
    private String gender;
    private String batchYear;
    private String registerNumber;
    private String place;
    private String collegeName;
    private String foodToken;
    private String familyMembers;
    public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private String image;
   
//    private String photo;
//    @Lob
//    private byte[] photo;
//	public byte[] getPhoto() {
//		return photo;
//	}
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}

}
