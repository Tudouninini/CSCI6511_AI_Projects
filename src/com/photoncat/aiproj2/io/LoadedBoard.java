package com.photoncat.aiproj2.io;

import com.photoncat.aiproj2.game.SimpleBoard;

/**
 * The loaded board for {@link NetworkAdapter}
 */
public class LoadedBoard extends SimpleBoard {
    private static int getSizeFromString(String board) {
        return board.indexOf('\n');
    }

    /**
     * Constructor from a board String.
     * @param boardString
     * @param m
     */
    LoadedBoard(String boardString, int m) {
        super(getSizeFromString(boardString), m);
        String[] boardSplit = boardString.split("\\R");
        // fill the board.
        for (int i = 0; i < getSize(); ++i) {
            for (int j = 0; j < getSize(); ++j) {
                switch(boardSplit[i].charAt(j)) {
                    case '-':
                        board[i][j] = PieceType.NONE;
                        break;
                    case 'O':
                        steps += 1;
                        board[i][j] = PieceType.CIRCLE;
                        break;
                    case 'X':
                        steps += 1;
                        board[i][j] = PieceType.CROSS;
                        break;
                }
            }
        }
        // Leave the rest to the setLastMove method.
    }

    void setLastMove(int x, int y, PieceType type) {
        steps -= 1;
        board[x][y] = PieceType.NONE;
        next = type;
        putPiece(x, y);
    }
}