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
    
    private Block[] blocks;
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
    
    public void render(SpriteBatch batch){
        for(Block block: this.blocks){
            
        }
    }
    
    public void dispose(){
        for(Block block: this.blocks){
            block.dispose();
        }
    }
    
}
