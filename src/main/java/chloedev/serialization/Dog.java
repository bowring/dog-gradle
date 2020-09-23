/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// https://www.geeksforgeeks.org/serialization-in-java/
package chloedev.serialization;

/**
 *
 * @author ces
 */

import java.io.*;
import java.time.LocalDate;


public class Dog implements Serializable, Comparable<Dog> {
    private String name;
    private String owner;
    private String breed;
    private String sex;
    private int birthMonth;
    private int birthDay;
    private int birthYear;

    public Dog() {
        new Dog("Unnamed", "Free", "Mutt", "Unknown", 1, 1, 2020);
    }

    public Dog(String name, String owner, String breed, String sex, int month, int day, int year) {
        this.name = name;
        this.breed = owner;
        this.breed = breed;
        this.sex = sex;
        this.birthMonth = month;
        this.birthDay = day;
        this.birthYear = year;
    }

    public String prettyPrint() {
        return name + " - " + breed + " - " + owner;
    }

    public int compareTo(Dog otherDog) {
        //  TODO
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        Boolean retVal = true;

        Dog otherDog = (Dog) other;

        retVal = retVal && name.equals(otherDog.getName());
        retVal = retVal && breed.equals(otherDog.getBreed());
        retVal = retVal && owner.equals(otherDog.getOwner());
        retVal = retVal && sex.equals(otherDog.getSex());
        retVal = retVal && birthMonth == otherDog.getBirthMonth();
        retVal = retVal && birthDay == otherDog.getBirthDay();
        retVal = retVal && birthYear == otherDog.getBirthYear();

        return retVal;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String newSex) {
        this.sex = newSex;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int month) {
        this.birthMonth = month;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int day) {
        this.birthDay = day;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int year) {
        this.birthYear = year;
    }

    public static void serializeToCSV(Dog dog, String filename) throws IOException {   // argument output file, and dog to serialize
        PrintWriter outputWriter = new PrintWriter(filename,"UTF-8");
        BufferedWriter buffer = new BufferedWriter(outputWriter);
        buffer.write(dog.name + ", ");
        buffer.write(dog.breed + ", ");
        buffer.write(dog.sex + ", ");
        buffer.write(dog.owner + ", ");
        buffer.write(dog.birthMonth + ", ");
        buffer.write(dog.birthDay + ", ");
        buffer.write(dog.birthYear + "");

        buffer.close();
        outputWriter.close();
    }

    public static Dog deserializeFromCSV(String filename) throws IOException { // return a Dog, argument input file

        Dog dog = new Dog();
        File csv = new File(filename);

        String cvsSplitBy = ", ";
        BufferedReader br = new BufferedReader(new FileReader(csv));

        String[] dogcsv = br.readLine().split(cvsSplitBy);

        dog.name = dogcsv[0];
        // System.out.println(dog.name);
        dog.breed = dogcsv[1];
        // System.out.println(dog.breed);
        dog.sex = dogcsv[2];
        // System.out.println(dog.sex);
        dog.owner = dogcsv[3];
        // System.out.println(dog.owner);
        dog.birthMonth = Integer.parseInt(dogcsv[4]);
        // System.out.println(dog.birthdate);
        dog.birthDay = Integer.parseInt(dogcsv[5]);
        dog.birthYear = Integer.parseInt(dogcsv[6]);

        return dog;
    }

}
