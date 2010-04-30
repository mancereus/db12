package de.db12.game.chessit.client.model;

public class Stone {
	enum Type {bpawn,bking, bqueen, bbishop, bknight, brook,
		wpawn,wking, wqueen, wbishop, wknight, wrook}
	private final Type type;
	private Place place; 
	
	public Place getPlace() {
		return place;
	}
	public Stone(Type type) {
		this.type = type;
	}
	public Type getType() {
		return type;
	}
	void movePlace(Place newplace) {
		place.remove(this);
		this.place = newplace;
	}
}
