import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JOptionPane;

public abstract class Chess {
	int x ;
	int y;
	boolean selected;
	Constant side;
	boolean isKing;
	boolean isRock;
	boolean isMoved;
	public Chess(int x1 , int y1) {
		x = x1;
		y = y1;
		selected = false;
		isKing = false;
		isRock = false;
	}
	
	public void select() {
		selected = true;
	}
	
	public void release() {
		selected = false;
	}
	
	public abstract boolean move(int x1 , int y1 , ChessPieces black , ChessPieces white) ;
	public abstract void draw( Graphics g );
	public abstract Chess clone();
	//move以后一定要把selected变成false
//	 如果点了不能不能走的地方棋子不动
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void inputSide(Constant s) {
		side = s;
	}
	
	public Constant side() {
		return side;
	}
	
	public boolean eat(Chess chess , Iterator<Chess> ic) {
//		在所有棋子里找有没有和destination相同坐标的，有的话把那个棋子传进来
		if(side == chess.side()) {
			return false;
		}else {
			if(chess.isKing) {
				String sside;
				if(side == Constant.BLACK) {
					sside = "black";
				}else {
					sside = "white";
				}
				JOptionPane.showMessageDialog(null , "Gameover" + "\n" + sside + " won");
				
				System.exit(0);
			}
			ic.remove();
			return true;
			
		}
		
	}
	
	
	
	
}
