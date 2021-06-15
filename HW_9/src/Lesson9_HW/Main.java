package Lesson9_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Lesson9_HW.Functions.funct1;
import static Lesson9_HW.Functions.funct2;
import static Lesson9_HW.Functions.funct3;

public class Main {
    public static void main(String[] args) {
        List<Student> students  = new ArrayList<>();
        students.add(new Student("Андрей", Arrays.asList(new Course("Math"),
                new Course("Phys"))));
        students.add(new Student("Татьяна", Arrays.asList(new Course("Econ"),
                new Course("Music"), new Course("Lang"))));
        students.add(new Student("Алексей", Arrays.asList(new Course("Math"),
                new Course("Sport"), new Course("Phys"))));
        students.add(new Student("Илья", Arrays.asList(new Course("Econ"),
                new Course("Music"), new Course("Lang"), new Course("Sport"))));
        students.add(new Student("Павел", Arrays.asList(new Course("Math"),
                new Course("Sport"), new Course("Phys"))));

        System.out.println("задание №1 из урока");
        System.out.println(students.stream()
                .map(s->s.getCourses())
                .flatMap(c->c.stream())
                .collect(Collectors.toSet()));

        System.out.println("\nзадание 1 из ДЗ");
        System.out.println(funct1(students));

        System.out.println("\nзадание №2 из урока");
        System.out.println(students.stream()
                .sorted((s1,s2)->s2.getCourses().size()-s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("\nзадание 2 из ДЗ");
        System.out.println(funct2(students));

        System.out.println("\nзадание №3 из урока");
        Course requiredCourse = new Course("Math");
        System.out.println(students.stream()
                .filter((s->s.getCourses().contains(requiredCourse)))
                .collect(Collectors.toList()));

        System.out.println("\nзадание 3 из ДЗ");
        System.out.println(funct3(students,requiredCourse));
    }
}
