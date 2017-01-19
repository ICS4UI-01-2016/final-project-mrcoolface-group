/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author prevw5940
 */
public class MenuState extends State{
    private Texture bg;
    private Texture button;
    private int highScore;
    private BitmapFont font;
    
    public MenuState(StateManager gsm){
        super(gsm);
        bg = new Texture("StartScreen.jpg");
        button = new Texture("StartButton.png");
        setCameraView(800, 800);
        setCameraPosition(getViewWidth()/2, getViewHeight()/2);
        
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
        font = new BitmapFont(); //default 15pt Arieal
        music = Gdx.audio.newMusic(Gdx.files.internal("tetrisMusic.mp3"));
        music.play();
        music.setLooping(true);
    }
    
    public void updateScore(){
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
    }
    
    @Override
    public void update(float deltaTime) {
        
    }
    
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            //get mouse click position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // convert the point to "Game coordinates"
            unproject(touch);
            //check if button is pressed
            float buttonX = getViewWidth()/2 - button.getWidth()/2;
            float buttonY = getViewHeight()/2;
            if(touch.x > buttonX && touch.x < buttonX + button.getWidth() && touch.y > buttonY && touch.y < buttonY + button.getHeight()){
                StateManager gsm = getStateManager();
                gsm.push(new PlayState(gsm));
            }
        }
    }
    
    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(button, getViewWidth()/2 - button.getWidth()/2, getViewHeight()/2);
        font.draw(batch, highScore + "", getViewWidth()/2, getViewHeight() - 100);
    }
    
    @Override
    public void dispose() {
        bg.dispose();
        button.dispose();
    }

    
}
