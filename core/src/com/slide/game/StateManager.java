/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 *
 * @author Josh
 */
public class StateManager {
    private Stack<State> states;
    
    public StateManager(){
        states = new Stack<State>();
    }
    
    public void push(State s){
        states.push(s);
    }
    
    public void pop(){
        State s = states.pop();
        s.dispose();
    }
    
    public void set(State s){
        pop();
        push(s);
    }
    
    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }
}
