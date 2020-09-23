/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chloedev.serialization;

import java.io.*;

import static chloedev.serialization.BinSerialization.*;
import static chloedev.serialization.Dog.*;

/**
 *
 * @author ces
 */
public class DogDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog1 = new Dog();
        dog1.setName("Louie");
        dog1.setBreed("goldendoodle");
        dog1.setOwner("Chloe");
        dog1.setSex("boy");
        dog1.setBirthMonth(5);
        dog1.setBirthDay(30);
        dog1.setBirthYear(2016);


        String csvfilename = "file.csv";

        serializeToCSV(dog1, csvfilename);
        System.out.println("Serialized!");

        deserializeFromCSV(csvfilename);
        System.out.println("And now deserialized!");

        String binfilename = "file2.ser";

        serializeBinary(dog1, binfilename);

        System.out.println("Binary Serialized!");

        Dog dog2 = (Dog) deserializeBinary(dog1, binfilename);

        System.out.println("Binary Deserialized!");
        System.out.println(dog2.prettyPrint());




    }

}
