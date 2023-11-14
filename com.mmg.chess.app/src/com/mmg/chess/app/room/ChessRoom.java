package com.mmg.chess.app.room;

import java.util.HashMap;
import java.util.Map;

import com.mmg.chess.core.model.Army;
import com.mmg.chess.core.model.Board;
import com.mmg.chess.core.model.Side;
import com.mmg.chess.core.model.piece.Bishop;
import com.mmg.chess.core.model.piece.BlackPawn;
import com.mmg.chess.core.model.piece.King;
import com.mmg.chess.core.model.piece.Knight;
import com.mmg.chess.core.model.piece.Queen;
import com.mmg.chess.core.model.piece.Rook;
import com.mmg.chess.core.model.piece.WhitePawn;
import com.mmg.chess.player.ChessPlayer;

public class ChessRoom {
    private final Board board;
    private final Map<Side, ChessPlayer> players;

    public ChessRoom() {
        Army whiteArmy = new Army();
        Army blackArmy = new Army();
        board = new Board(whiteArmy, blackArmy);
        
        for (int c = 0; c < Board.LENGTH; c++) {
            whiteArmy.addPiece(new WhitePawn(board.getSquare(1, c), Side.WHITE));
        }
        
        whiteArmy.addPiece(new Rook(board.getSquare(0, 0), Side.WHITE));
        whiteArmy.addPiece(new Rook(board.getSquare(0, 7), Side.WHITE));
        
        whiteArmy.addPiece(new Knight(board.getSquare(0, 1), Side.WHITE));
        whiteArmy.addPiece(new Knight(board.getSquare(0, 6), Side.WHITE));
        
        whiteArmy.addPiece(new Bishop(board.getSquare(0, 2), Side.WHITE));
        whiteArmy.addPiece(new Bishop(board.getSquare(0, 5), Side.WHITE));
        
        whiteArmy.addPiece(new Queen(board.getSquare(0, 3), Side.WHITE));
        whiteArmy.addPiece(new King(board.getSquare(0, 4), Side.WHITE));

        for (int c = 0; c < Board.LENGTH; c++) {
            blackArmy.addPiece(new BlackPawn(board.getSquare(6, c), Side.BLACK));
        }
        
        blackArmy.addPiece(new Rook(board.getSquare(7, 0), Side.BLACK));
        blackArmy.addPiece(new Rook(board.getSquare(7, 7), Side.BLACK));
        
        blackArmy.addPiece(new Knight(board.getSquare(7, 1), Side.BLACK));
        blackArmy.addPiece(new Knight(board.getSquare(7, 6), Side.BLACK));
        
        blackArmy.addPiece(new Bishop(board.getSquare(7, 2), Side.BLACK));
        blackArmy.addPiece(new Bishop(board.getSquare(7, 5), Side.BLACK));
        
        blackArmy.addPiece(new Queen(board.getSquare(7, 3), Side.BLACK));
        blackArmy.addPiece(new King(board.getSquare(7, 4), Side.BLACK));
        
        players = new HashMap<Side, ChessPlayer>();
        players.put(Side.WHITE, new ChessPlayer(board, Side.WHITE));
        players.put(Side.BLACK, new ChessPlayer(board, Side.BLACK));
    }

    public Board getBoard() {
        return board;
    }

    public  ChessPlayer getPlayers(Side side) {
        return players.get(side);
    }
    
    
}
