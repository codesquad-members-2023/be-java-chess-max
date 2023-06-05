package com.chessgame.app.chess.piece;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.chessgame.app.chess.piece.type.PieceColor;
import com.chessgame.app.chess.piece.type.PieceSymbol;

class PawnTest {

	Pawn whitePawn;
	Pawn balckPawn;
	Pawn pawn;

	@BeforeEach
	void beforEach() {
		whitePawn = new Pawn(PieceColor.WHITE);
		balckPawn = new Pawn(PieceColor.BLACK);
		pawn = new Pawn();
	}

	@DisplayName("원하는 색의 Pawn을 생성할 수 있다.")
	@Test
	void create() {
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(whitePawn.verifyColor(PieceColor.WHITE)).isTrue();
		softAssertions.assertThat(balckPawn.verifyColor(PieceColor.BLACK)).isTrue();
		softAssertions.assertAll();
	}

	@DisplayName("Pawn 생성시 색을 지정하지 않으면 흰색 Pawn이 생성된다")
	@Test
	void create_default_constructor() {
		assertThat(pawn.verifyColor(PieceColor.WHITE)).isTrue();
	}

	@DisplayName("Pawn 생성시 symbol이 자동으로 결정된다.")
	@Test
	void determine_symbol() {SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(whitePawn.getMark()).isEqualTo(PieceSymbol.WHITE_PAWN.getMark());
		softAssertions.assertThat(balckPawn.getMark()).isEqualTo(PieceSymbol.BLACK_PAWN.getMark());
		softAssertions.assertAll();
	}

}
