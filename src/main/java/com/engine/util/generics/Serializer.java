package com.engine.util.generics;

import com.engine.abstracts.object.GameObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<T extends GameObject> {

    private static final String PATH = "src/main/resources/data/";

    public void serialize(T serializable) {
        try {
            String name = serializable.getClass().getSimpleName();
            FileOutputStream fos = new FileOutputStream(PATH + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serializable);
            oos.flush();
        } catch (Exception ignored) {}
    }

    public T deserialize(Class<T> serializableClass) {
        try {
            String name = serializableClass.getSimpleName();
            FileInputStream fis = new FileInputStream(PATH + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            T t = (T) ois.readObject();
            t.init();
            return t;
        } catch (Exception ignored) {}
        return null;
    }
}
