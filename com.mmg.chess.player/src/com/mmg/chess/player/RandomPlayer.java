package com.mmg.chess.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mmg.chess.core.model.Board;
import com.mmg.chess.core.model.ChessMove;
import com.mmg.chess.core.model.Side;
import com.mmg.chess.core.model.Square;
import com.mmg.chess.core.model.piece.Piece;

public class RandomPlayer extends ChessPlayer {

    private Random random;

    public RandomPlayer(Board board, Side side) {
        super(board, side);
        random = new Random();
    }

    @Override
    public ChessMove decideMove() {
        List<Piece> pieces = board.getArmy(side).getAlivePieces();
        List<Square> legalMoves = new ArrayList<Square>();
        Piece randomPiece;
        do {
            int randomPieceIndex = random.nextInt(pieces.size());
            randomPiece = pieces.get(randomPieceIndex);
            legalMoves = randomPiece.computeLegalMoves();
        } while (legalMoves.size() == 0);
        
        int randomMoveIndex = random.nextInt(legalMoves.size());
        Square targetSquare = legalMoves.get(randomMoveIndex);
        return new ChessMove(randomPiece.getSquare(), targetSquare, targetSquare.getPiece());
    }

    @Override
    public String toString() {
        return "RANDOM_PLAYER";
    }

    
    
}
