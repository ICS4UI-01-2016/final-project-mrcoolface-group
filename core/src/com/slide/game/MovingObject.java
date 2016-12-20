package com.slide.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prevw5940
 */
public class MovingObject {
    private Vector2 velocity;
    private Texture pic;
    private Rectangle bounds;
    
    public MovingObject(int x, int y, int width, int height){
        velocity = new Vector2(0,0);
        pic = new Texture("");
        bounds = new Rectangle(x,y,width,height);
        
    }
    
    
    //
    public void move(){
        bounds.y = velocity.y;
        bounds.x = velocity.x;
    }
    
    //
    public void render(SpriteBatch batch){
        batch.draw(pic, bounds.x, bounds.y);
    }
    
    //
    public void setVelocity(Vector2 velo){
        this.velocity = velo;
    }
    
    //
    public Rectangle getBounds(){
        return bounds;
    }
    
    //
    public void dispose(){
        pic.dispose();
    }
    
    
}
