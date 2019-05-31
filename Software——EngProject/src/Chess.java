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
	//move�Ժ�һ��Ҫ��selected���false
//	 ������˲��ܲ����ߵĵط����Ӳ���
	
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
//		����������������û�к�destination��ͬ����ģ��еĻ����Ǹ����Ӵ�����
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
