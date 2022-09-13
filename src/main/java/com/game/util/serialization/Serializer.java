package com.game.util.serialization;

import com.game.entities.Starship;
import com.game.graphics.Images;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    public static void serializeStarship(Starship starship) {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/Starship.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(starship);
            oos.flush();
        } catch (Exception e) {

        }
    }

    public static Starship deserializeStarship() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Starship.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Starship starship = (Starship) ois.readObject();
            starship.setX(100);
            starship.setY(100);
            starship.setSpeed(2);
            starship.setImage(Images.getImage("starship"));
            return starship;
        } catch (Exception e) {

        }
        return new Starship();
    }
}
