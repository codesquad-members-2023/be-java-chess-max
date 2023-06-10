package com.chessgame.app.chess.piece.position;

import java.util.Objects;

public class Position {
	private File file;
	private Rank rank;

	public Position(File file, Rank rank) {
		this.file = file;
		this.rank = rank;
	}

	public File getFile() {
		return file;
	}

	public Rank getRank() {
		return rank;
	}

	public int getFileValue() {
		return file.getValue();
	}

	public int getRankValue() {
		return rank.getValue();
	}

	public boolean verifyFile(File file) {
		return this.file == file;
	}

	public boolean verifyRank(Rank rank) {
		return this.rank == rank;
	}

	public boolean verifyPosition(File file, Rank rank) {
		return (this.file == file) && (this.rank == rank);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Position))
			return false;
		Position position = (Position)o;
		return file == position.file && rank == position.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, rank);
	}
}
