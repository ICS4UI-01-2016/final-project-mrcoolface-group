/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Josh
 */
public class PlayState extends State{
    
    private final int VIEW_WIDTH = 300;
    private final int VIEW_HEIGHT = 300;
    private final int PLAYER_WIDTH = 50;
    private final int PLAYER_HEIGHT = 50;
    private MovingObject player;
    private Map map;
    
    public PlayState(StateManager sm){
        super(sm);
        this.map = new Map();
        this.player = new MovingObject(200, 200, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        map.render(batch);
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
