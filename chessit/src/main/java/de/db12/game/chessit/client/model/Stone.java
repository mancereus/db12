package de.db12.game.chessit.client.model;

public class Stone {
	enum Type {bpawn,bking, bqueen, bbishop, bknight, brook,
		wpawn,wking, wqueen, wbishop, wknight, wrook}
	private final Type type;
	private int xpos; 
	private int ypos; 
	
	public Stone(Type type) {
		this.type = type;
	}
	public Type getType() {
		return type;
	}
	public void setPos(int x, int y) {
		setXpos(x);
		setYpos(y);
		
	}
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	public int getXpos() {
		return xpos;
	}
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	public int getYpos() {
		return ypos;
	}
}
