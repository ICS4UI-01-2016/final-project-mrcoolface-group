/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class Object {
    // instance variables
    private Texture object;
    private Vector3 position;
    private Vector3 velocity;
    private boolean collide;
    
    // 
    private final float MOVEMENT = 100;
    
    
    public Object(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        //object = new Texture();
    }
    
    
    public void render(SpriteBatch batch) {
        batch.draw(object, position.x, position.y);
    }
    
    public void dispose() {
        object.dispose();
    }
    
}
