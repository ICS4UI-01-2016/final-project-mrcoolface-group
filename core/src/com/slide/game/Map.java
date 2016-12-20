/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Peter
 */
public class Map {
    private Texture bg;
    
    public Map(){
        
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(bg, 0, 0);
    }
    
    /*public boolean didCollide(MovingObject player, Object object){
        
    }*/
    
    public void dispose() {
        bg.dispose();
    }
    
}
