/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Josh
 */
public class Block {
    
    public static final int IMAGE_SIZE = 25;
    
    private Vector2 position;
    private char color;
    private Texture blockPic;
    
     public Block(double x, double y, char color){
         this.color = color;
         this.position = new Vector2((float)x, (float)y);
         blockPic = new Texture("images.jpg");
     }
     //set block position
     public void setPosition(double x, double y){
         this.position.set((float)x, (float)y);
     }
     //move position
     public void movePosition(int x, int y){
         this.position.add(x, y);
     }
     
     public Vector2 getPosition(){
         return this.position;
     }
     //rotate clockwise
     public void rotateCW(){
         this.position.rotate(90);
     }
     //rotate counterclockwise
     public void rotateCCW(){
         this.position.rotate(-90);
     }
     
     public void render(SpriteBatch batch, Vector2 relative){
         batch.draw(blockPic, this.position.cpy().scl(this.IMAGE_SIZE).x+relative.x+(IMAGE_SIZE/2), this.position.cpy().scl(this.IMAGE_SIZE).y+relative.y+(IMAGE_SIZE/2), IMAGE_SIZE, IMAGE_SIZE);
     }
     
     public void dispose(){
         blockPic.dispose();
     }
}
