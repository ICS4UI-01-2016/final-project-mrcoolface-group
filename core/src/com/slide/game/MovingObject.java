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
    private Vector2 position;
    
    public MovingObject(int x, int y, int width, int height){
        velocity = new Vector2(0,0);
        pic = new Texture("Crosseyed.gif");
        bounds = new Rectangle(x,y,width,height);
        position = new Vector2(x, y);
    }
    
    
    public float getPositionX(){
        return this.position.x;
    }
    
    public float getPositionY(){
        return this.position.y;
    }
    
    //
    public void move(){
        bounds.y += velocity.y;
        bounds.x += velocity.x;
        position.set(bounds.x, bounds.y);
    }
    
    //
    public void render(SpriteBatch batch){
        batch.draw(pic, position.x, position.y);
    }
    
    //
    public void setVelocity(Vector2 velo){
        if(velo!=null){
            this.velocity.set(velo);
        }
    }
    
    //
    public Rectangle getBounds(){
        return bounds;
    }
    
    //
    public void dispose(){
        pic.dispose();
    }
    
    public Vector2 getMid(){
        return new Vector2(this.position.x+(this.bounds.x/2), this.position.y+(this.bounds.y/2));
    }
    
    
}
