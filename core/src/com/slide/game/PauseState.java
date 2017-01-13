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
public class PauseState extends State{
    // instance variables
    private Texture bg;
    private Texture resumeButton;
    private int score;
    private BitmapFont font;
    private Texture musicButton;
    private Texture quitButton;
    
    
    public PauseState(StateManager gsm){
        super(gsm);
        setCameraView(800, 800);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        bg = new Texture("bg.png");
        resumeButton = new Texture("playButton.png");
        musicButton = new Texture("soundButton.png");
        quitButton = new Texture("quitButton.png");
        font = new BitmapFont(); // default font - 15pt Arial
        
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        font.draw(batch, "" + score, getViewWidth() / 2, getViewHeight() - 100);
        batch.draw(resumeButton, getViewWidth() / 2 - resumeButton.getWidth() / 2, getViewHeight() / 2);
        batch.draw(musicButton, getViewWidth() / 2 - musicButton.getWidth() / 2, getViewHeight() / 2);
        batch.draw(quitButton, getViewWidth() / 2 - quitButton.getWidth() / 2, getViewHeight() / 2);
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            // get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // convert that point to "game coordinates"
            //unproject(touch);
            // check if button is checked
            float buttonX = getViewWidth() / 2 - resumeButton.getWidth() / 2;
            float buttonY = getViewHeight() / 2;
            if (touch.x > buttonX && touch.x < buttonX + resumeButton.getWidth() && touch.y > buttonY && touch.y < buttonY + resumeButton.getHeight()) {
                StateManager gsm = getStateManager();
                gsm.pop();
            }
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        resumeButton.dispose();
        musicButton.dispose();
    }
    
    
}
