/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Peter
 */
public class PlayState extends State {

    // instance variables
    private int score;
    private boolean quit;
    private boolean pause;
    private BitmapFont font;
    private Texture bg;

    public PlayState(StateManager sm) {
        super(sm);
        // set up the score and font
        score = 0;
        font = new BitmapFont();
    }

    @Override
    public void render(SpriteBatch batch) {
        // beginning of stuff to draw
        batch.begin();
        // draw the background
        batch.draw(bg, 0, 0);
        // draw the score
        font.draw(batch, "" + score, 150, 150);

        // end of stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        //
        if (quit == true /*or if the player looses*/) {
            // end the game 
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu
            gsm.pop();
        }
        if(pause == true){
            // bring up a pause button in front of the game
        }
    }

    @Override
    public void handleInput() {
        //
    }

    @Override
    public void dispose() {
        //
        bg.dispose();
    }

}
