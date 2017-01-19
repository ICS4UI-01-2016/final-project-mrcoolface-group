/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Peter
 */
public class PlayState extends State {
    // instance variables
    private int score;
    private BitmapFont font;
    private Texture bg;
    private Texture pauseButton;
    private Board board;
    
    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(WIDTH, HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        // load in pictures
        bg = new Texture("bg.png");
        pauseButton = new Texture("pauseButton.png");
        // set up the score and font
        score = 0;
        font = new BitmapFont();
        this.board = new Board(75, 50);
    }

    public int getScore(){
        return score;
    }
    
    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        // draw the background
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(pauseButton, 680, 680, 80, 80);
        // draw the score
        font.draw(batch, "" + score, 150, 150);
        //draw board
        board.render(batch);
    }

    @Override
    public void update(float deltaTime) {
        /*
        if (if the player looses) {
            // end the game 
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu
            gsm.pop();
        }
        */
        if(!board.hasPiece()){
            board.makePiece();
        }
        board.update(deltaTime);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            // get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            // convert that point to "game coordinates"
            unproject(touch);
            // check if button is checked
            float buttonX = 680;
            float buttonY = 680;
            if (touch.x > buttonX && touch.x < buttonX + pauseButton.getWidth() && touch.y > buttonY && touch.y < buttonY + pauseButton.getHeight()) {
                StateManager gsm = getStateManager();
                gsm.push(new PauseState(gsm));
            }
        }
        board.handleInput();
    }

    @Override
    public void dispose() {
        // dispose of textures
        bg.dispose();
        pauseButton.dispose();
    }

}
