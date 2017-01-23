/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

/**
 *
 * @author Josh
 */
public class Z_Piece extends Piece{
    
    private static final char COLOR = 'p';
    private boolean rotate;
    
    public Z_Piece(int x, int y){
        super(COLOR, x, y);
        blocks = new Block[4];
        blocks[0] = new Block(-1, 0, COLOR);
        blocks[1] = new Block(0, 0, COLOR);
        blocks[2] = new Block(1, -1, COLOR);
        blocks[3] = new Block(0, -1, COLOR);
        rotate = false;
    }
    
    @Override
    public void rotateCW(){
        if(rotate){
            blocks[0] = new Block(-1, 0, COLOR);
            blocks[2] = new Block(1, -1, COLOR);
            rotate = false;
        }else{
            blocks[0] = new Block(1, 0, COLOR);
            blocks[2] = new Block(1, 1, COLOR);
            rotate = true;
        }
    }
    
    @Override
    public void rotateCCW(){
        if(rotate){
            blocks[0] = new Block(-1, 0, COLOR);
            blocks[2] = new Block(1, -1, COLOR);
            rotate = false;
        }else{
            blocks[0] = new Block(1, 0, COLOR);
            blocks[2] = new Block(1, 1, COLOR);
            rotate = true;
        }
    }
}
