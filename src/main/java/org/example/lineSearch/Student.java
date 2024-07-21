package org.example.lineSearch;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private Integer gender;

    public Student(Integer id, String name, Integer gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}' + "\r\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(gender, student.gender);
    }

    @Override
    public int compareTo(Student o) {
//        if (this.id < o.id) {
//            return -1;
//        } else if (this.id == o.id) {
//            return 0;
//        }
//        return 1;
        return this.id - o.id;
    }
}
