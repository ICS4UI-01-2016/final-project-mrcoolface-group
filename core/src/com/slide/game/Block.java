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
    
    private Vector2 position;
    private char color;
    private Texture blockPic;
    
     public Block(int x, int y, char color){
         this.color = color;
         this.position = new Vector2(x, y);
     }
     //set block position
     public void setPosition(int x, int y){
         this.position.set(x, y);
     }
     //move position
     public void movePosition(int x, int y){
         this.position.add(x, y);
     }
     //rotate clockwise
     public void rotateCW(){
         this.position.rotate(90);
     }
     //rotate counterclockwise
     public void rotateCCW(){
         this.position.rotate(-90);
     }
     
     public void render(SpriteBatch batch, int x, int y){
         batch.draw(blockPic, x, y);
     }
     
     public void dispose(){
         blockPic.dispose();
     }
}
