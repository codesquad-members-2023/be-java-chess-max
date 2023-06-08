package chess;

import pieces.Piece;

import java.util.ArrayList;

import static utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<Piece> blackFirstList;
    private ArrayList<Piece> whiteFirstList;
    private ArrayList<Piece> blackPawnList = new ArrayList<>();
    private ArrayList<Piece> whitePawnList = new ArrayList<>();

    public void initialize() {
        blackFirstList = createFirstList(Piece.BLACK_COLOR);
        whiteFirstList = createFirstList(Piece.WHITE_COLOR);
        for(int i=0; i<8; i++) {
            blackPawnList.add(Piece.createBlackPawn());
            whitePawnList.add(Piece.createWhitePawn());
        }
    }

    private ArrayList<Piece> createFirstList(String color) {
        ArrayList<Piece> list = new ArrayList<>();
        if(color.equals("black")) {
            list.add(Piece.createBlackRook());
            list.add(Piece.createBlackKnight());
            list.add(Piece.createBlackBishop());
            list.add(Piece.createBlackQueen());
            list.add(Piece.createBlackKing());
            list.add(Piece.createBlackBishop());
            list.add(Piece.createBlackKnight());
            list.add(Piece.createBlackRook());
        } else {
            list.add(Piece.createWhiteRook());
            list.add(Piece.createWhiteKnight());
            list.add(Piece.createWhiteBishop());
            list.add(Piece.createWhiteQueen());
            list.add(Piece.createWhiteKing());
            list.add(Piece.createWhiteBishop());
            list.add(Piece.createWhiteKnight());
            list.add(Piece.createWhiteRook());
        }
        return list;
    }

    public int pieceCount() {
        int count = 0;

        count += blackFirstList.size();
        count += whiteFirstList.size();
        count += blackPawnList.size();
        count += whitePawnList.size();

        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String emptyLine = appendNewLine("........");
        sb.append(appendNewLine(getPieceListString(blackFirstList)));
        sb.append(appendNewLine(getPieceListString(blackPawnList)));
        sb.append(emptyLine);
        sb.append(emptyLine);
        sb.append(emptyLine);
        sb.append(emptyLine);
        sb.append(appendNewLine(getPieceListString(whitePawnList)));
        sb.append(appendNewLine(getPieceListString(whiteFirstList)));
        return sb.toString();
    }

    private String getPieceListString(ArrayList<Piece> pieceList) {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : pieceList) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
}
