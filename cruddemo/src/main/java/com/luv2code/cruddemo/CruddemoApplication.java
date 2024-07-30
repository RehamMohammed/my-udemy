package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.hibernate.collection.spi.PersistentList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//rerieveAllStudents(studentDAO);

			//findStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//updateAllStudents(studentDAO);

			//deleteStudentsByLastName(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Num of rows deleted are " + studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void deleteStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		studentDAO.deleteByLastName(students);
		studentDAO.updateAll();
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		System.out.println("Num of rows updated are " + studentDAO.updateAll());
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Reham");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Duck");
		for (Student student : students){
			System.out.println(student);
		}
	}

	private void rerieveAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students){
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Reham","Mohamed","reham@luv2code.com");
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		System.out.println("Reading the student ...");
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Displaying the student ..." + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multible students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
        System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		// save the student object
        System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}


}
