/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Map {

    // instance variables
    private List<Object> object;
    private boolean collide;
    private int tempX;
    private int tempY;
    private int tempWidth;
    private int tempHeight;

    /**
     * Constructor for Map
     *
     * @param input the scanner to read the text file
     */
    public Map(Scanner input) {
        while (input.next().length() > 0) {
            tempX = input.nextInt();
            tempY = input.nextInt();
            tempWidth = input.nextInt();
            tempHeight = input.nextInt();
            object.add(new Object(tempX, tempY, tempWidth, tempHeight));
            input.nextLine();
        }
    }

    public void render(SpriteBatch batch) {

    }

    /**
     * Method to get whether the player has collided with an object
     *
     * @param player The player
     * @param object The objects
     * @return Whether the player has collided with an object; true if the
     * player has collided with an object, false if the player has collided with
     * an object
     */
    public boolean didCollide(MovingObject player, Object object) {
        for (Object object1 : this.object) {
            if (player.getBounds() == object.getBounds()) {
                collide = true;
            }
        }
        return collide;
    }

    public void dispose() {
    }

}
