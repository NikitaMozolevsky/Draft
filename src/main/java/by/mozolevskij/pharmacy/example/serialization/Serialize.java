package by.mozolevskij.pharmacy.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void main(String[] args) throws Exception {
        StaticUser staticUser = new StaticUser();
        staticUser.lifeLevel = 55;
        staticUser.staticField = 45;
        Sword sword = new Sword();
        sword.swordLevel = 5;
        staticUser.sword = sword;

        FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(staticUser);
        objectOutputStream.close();
        fileOutputStream.close();

        staticUser.staticField = 35;

        FileInputStream fileInputStream = new FileInputStream("tempFile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        StaticUser newUser = (StaticUser) objectInputStream.readObject();
        fileInputStream.close();
        objectOutputStream.close();
        System.out.println(newUser.lifeLevel);
        System.out.println(newUser.staticField);
        System.out.println(newUser.sword/*.swordLevel*/);
        }
    }
