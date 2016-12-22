/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class PlayState extends State{
    
    private final int VIEW_WIDTH = 300;
    private final int VIEW_HEIGHT = 300;
    private final int PLAYER_WIDTH = 50;
    private final int PLAYER_HEIGHT = 50;
    private Player player;
    private Vector2 velocity;
    private Map map;
    
    public PlayState(StateManager sm){
        super(sm);
        Scanner s = new Scanner("map.txt");
        //this.map = new Map(s);
        this.player = new Player(200, 200, PLAYER_WIDTH, PLAYER_HEIGHT);
        setCameraPosition(player.getMid().x-(VIEW_WIDTH/2), player.getMid().y-(VIEW_HEIGHT/2));
    }

    @Override
    public void render(SpriteBatch batch) {
        setCameraPosition(player.getMid().x-(VIEW_WIDTH/2), player.getMid().y-(VIEW_HEIGHT/2));
        batch.begin();
        //map.render(batch);
        player.render(batch);
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        player.setVelocity(velocity);
        player.move();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched()){
            this.velocity.x = Gdx.input.getX()-player.getMid().x;
            this.velocity.y = Gdx.input.getY()-player.getMid().y;
        }
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
