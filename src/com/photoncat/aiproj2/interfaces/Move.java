package com.photoncat.aiproj2.interfaces;

/**
 * A wrapper class for a move. Including x and y. POD type (or so).
 */
public class Move {
    public int x;
    public int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
