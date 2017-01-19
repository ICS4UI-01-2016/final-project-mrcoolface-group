/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Josh
 */
public abstract class Piece {
    
    public Block[] blocks;
    private char color;
    private Vector2 position;
    
    public Piece(char color, int x, int y){
        this.color = color;
        this.position = new Vector2(x, y);
    }
    //rotate all blocks clockwise
    public void rotateCW(){
        for(Block block: blocks){
            block.rotateCW();
        }
    }
    //rotate all blocks counterclockwise
    public void rotateCCW(){
        for(Block block: this.blocks){
            block.rotateCCW();
        }
    }
    
    public Block[] getBlocks(){
        return this.blocks;
    }
    //check if block is bellow any of the piece
    public boolean stop(boolean[][] spots){
        boolean check = false;
        for(Block block: blocks){
            if((int)block.getPosition().y+this.position.y==0){
                check = true;
            }else if(spots[(int)this.position.y+(int)block.getPosition().y-1][(int)this.position.x+(int)block.getPosition().x]){
                check = true;
            }
        }
        return check;
    }
    
    public Vector2 getPosition(){
        return this.position;
    }
    
    public void render(SpriteBatch batch, Vector2 relative){
        for(Block block: this.blocks){
            block.render(batch, this.position.cpy().scl(Block.IMAGE_SIZE).add(relative));
        }
    }
    
    public void move(int x, int y){
        this.position.y += y;
        this.position.x += x;
    }
    
    public void dispose(){
        for(Block block: this.blocks){
            block.dispose();
        }
    }
    
}
