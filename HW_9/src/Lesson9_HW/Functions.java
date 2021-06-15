package Lesson9_HW;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functions {

    public static Set<Course> funct1 (List<Student> funct1StudentList) {
        return funct1StudentList.stream()
                .map(s->s.getCourses())
                .flatMap(c->c.stream())
                .collect(Collectors.toSet());
    }
    public static List<Student> funct2 (List<Student> func21StudentList) {
        return func21StudentList.stream()
                .sorted((s1,s2)->s2.getCourses().size()-s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }
    public static List<Student> funct3 (List<Student> func31StudentList, Course reqCourse) {
        return func31StudentList.stream()
                .filter((s->s.getCourses().contains(reqCourse)))
                .collect(Collectors.toList());
    }
}
