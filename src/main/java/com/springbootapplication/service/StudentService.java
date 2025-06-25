package com.springbootapplication.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.springbootapplication.repositry.StudentRepositry;
import com.springbootapplication.entity.Student;
import com.springbootapplication.helper.Helper;

@Service
public class StudentService {

	
	@Autowired 
	private StudentRepositry sr;
	
	public void save(MultipartFile file) {
		
		try {
			List<Student> student = Helper.convertExcelToListOfStudent(file.getInputStream());
			this.sr.saveAll(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getAllStudent(){
		return this.sr.findAll();
	}
}
