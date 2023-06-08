package com.chessgame.app.chess.piece.position;

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

	public boolean isSameRank(Rank rank) {
		return this.rank == rank;
	}

	public boolean isSamePosition(File file, Rank rank) {
		return (this.file == file) && (this.rank == rank);
	}

}
