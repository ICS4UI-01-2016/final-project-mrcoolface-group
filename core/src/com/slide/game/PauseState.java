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
    private boolean isPlaying = false;
    
    
    private final int RESUME_BUTTON_WIDTH = 200;
    private final int RESUME_BUTTON_HEIGHT = 200;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 100;
    
    public PauseState(StateManager gsm){
        super(gsm);
        setCameraView(800, 800);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        bg = new Texture("bg.png");
        resumeButton = new Texture("resumeButton.png");
        musicButton = new Texture("musicButton.png");
        quitButton = new Texture("quitButton.png");
        font = new BitmapFont(); // default font - 15pt Arial
        
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        StateManager gsm = getStateManager();
        gsm.getState(1).render(batch);
        //batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        font.draw(batch, "Score: " + score, getViewWidth()/2 - 30, 700);
        batch.draw(resumeButton, getViewWidth()/2 - RESUME_BUTTON_WIDTH/2, getViewHeight()/2, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
        batch.draw(musicButton, getViewWidth()/4*3 - BUTTON_WIDTH/2, getViewHeight()/2, BUTTON_WIDTH, BUTTON_HEIGHT);
        batch.draw(quitButton, getViewWidth()/4 - BUTTON_WIDTH/2, getViewHeight()/2, BUTTON_WIDTH, BUTTON_HEIGHT);
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
            unproject(touch);
            // check if button is checked
            float resumeButtonX = getViewWidth()/2 - RESUME_BUTTON_WIDTH/2;
            float buttonY = getViewHeight()/2;
            if (touch.x > resumeButtonX && touch.x < resumeButtonX + RESUME_BUTTON_WIDTH && touch.y > buttonY && touch.y < buttonY + RESUME_BUTTON_HEIGHT) {
                StateManager gsm = getStateManager();
                gsm.pop();
            }
            // quit button
            float quitButtonX = getViewWidth()/4 - BUTTON_WIDTH/2;
            if (touch.x > quitButtonX && touch.x < quitButtonX + RESUME_BUTTON_WIDTH && touch.y > buttonY && touch.y < buttonY + RESUME_BUTTON_HEIGHT) {
                StateManager gsm = getStateManager();
                gsm.pop();
                gsm.pop();
            }
            // music button
            float musicButtonX = getViewWidth()/4*3 - BUTTON_WIDTH/2;
            if (touch.x > musicButtonX && touch.x < musicButtonX + RESUME_BUTTON_WIDTH && touch.y > buttonY && touch.y < buttonY + RESUME_BUTTON_HEIGHT) {
                StateManager gsm = getStateManager();
                State ms = gsm.getState(0);
                if(ms.isPlayingMusic() == true){
                    ms.music.pause();
                }else if(ms.isPlayingMusic() == false){
                    ms.music.play();
                }
                
            }
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        resumeButton.dispose();
        musicButton.dispose();
        quitButton.dispose();
    }
    
    
}
