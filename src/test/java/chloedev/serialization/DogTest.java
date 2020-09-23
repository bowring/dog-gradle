package chloedev.serialization;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static chloedev.serialization.BinSerialization.deserializeBinary;
import static chloedev.serialization.BinSerialization.serializeBinary;
import static chloedev.serialization.Dog.deserializeFromCSV;
import static chloedev.serialization.Dog.serializeToCSV;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DogTest extends TestCase {

    Dog dog1 = new Dog();
    //Dog dog1 = new Dog("Louie", "Chloe", "goldendoodle", "boy", 5, 31, 2016);
    String csvfilename = "csvtest.csv";
    String binfilename = "bintest.ser";

    @Before
    public void setUp() {
        //dog1 = new Dog("Louie", "Chloe", "goldendoodle", "boy", 5, 31, 2016);
        dog1.setName("Louie");
        dog1.setBreed("goldendoodle");
        dog1.setOwner("Chloe");
        dog1.setSex("boy");
        dog1.setBirthMonth(5);
        dog1.setBirthDay(30);
        dog1.setBirthYear(2016);
    }

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testSerializeBinary() throws IOException, ClassNotFoundException {
        serializeBinary(dog1, binfilename);
        Dog dog2 = (Dog) deserializeBinary(dog1, binfilename);

        assertEquals(dog1, dog2);
    }

    @Test
    public void testSerializeBinaryBad() throws IOException, ClassNotFoundException {
        serializeBinary(dog1, binfilename);
        dog1.setBreed("boxer");
        Dog dog2 = (Dog) deserializeBinary(dog1, binfilename);

        assertNotEquals(dog1, dog2);
    }

    @Test
    public void testSerializeToCsv() throws IOException {
        serializeToCSV(dog1, csvfilename);
        Dog dog2 = deserializeFromCSV(csvfilename);

        assertEquals(dog1, dog2);
    }

    @Test
    public void testSerializeToCsvBad() throws IOException {
        serializeToCSV(dog1, csvfilename);
        dog1.setOwner("Mr. Smith");
        Dog dog2 = deserializeFromCSV(csvfilename);

        assertNotEquals(dog1, dog2);
    }

}