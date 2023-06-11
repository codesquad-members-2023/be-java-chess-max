package com.chessgame.app.chess.piece.utill;

import com.chessgame.app.chess.piece.position.File;
import com.chessgame.app.chess.piece.position.Position;
import com.chessgame.app.chess.piece.position.Rank;

public class PositionGenerator {

	private PositionGenerator() {}

	public static Position generate(String positionString) {
		String fileString = positionString.substring(0, 1);
		String rankString = positionString.substring(1, 2);

		File file = File.BLOCK;
		Rank rank = Rank.BLOCK;

		for(File value : File.values()) {
			 if(value.getStringValue().equals(fileString.toLowerCase())) {
				file = value;
				break;
			 }
		}

		for(Rank value : Rank.values()) {
			if(value.getStringValue().equals(rankString)) {
				rank = value;
				break;
			}
		}

		if(file == File.BLOCK || rank == Rank.BLOCK) {
			throw new IllegalArgumentException(positionString + "은 잘못된 입력값 입니다.");
		}

		return new Position(file, rank);
	}

}
