/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author lamon
 */
public abstract class State {
    private OrthographicCamera cam;
    private StateManager stateManager;
    Music music;
    
    public State(StateManager sm){
        stateManager = sm;
        cam = new OrthographicCamera();
        music = Gdx.audio.newMusic(Gdx.files.internal("tetrisMusic.mp3"));
    }
    
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    public boolean isPlayingMusic(){
        return music.isPlaying();
    }
    
    public StateManager getStateManager(){
        return stateManager;
    }
    
    public OrthographicCamera getCamera(){
        return cam;
    }
    
    public void setCameraView(float width, float height){
        cam.setToOrtho(false, width, height);
        cam.update();
    }
    
    public void setCameraPosition(float x, float y){
        cam.position.x = x;
        cam.position.y = y;
        cam.update();
    }
    
    public Matrix4 getCombinedCamera(){
        return cam.combined;
    }
    
    public void moveCameraX(float x){
        cam.position.x = x;
        cam.update();
    }
    
    public float getCameraX(){
        return cam.position.x;
    }
    
    public float getCameraY(){
        return cam.position.y;
    }
    
    public float getViewWidth(){
        return cam.viewportWidth;
    }
    
    public float getViewHeight(){
        return cam.viewportHeight;
    }
    
    public void unproject(Vector3 touch){
        cam.unproject(touch);
    }
    
    
}
