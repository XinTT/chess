import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;


public class King extends Chess {
	
	public King(int x1 , int y1) {
		super(x1 , y1);
		isKing = true;
		isMoved = false;
	}

	public boolean move(int x1 , int y1 , ChessPieces black , ChessPieces white) {
		x1 = Constant.EDGE + ( (int)(x1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		y1 = Constant.EDGE + ( (int)(y1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		if( (Math.abs(y1 - y) == Constant.WIDTH && Math.abs(x1 - x) == 0) || 
			(Math.abs(x1 - x) == Constant.WIDTH && Math.abs(y1 - y) == 0) || 
			(Math.abs(y1 - y) == Constant.WIDTH && Math.abs(x1 - x) == Constant.WIDTH)) {
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
		if( !isMoved && (x1 == Constant.A && y1 == Constant.P1) || (x1 == Constant.H && y1 == Constant.P1)
			||	(x1 == Constant.A && y1 == Constant.P8) || (x1 == Constant.H && y1 == Constant.P8)) {
			ChessPieces thisSide;
			ChessPieces oppositeSide;
			Chess current;
			Iterator<Chess> iterator ;
			if( side == Constant.BLACK ) {
				thisSide = black;
				oppositeSide = white;
				iterator = thisSide.getIterator();
				while(iterator.hasNext()) {
					current = iterator.next();
					if(x1 == Constant.A && y1 == Constant.P8 && current.isRock && !current.isMoved 
					&& current.x == Constant.A && !hasBetween(iterator, Constant.P8, Constant.A, Constant.E)) {
						current.x = Constant.D;
						current.y = y1;
						x = Constant.C;
						y = Constant.P8;
					}
					if(x1 == Constant.H && y1 == Constant.P8 && current.isRock && !current.isMoved 
					&& current.x == Constant.H && !hasBetween(iterator, Constant.P8, Constant.E, Constant.H)) {
						current.x = Constant.F;
						current.y = y;
						x = Constant.G;
						y = Constant.P8;
					}
				}
				isMoved = true;
				return true;
			}
			if(side == Constant.WHITE) {
				thisSide = white;
				oppositeSide = black;
				iterator = thisSide.getIterator();
				while(iterator.hasNext()) {
					current = iterator.next();
					if(x1 == Constant.A && y1 == Constant.P1 && current.isRock && !current.isMoved
					&& current.x == Constant.A && !hasBetween(iterator, Constant.P1, Constant.A, Constant.E)) {
						current.x = Constant.D;
						current.y = Constant.P1;
						x = Constant.C;
						y = Constant.P1;
					}
					if(x1 == Constant.H && y1 == Constant.P1 && current.isRock && !current.isMoved 
					&& current.x == Constant.H && !hasBetween(iterator, Constant.P1, Constant.E, Constant.H)) {
						current.x = Constant.F;
						current.y = Constant.P1;
						x = Constant.G;
						y = Constant.P1;
					}	
				}
				isMoved = true;
				return true;
			}
			isMoved = true;
		}
		//JOptionPane.showMessageDialog(null , "Can not do it");
		return false;
	}
	
	public boolean hasBetween(Iterator<Chess> iterator, int y, int x1, int x2) {
		Chess chess;
		while(iterator.hasNext()) {
			chess = iterator.next();
			if(chess.y == y && chess.x > x1 && chess.x < x2) {
				return true;
			}
		}
		return false;
	}
		
	public void draw(Graphics g) {
		
		
		Image imagew=new ImageIcon("images/5.jpg").getImage();
		Image imageb=new ImageIcon("images/3.jpg").getImage();
		if( side == Constant.WHITE ) {
			//g.setColor( Color.RED );
			g.drawImage(imagew,x+2, y+2, 75,75,null);
		}else {
			g.drawImage(imageb,x+2, y+2, 75,75,null);
		}
		//g.drawRect(x , y , 70, 70);
	}
	
	public Chess clone() {
		King re = new King(x , y);
		re.inputSide(side);
		return re;
	}
}
