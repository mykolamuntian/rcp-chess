package com.mmg.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.mmg.chess.core.icon.IconHandler;
import com.mmg.chess.core.model.Side;
import com.mmg.chess.core.model.Square;

public class Knight extends Piece {

    public Knight(Square square, Side side) {
        super(square, side, 3, IconHandler.getIcon("Knight", side));
    }

    @Override
    public String toString() {
        return side == Side.WHITE ? "N" : "n";
    }

    @Override
    public List<Square> computeLegalMoves() {
        List<Square> legalMoves = new ArrayList<Square>();
        Square targetSquare = square.getAdjacentSquare(1, 2);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(-1, 2);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(1, -2);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(-1, -2);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(2, 1);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(-2, 1);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(2, -1);
        checkSquare(legalMoves, targetSquare);
        targetSquare = square.getAdjacentSquare(-2, -1);
        checkSquare(legalMoves, targetSquare);

        return legalMoves;
    }
    


}
