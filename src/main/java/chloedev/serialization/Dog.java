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
    LocalDate birthdate;

    public Dog() {
        new Dog("Unnamed", "Free", "Mutt", "Unknown", 1, 1, 2020);
    }

    public Dog(String name, String owner, String breed, String sex, int month, int day, int year) {
        this.name = name;
        this.breed = owner;
        this.breed = breed;
        this.sex = sex;
        LocalDate date = LocalDate.of(year, month, day);
        this.birthdate = date;
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
        retVal = retVal && birthdate.equals(otherDog.getBirthDate());

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

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(int month, int day, int year) {
        LocalDate newBirthDate = LocalDate.of(year, month, day);
        this.birthdate = newBirthDate;
    }

    public static void serializeToCSV(Dog dog) throws IOException {   // argument output file, and dog to serialize
        PrintWriter outputWriter = new PrintWriter("file2.csv","UTF-8");
        outputWriter.write(dog.name + ", ");
        outputWriter.write(dog.breed + ", ");
        outputWriter.write(dog.sex + ", ");
        outputWriter.write(dog.owner + ", ");
        outputWriter.write(String.valueOf(dog.birthdate));

        outputWriter.close();
    }

    public static Dog deserializeFromCSV() throws IOException { // return a Dog, argument input file

        Dog dog = new Dog();
        File csv = new File("file2.csv");

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
        dog.birthdate = LocalDate.parse(dogcsv[4]);
        // System.out.println(dog.birthdate);

        return dog;
    }

}
