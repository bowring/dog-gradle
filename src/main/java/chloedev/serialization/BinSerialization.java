package chloedev.serialization;

import java.io.*;

public class BinSerialization {

    public static void serializeBinary(Object objectToSerialize, String filename) throws IOException {

        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(objectToSerialize);

        out.close();
        file.close();

    }

    public static Object deserializeBinary(Object objectToSerialize, String filename) throws IOException, ClassNotFoundException {

        Object deserializedObject = null;

        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        deserializedObject = (Object)in.readObject();

        in.close();
        file.close();

        return deserializedObject;

    }
}
