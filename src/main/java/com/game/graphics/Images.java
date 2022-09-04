package com.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Images {

    private static final Map<String, BufferedImage> images;

    static {
        images = new HashMap<>();
        try {
            BufferedImage starship = ImageIO.read(new File("src/main/resources/images/starship.png"));
            images.put("starship", starship);
        } catch (Exception ignored) {}
    }

    public static BufferedImage getImage(String imageName) {
        return images.get(imageName);
    }
}
