package com.slide.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slide extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
        
        private StateManager sm;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                
                sm = new StateManager();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                sm.handleInput();
                sm.update(Gdx.graphics.getDeltaTime());
		batch.begin();
                sm.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
                img.dispose();
		batch.dispose();
	}
}
