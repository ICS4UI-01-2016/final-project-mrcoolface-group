/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Peter
 */
public class GameOverState extends State{
    // instance variables
    private int score;
    private BitmapFont font;
    private Texture bg;

    /**
     * Constructor for PauseState
     * @param gsm game state manager
     */
    public GameOverState(StateManager gsm){
        super(gsm);
        // create the camera 
        setCameraView(800, 800);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        // load in the pictures
        bg = new Texture("bg.png");
        // create the font
        font = new BitmapFont(); // default font - 15pt Arial
        
    }

    /**
     * Render method
     * @param batch SpriteBatch
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        StateManager gsm = getStateManager();
        gsm.getState(1).render(batch);
        batch.draw(bg, 0, 0, 800, 800);
        font.getData().setScale(5, 5);
        font.draw(batch, "GAME OVER", getViewWidth()/2 - 200, 600);
        font.draw(batch, "Score: ", getViewWidth()/2 - 100, 450);
        font.draw(batch, "" + score, getViewWidth()/2 - 30, 300);
        

    }

    @Override
    public void update(float deltaTime) {
        
    }

    /**
     * Method to handle input
     */
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            // get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // convert that point to "game coordinates"
            unproject(touch);
            // check if button is checked
            if (touch.x > 0) {
                StateManager gsm = getStateManager();
                gsm.pop();
                gsm.pop();
            }
            
        }
    }

    /**
     * Method to dispose of the things
     */
    @Override
    public void dispose() {
        bg.dispose();
    }
    
    
}
