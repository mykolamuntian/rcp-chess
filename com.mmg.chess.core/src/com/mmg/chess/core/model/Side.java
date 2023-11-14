package com.mmg.chess.core.model;

public enum Side {
    WHITE, 
    BLACK;
    
    public Side opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
