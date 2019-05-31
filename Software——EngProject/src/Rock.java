import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Rock extends Chess {
	
	public Rock(int x1 ,int y1) {
		super(x1 , y1);
		isRock = true;
		isMoved = false;
	}

	public boolean move(int x1 , int y1 , ChessPieces black , ChessPieces white) {
		x1 = Constant.EDGE + ( (int)(x1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		y1 = Constant.EDGE + ( (int)(y1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		if(Math.abs(y1 - y) == 0 || Math.abs(x1 - x) == 0) {
			ChessPieces thisSide;
			ChessPieces oppositeSide;
			Chess current;
			Iterator<Chess> iterator ;
			if( side == Constant.BLACK ) {
				thisSide = black;
				oppositeSide = white;
			}else {
				thisSide = white;
				oppositeSide = black;
			}
			iterator = thisSide.getIterator();
			while( iterator.hasNext() ) {
				current = iterator.next();
				if(barrier(current.x , current.y , x1 , y1)) {
					return false;
				}
				
				if( current.x == x1 ) {
					if(current.y == y1) {
						eat( current , iterator );
						return false;
					}
				}
			}
			iterator = oppositeSide.getIterator();
			while( iterator.hasNext() ) {
				current = iterator.next();
				if(barrier(current.x , current.y , x1 , y1)) {
					return false;
				}
				if( current.x == x1 ) {
					if(current.y == y1) {
						eat( current , iterator );
					}
				}
			}
			x = x1;
			y = y1;
			isMoved = true;
//			if(isMoved) {
//				System.out.println("moved");
//			}
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		Image imagew=new ImageIcon("images/10.jpg").getImage();
		Image imageb=new ImageIcon("images/9.jpg").getImage();
		if( side == Constant.WHITE ) {
			//g.setColor( Color.RED );
			g.drawImage(imagew,x+2, y+2,75,75,null);
		}else {
			g.drawImage(imageb, x+2, y+2, 75,75,null);
		}
//		g.drawRect(x, y, 50, 50);
		//System.out.println(x);
		//System.out.println(y);
	}
	
	public Chess clone() {
		Rock re = new Rock(x , y);
		re.inputSide(side);
		isMoved = false;
		return re;
	}
	
	private boolean barrier(int barrierX , int barrierY ,int x1 , int y1) {
		if( ( barrierX == x1 && barrierY < y1 && barrierY > y ) || 
			( barrierX == x1 && barrierY > y1 && barrierY < y ) ||
			( barrierY == y1 && barrierX < x1 && barrierX > x ) ||
			( barrierY == y1 && barrierX > x1 && barrierX < x )) {
			return true;
		}
		return false;
	}
}