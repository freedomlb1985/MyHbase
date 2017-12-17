package com.frey.base.syntax;

import java.io.*;

/**
 * Created by Frey on 2017/11/3.
 */
public class ExternalizableAndSerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableAndSerializableTest et = new ExternalizableAndSerializableTest();
        et.testExternalizable();
        et.testSerializable();

    }

    public void testExternalizable() throws IOException, ClassNotFoundException {
        ExternalizableClass et = new ExternalizableClass();
        SerializableClass sc = new SerializableClass();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("./test1")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test1")));
        et = (ExternalizableClass) in.readObject();
        System.out.println(et.content);
        System.out.println(et.name);

        out.close();
        in.close();
    }

    public void testSerializable() throws IOException, ClassNotFoundException {
        SerializableClass et = new SerializableClass();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("./test2")));
        out.writeObject(et);
        SerializableClass.staticVariable = "value2";
        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test2")));
        et = (SerializableClass) in.readObject();
        System.out.println(et.content);
        System.out.println(et.name);
        System.out.println(SerializableClass.staticVariable);

        out.close();
        in.close();
    }







}



