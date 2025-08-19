package Java_Core;

import java.io.*;

public class Serialization_Demo implements Serializable {

    public int a;
    public String name;

    public Serialization_Demo(int a, String name){
        this.a=a;
        this.name=name;
    }

    public static void main(String[] args) throws Exception{
        Serialization_Demo demo = new Serialization_Demo(5, "This is Serialization file");
        String filename = "filename.ser";

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        out.writeObject(demo);
        out.close();
        fileOutputStream.close();
        System.out.println("Object has been serialized");

        System.out.println("Object deserialization in progress");

        Serialization_Demo object1 = null;

        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);
        object1 = (Serialization_Demo) in.readObject();
        in.close();
        file.close();
        System.out.println("Object has been deserialized");
        System.out.println("a = " + object1.a);
        System.out.println("name = " + object1.name);

    }
}
