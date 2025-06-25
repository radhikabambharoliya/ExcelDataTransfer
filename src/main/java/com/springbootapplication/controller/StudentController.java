package com.springbootapplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springbootapplication.entity.Student;
import com.springbootapplication.helper.Helper;
import com.springbootapplication.service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {
 
	@Autowired
	private StudentService ss;
	
	@PostMapping("/student/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if (Helper.checkexcelformat(file)) {
            //true

            this.ss.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}
	
	@GetMapping("/student")
		public List<Student> getAllStudent(){
			 return this.ss.getAllStudent();
		}
	}
	


