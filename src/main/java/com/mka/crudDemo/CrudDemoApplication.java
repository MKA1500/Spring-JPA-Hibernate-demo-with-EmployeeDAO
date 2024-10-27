package com.mka.crudDemo;

import com.mka.crudDemo.dao.StudentDAO;
import com.mka.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting student: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student by id
		int studentId = 3;
		System.out.println("STUDENT ID TO BE UPDATED: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name
		myStudent.setFirstName("Monika");
		myStudent.setLastName("Dabrowska");
		myStudent.setEmail("m.dabrowska@gmail.com");
		// update the student
		studentDAO.update(myStudent);
		System.out.println("STUDENT UPDATED: " + myStudent);
		// display the updated student
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Kukulski");
		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student...");
		Student student = new Student("Filip", "Weihert", "filip@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);

		int theId = student.getId();
		System.out.println("Saved student id: " + theId);
		Student retrievedStudent = studentDAO.findById(theId);
		System.out.println("STUDENT FOUND: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student object...");
		Student tempStudent1 = new Student("Zuzanna", "Kukulski", "j.kukulski@gmail.com");
		Student tempStudent2 = new Student("Bozena", "Karasiewicz", "a.elikowska@gmail.com");
		Student tempStudent3 = new Student("Maciej", "Zdanowski", "a.bbbbb@gmail.com");
		Student tempStudent4 = new Student("Piotr", "Aleksandrowicz", "ad32db@gmail.com");
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object...");
		Student tempStudent = new Student("5Monika", "Kukulski", "m.kukulski@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated ID: " + tempStudent.getId());
	}
}
