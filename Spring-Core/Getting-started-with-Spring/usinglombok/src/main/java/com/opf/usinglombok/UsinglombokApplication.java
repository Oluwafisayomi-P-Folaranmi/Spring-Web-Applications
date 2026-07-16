package com.opf.usinglombok;

import com.opf.usinglombok.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsinglombokApplication {

    @Autowired
    Student student;

	public static void main(String[] args) {

		SpringApplication.run(UsinglombokApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(Student student) {
        return args -> {
            System.out.println("Application started!");
            System.out.println("Arguments: " + '\n');

            // Creating a student
            Student student1 = new Student(
                    "abc123",
                    "Oluwafisayomi",
                    "Folaranmi");

            // Creating another student
            Student student2 = new Student();
            student2.setStudentId("abc124");
            student2.setFirstName("Odunayo");
            student2.setLastName("Ige");

            System.out.println("student 1:");
            System.out.println(student1.getFirstName() + " " + student1.getLastName());
            System.out.println();
            System.out.println("student 2:");
            System.out.println(student2.getFirstName() + " " + student2.getLastName());
        };
    }
}
