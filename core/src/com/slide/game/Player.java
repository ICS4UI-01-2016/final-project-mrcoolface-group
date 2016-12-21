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
public class Player extends MovingObject{
    
    private int score;
    
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        score = 0;
    }
    
    public int getScore(){
        return score;
    }
    
    public void add(int add){
        this.score += add;
    }
    
}
