/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class Board {
    
    private boolean[][] spots;
    private Vector2 position;
    private ArrayList<Block> blocks;
    private Piece piece;
    
    public final int BOARD_WIDTH = 10;
    public final int BOARD_HEIGHT = 22;
    
    public Board(int x, int y){
        //set position
        this.position = new Vector2(x, y);
        //Define size of board
        this.spots = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
        //initilize all as false
        for(boolean[] line: this.spots){
            for(boolean spot: line){
                spot = false;
            }
        }
    }
    
    //check if a spot has a block
    public boolean spotCheck(int x, int y){
        return this.spots[y][x];
    }
    
    public boolean lineCheck(int y){
        //check all spots in line y
        for(boolean spot: this.spots[y]){
            //if any are false return false
            if(spot==false){
                return false;
            }
        }
        return true;
    }
    
    public void makePiece(){
        this.piece = new T_Piece(BOARD_WIDTH/2, BOARD_HEIGHT);
    }
    
    public void killSpot(int x, int y){
        boolean found = false;
        for(Block block: blocks){
            if(!found
                    && block.getPosition().x == x 
                    && block.getPosition().y == y){
                found = true;
                
            }
        }
    }
    
    public Vector2 getPosition(){
        return this.position;
    }
    
    public void render(SpriteBatch batch){
        for(Block block: blocks){
            block.render(batch, position);
        }
        this.piece.render(batch, position);
    }
    
}
