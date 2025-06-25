package com.springbootapplication.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootapplication.entity.Student;

public interface StudentRepositry extends JpaRepository<Student,Integer> {

}
