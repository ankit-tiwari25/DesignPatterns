package org.example.creational.builder;

public class Main {
    public static void main(String[] args) {
        Student student = Student.builder().
                id(123).
                age(24).
                name("Shubham").
                gradYear(2022).
                phoneNumber("12345678").build();
        System.out.println(student);
    }
}
