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
public class I_Piece extends Piece {
    
    private static final char COLOR = 'b';

    public I_Piece(int x, int y) {
        super(COLOR, x, y);
        this.blocks = new Block[4];
        blocks[0] = new Block(-1, 0, COLOR);
        blocks[1] = new Block(0, 0, COLOR);
        blocks[2] = new Block(1, 0, COLOR);
        blocks[3] = new Block(2, 0, COLOR);
    }
    
    
}
