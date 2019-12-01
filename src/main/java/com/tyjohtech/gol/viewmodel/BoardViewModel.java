package com.tyjohtech.gol.viewmodel;

import com.tyjohtech.gol.model.Board;
import com.tyjohtech.gol.model.CellPosition;
import com.tyjohtech.gol.util.Property;

public class BoardViewModel {

    private Property<Board> board = new Property<>();
    private Property<CellPosition> cursorPosition = new Property<>();

    public Property<Board> getBoard() {
        return board;
    }

    public Property<CellPosition> getCursorPosition() {
        return cursorPosition;
    }
}
