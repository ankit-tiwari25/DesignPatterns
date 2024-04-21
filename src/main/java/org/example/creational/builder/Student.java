package org.example.creational.builder;

import org.example.creational.builder.exceptions.InvalidAgeException;
import org.example.creational.builder.exceptions.InvalidGradYearException;
import org.example.creational.builder.exceptions.InvalidNameException;

import java.util.Locale;

public class Student {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private  int gradYear;

    public Student(int id, String name, int age, String phoneNumber, int gradYear) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gradYear = gradYear;
    }

    // To string method

    public String toString(){
        return "Student { + " +
                "id : " + id;
    }




    /* Essential attributes for validation
            1. age > 18
            2. gradYear < 2024
            3. name should not be null.
     */

    //Create a builder method to return a builder object
    public static  Builder builder(){
        return new Builder();
    }

    //Create a new inner static class Builder
    public static class Builder{
        private int id;
        private String name;
        private int age;
        private String phoneNumber;
        private  int gradYear;

        // Apply setters


        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return  this;
        }

        public Builder age(int age) {
            this.age = age;
            return  this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder gradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        //validate method to validate all essential attributes
        public  void validate(){
            if(age < 18){
                throw new InvalidAgeException("User is below 18 years...");
            }

            if(gradYear > 2023){
                throw new InvalidGradYearException("User is currently in college");
            }
            if(name == null){
                throw new InvalidNameException("Name cannot be null!");
            }
        }

        public Student build(){
            validate();
            return new Student(id, name, age, phoneNumber, gradYear);
        }
    }


}
