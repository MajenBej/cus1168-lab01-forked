package academy.javapro;

import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")        
        );

        // TODO - Filtering: Students with GPA > 3.0
        List<Student> higherGPAStudents = students.stream()
            .filter(s -> s.getGpa() > 3.0)
            .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0" + higherGPAStudents);

        // TODO - Mapping: Extract names of students with GPA > 3.0
        List<String> higherGPAStudentNames = students.stream()
            .filter(s -> s.getGpa() > 3.0)
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("Name Of Students with GPA > 3.0" + higherGPAStudentNames);


        // TODO - Reducing: Calculate the average GPA of all students

        double averageGPA = students.stream()
            .mapToDouble(s -> s.getGpa()) // Extract GPA as double
            .average() // Calculate average
            .orElse(0.0); // Default if empty

        System.out.println("Average GPA: " + averageGPA);

        // TODO Collecting: Collect all "Junior" students into a list
        List<Student> juniorStudents = students.stream()
            .filter(s -> "Junior".equals(s.getCollegeYear())) // Check if the year is "Junior"
            .collect(Collectors.toList());

         System.out.println("Junior Students: " + juniorStudents);
    }
}
