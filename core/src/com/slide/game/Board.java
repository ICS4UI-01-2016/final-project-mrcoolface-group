/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private float delta;
    
    public final int BOARD_WIDTH = 10;
    public final int BOARD_HEIGHT = 22;
    
    public Board(int x, int y){
        //make blocks
        this.blocks = new ArrayList<Block>();
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
        int random = (int)Math.floor(Math.random()*3);
        switch(random){
            case 0: this.piece = new T_Piece(BOARD_WIDTH/2, BOARD_HEIGHT);
                break;
            case 1: this.piece = new L_Piece(BOARD_WIDTH/2, BOARD_HEIGHT);
                break;
            case 2: this.piece = new J_Piece(BOARD_WIDTH/2, BOARD_HEIGHT);
                break;
            default: this.piece = new Cude_Piece(BOARD_WIDTH/2, BOARD_HEIGHT);
                break;
                
        }
    }
    
    public boolean hasPiece(){
        return piece != null;
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
        if(blocks.size()>0){
        for(Block block: blocks){
            block.render(batch, position);
        }
        }
        this.piece.render(batch, position);
    }
    
    public void update(float deltaTime){
        if(this.piece.stop(spots)){
            for(Block block: this.piece.getBlocks()){
                block.movePosition((int)this.piece.getPosition().x, (int)this.piece.getPosition().y);
                spots[(int)block.getPosition().y][(int)block.getPosition().x] = true;
                blocks.add(block);
            }
            makePiece();
        }else if(deltaTime+this.delta>=0.5){
            this.piece.move(0,-1);
            this.delta=0;
        }else{
            delta+=deltaTime;
        }
    }
    
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            //move piece left
            this.piece.move(-1, 0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            //move piece right
            this.piece.move(1, 0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            this.piece.rotateCW();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            this.piece.rotateCCW();
        }
    }
    
}
