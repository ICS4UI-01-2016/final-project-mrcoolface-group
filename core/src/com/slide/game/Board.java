/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slide.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class Board {

    private boolean[][] spots;
    private Vector2 position;
    private ArrayList<Block> blocks;
    private Piece piece;
    private Piece[] upComing;
    private final double SLOW_FALL = 0.5;
    private final double FAST_FALL = 0.1;
    private boolean fastFall;
    private float delta;
    private boolean over = false;

    public final int BOARD_WIDTH = 10;
    public final int BOARD_HEIGHT = 22;

    public Board(int x, int y) {
        //make blocks
        this.blocks = new ArrayList<Block>();
        //set position
        this.position = new Vector2(x, y);
        //Define size of board
        this.spots = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
        //initilize all as false
        for (boolean[] line : this.spots) {
            for (boolean spot : line) {
                spot = false;
            }
        }
        this.fastFall = false;
        this.upComing = new Piece[3];
    }

    //check if a spot has a block
    public boolean spotCheck(int x, int y) {
        try {
            return this.spots[y][x];
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean lineCheck(int y) {
        //check all spots in line y
        for (boolean spot : this.spots[y]) {
            //if any are false return false
            if (spot == false) {
                return false;
            }
        }
        return true;
    }

    public Piece makePiece() {
        //randomize and return a piece
        switch ((int) Math.floor(Math.random() * 7)) {
            case 0:
                return new T_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 1:
                return new L_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 2:
                return new J_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 3:
                return new S_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 4:
                return new Z_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 5:
                return new I_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            case 6:
                return new Cude_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
            default:
                return new Cude_Piece(BOARD_WIDTH / 2, BOARD_HEIGHT);
        }
    }

    public Piece takeFromUpComing() {
        //if nothing in array fill it
        if (this.upComing[0] == null) {
            for (Piece piece : upComing) {
                piece = makePiece();
            }
        }
        //save first piece
        Piece piece = this.upComing[0];
        //move everthing down
        for (int i = 0; i < this.upComing.length - 1; i++) {
            this.upComing[i] = this.upComing[i + 1];
        }
        //make new piece for last spot
        this.upComing[this.upComing.length - 1] = makePiece();
        //return saved piece
        return piece;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public void killSpot(int x, int y) {
        boolean found = false;
        for (Block block : blocks) {
            if (!found
                    && block.getPosition().x == x
                    && block.getPosition().y == y) {
                found = true;

            }
        }
    }

    public boolean gameOver() {
        for (Block block : blocks) {
            if (!over && block.getPosition().y >= 21) {
                over = true;
            }
        }
        return over;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void render(SpriteBatch batch) {
        if (blocks.size() > 0) {
            for (Block block : blocks) {
                block.render(batch, position);
            }
        }
        this.piece.render(batch, position);

    }

    public void update(float deltaTime) {
        //make a piece if there is not one
        if (!hasPiece() && this.gameOver() == false) {
            this.piece = makePiece();
        }
        //set fallspeed
        double fallSpeed;
        if (this.fastFall) {
            fallSpeed = this.FAST_FALL;
        } else {
            fallSpeed = this.SLOW_FALL;
        }
        if (this.piece.stop(spots)) {
            //transfer blocks from piece to board
            for (Block block : this.piece.getBlocks()) {
                try {
                    block.movePosition((int) this.piece.getPosition().x, (int) this.piece.getPosition().y);
                    spots[(int) block.getPosition().y][(int) block.getPosition().x] = true;
                    blocks.add(block);
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {

                }
            }
            this.piece = makePiece();
        } else if (deltaTime + this.delta >= fallSpeed) {
            //move piece down
            this.piece.move(0, -1);
            this.delta = 0;
        } else {
            //add to time to keep track
            delta += deltaTime;
        }
    }

    public void handleInput() {
        //take input
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            //move piece left
            this.piece.move(-1, 0);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            //move piece right
            this.piece.move(1, 0);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            this.piece.rotateCW();
        }
        //activate fast fall if key is pressed
        this.fastFall = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        //check if it moves out of bounds
        boolean boundsCheck = true;

        // so that blocks stay inside the grid
        for (Block block : this.piece.getBlocks()) {
            if (block.getPosition().x + this.piece.getPosition().x < 0
                    || block.getPosition().x + this.piece.getPosition().x > 9) {
                boundsCheck = false;
            }
        }
        // so that blocks don't merge together from the side
        for (Block block : this.piece.getBlocks()) {
            if (this.spotCheck((int) piece.getPosition().x + (int) block.getPosition().x, (int) piece.getPosition().y + (int) block.getPosition().y)) {
                boundsCheck = false;
            }
        }

        //undo if out of bounds
        if (!boundsCheck) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                this.piece.move(1, 0);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                this.piece.move(-1, 0);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                this.piece.rotateCCW();
            }
        }
    }

}
