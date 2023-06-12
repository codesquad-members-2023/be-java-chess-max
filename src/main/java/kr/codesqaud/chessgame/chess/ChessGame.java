package kr.codesqaud.chessgame.chess;

import static kr.codesqaud.chessgame.pieces.config.Type.PAWN;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Position;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;

public class ChessGame {

    // 입력받은 Color을 기준으로 Color와 같은 기물들의 점수합을 반환
    public double calculatePoint(final List<Rank> ranks, final Color color) {
        final double PAWN_SCORE = 0.5;
        double score = 0.0;
        // 폰이 아닌 다른 기물의 점수합
        score += getPieceStream(ranks, color)
            .map(Piece::getType)
            .filter(type -> !Objects.equals(type, PAWN))
            .mapToDouble(Type::getDefaultPoint)
            .sum();

        // 폰이고 수직적인 위치에 다른 폰이 없는 경우의 기물 점수합
        score += getPieceStream(ranks, color)
            .filter(piece -> Objects.equals(piece.getType(), PAWN))
            .filter(piece -> !existPawnInVeritable(ranks, piece.getPosition()))
            .map(Piece::getType)
            .mapToDouble(Type::getDefaultPoint)
            .sum();

        // 폰이고 수직적인 위치에 다른 폰이 있는 경우의 기물 점수합
        score += getPieceStream(ranks, color)
            .filter(piece -> Objects.equals(piece.getType(), PAWN))
            .filter(piece -> existPawnInVeritable(ranks, piece.getPosition()))
            .map(Piece::getType)
            .mapToDouble(value -> PAWN_SCORE)
            .sum();

        return score;
    }

    private Stream<Piece> getPieceStream(final List<Rank> ranks, final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color));
    }

    // 입력받은 Position을 기준으로 수직에 같은 색상의 다른 Pawn이 있는지 확인
    private boolean existPawnInVeritable(final List<Rank> ranks, final Position position) {
        int file = position.getFile();
        return ranks.stream()
            .filter(rank -> !rank.isMatchRank(position.getRank()))
            .map(rank -> rank.findPiece(file))
            .map(Piece::getType)
            .anyMatch(type -> Objects.equals(type, PAWN));
    }
}
