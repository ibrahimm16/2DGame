package com.engine.util.generics;

import com.engine.Constants;
import com.engine.abstracts.object.GameObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<T extends GameObject> {

    public void serialize(T serializable) {
        try {
            String path = getFilePath(serializable.getClass().getSimpleName());
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serializable);
            oos.flush();
        } catch (Exception ignored) {}
    }

    public T deserialize(Class<T> serializableClass) {
        try {
            String path = getFilePath(serializableClass.getSimpleName());
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (T) ois.readObject();
        } catch (Exception ignored) {}
        return null;
    }

    private String getFilePath(String name) {
        return Constants.DATA_PATH + name + ".bin";
    }
}
