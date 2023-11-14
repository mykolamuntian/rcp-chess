package com.mmg.chess.app.listener;

import java.util.Iterator;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Label;

import com.mmg.chess.app.parts.ChessBoardPart;
import com.mmg.chess.app.parts.PartRefresher;
import com.mmg.chess.core.model.Board;
import com.mmg.chess.core.model.Side;
import com.mmg.chess.core.model.Square;
import com.mmg.chess.core.model.piece.Piece;

public class ChessMoveListener implements MouseListener {
    
    private Label label;
    private static Piece selectedPiece;
    private static boolean doubleClicked;

    public ChessMoveListener(Label label) {
        this.label = label;
    }

    @Override
    public void mouseDoubleClick(MouseEvent e) {
        resetLegalSquares();
        Piece piece = ((Square)label.getData()).getPiece();
        if (piece != null && piece.getSide() == Side.WHITE) {
            for(Square square : piece.computeLegalMoves()) {
                square.setLegal(true);
            }
        }
        selectedPiece = piece;
        doubleClicked = true;
    }

    @Override
    public void mouseDown(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseUp(MouseEvent e) {
        PartRefresher.refresh();
        
    }
    
    private void resetLegalSquares() {
        for (int r = 0; r < Board.LENGTH; r++) {
            for(int c = 0; c < Board.LENGTH; c++) {
                ChessBoardPart.getChessRoom().getBoard().getSquare(r, c).setLegal(false);
            }
        }
    }

}
