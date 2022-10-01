package com.game.entities;

import com.engine.abstracts.object.Enemy;
import com.engine.util.generics.SerializerUtil;

import java.awt.*;

public class Carl extends Enemy {

    public Carl() {
        super();
        vector.x = 500;
        vector.y = 500;
        hp = 200;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int)vector.x, (int)vector.y, null);
        g.setColor(Color.white);
        g.drawString(""+hp, (int)vector.x -25, (int)vector.y);
    }
}
