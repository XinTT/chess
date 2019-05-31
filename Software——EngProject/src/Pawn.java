import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pawn extends Chess {
	
	boolean raw;
	
	public Pawn(int x1 ,int y1) {
		super(x1 , y1);
		raw = true;
	}

	
	public boolean move(int x1 , int y1 , ChessPieces black , ChessPieces white) {
		x1 = Constant.EDGE + ( (int)(x1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		y1 = Constant.EDGE + ( (int)(y1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		
//		if( raw && (Math.abs(y1 - y) == 2 * Constant.WIDTH && Math.abs(x1 - x) ==  0)) {
//			changeLocation(x1 , y1);
////			 y = y1;
////			 x = x1;
//			 return true;
//		}
		
		if( side == Constant.WHITE ) {
			ChessPieces thisSide = white;
			ChessPieces oppositeSide = black;
			Chess current;
			Iterator<Chess> iterator ;
			if(  (y1 - y == -Constant.WIDTH && x1 - x == 0) ||
					( raw && (Math.abs(y1 - y) == 2 * Constant.WIDTH && Math.abs(x1 - x) ==  0) ) ) {
				iterator = thisSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if( (current.y == y1) ||
								( current.y == y - Constant.WIDTH && y1 == y - 2 * Constant.WIDTH ) ) {
							eat( current , iterator );
							return false;
						}
					}
				}
				
				iterator = oppositeSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if((current.y == y1) ||
								( current.y == y - Constant.WIDTH && y1 == y - 2 * Constant.WIDTH )) {
							return false;
						}
					}
				}
				changeLocation(x1 , y1, black, white);
//				x = x1;
//				y = y1;
				return true;
			}
			
			if( y1 - y == -Constant.WIDTH && Math.abs(x1 - x) ==  Constant.WIDTH ) {
				iterator = oppositeSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if(current.y == y1) {
							eat( current , iterator );
							changeLocation(x1 , y1, black, white);
//							x = x1;
//							y = y1;
							return true;
						}
					}
				}
				
			}
		}
		
		if( side == Constant.BLACK ) {
			ChessPieces thisSide = black;
			ChessPieces oppositeSide = white;
			Chess current;
			Iterator<Chess> iterator ;
			if(  y1 - y == Constant.WIDTH && x1 - x == 0  ||
					( raw && (Math.abs(y1 - y) == 2 * Constant.WIDTH && Math.abs(x1 - x) ==  0) ) ) {
				iterator = thisSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if((current.y == y1) ||
								( current.y == y + Constant.WIDTH && y1 == y + 2 * Constant.WIDTH )) {
							eat( current , iterator );
							return false;
						}
					}
				}
				
				iterator = oppositeSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if((current.y == y1) ||
								( current.y == y + Constant.WIDTH && y1 == y + 2 * Constant.WIDTH )) {
							return false;
						}
					}
				}
				changeLocation(x1 , y1, black, white);
//				x = x1;
//				y = y1;
				return true;
			}
			
			if( y1 - y == Constant.WIDTH && Math.abs(x1 - x) ==  Constant.WIDTH ) {
				iterator = oppositeSide.getIterator();
				while( iterator.hasNext() ) {
					current = iterator.next();
					if( current.x == x1 ) {
						if(current.y == y1) {
							eat( current , iterator );
							changeLocation(x1 , y1, black, white);
//							x = x1;
//							y = y1;
							return true;
						}
					}
				}
				
			}
		}
		
		
		return false;
	}
	
	
	public void draw(Graphics g) {
		Image imagew=new ImageIcon("images/12.jpg").getImage();
		Image imageb=new ImageIcon("images/11.jpg").getImage();
		if( side == Constant.WHITE ) {
			//g.setColor( Color.RED );
			g.drawImage(imagew,x+2, y+2, 75,75,null);
		}else {
			g.drawImage(imageb, x+2, y+2, 75,75,null);
		}
		if( side == Constant.WHITE ) {
			g.setColor( Color.RED );
		}else {
			g.setColor(Color.BLUE);
		}
	}
	
	public void changeLocation( int x1 , int y1, ChessPieces black , ChessPieces white ) {
		if(raw) {
			raw = false;
		}

		x = x1;
		y = y1;
		String chess = null;
		Chess a ;
		if(side == Constant.WHITE) {
			
			if( y == Constant.P8 ) {
				chess = levelUp();
				
					
				
				if(chess.equals("queen")) {
					a = new Queen(x1,y1);
					a.inputSide(Constant.WHITE);
					white.chessPieces.add(a);
					Iterator<Chess> it = white.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								white.chessPieces.remove(current);
								break;
							}
						}
					}
					
				}else if(chess.equals("rook")){
					a = new Rock(x1,y1);
					a.inputSide(Constant.WHITE);
					white.chessPieces.add(a);
					Iterator<Chess> it = white.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								white.chessPieces.remove(current);
								break;
							}
						}
					}
				}else if(chess.equals("knight")) {
					a = new Knight(x1,y1);
					a.inputSide(Constant.WHITE);
					white.chessPieces.add(a);
					Iterator<Chess> it = white.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								white.chessPieces.remove(current);
								break;
							}
						}
					}
				}else if(chess.equals("bishop")) {
					a = new Bishop(x1,y1);
					a.inputSide(Constant.WHITE);
					white.chessPieces.add(a);
					Iterator<Chess> it = white.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								white.chessPieces.remove(current);
								break;
							}
						}
					}
				}
			}
		}else {
			if( y == Constant.P1 ) {
				chess = levelUp();
			
				if(chess.equals("queen")) {
					a = new Queen(x1,y1);
					a.inputSide(Constant.BLACK);
					black.chessPieces.add(a);
					Iterator<Chess> it = black.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								black.chessPieces.remove(current);
								break;
							}
						}
						
					}
				}else if(chess.equals("rook")){
					
					a = new Rock(x1,y1);
					a.inputSide(Constant.BLACK);
					black.chessPieces.add(a);
					Iterator<Chess> it = black.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								black.chessPieces.remove(current);
								break;
							}
						}
						
					}
				}else if(chess.equals("knight")) {
	
					a = new Knight(x1,y1);
					a.inputSide(Constant.BLACK);
					black.chessPieces.add(a);
					Iterator<Chess> it = black.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								black.chessPieces.remove(current);
								break;
							}
						}
						
					}
					
				}else if(chess.equals("bishop")) {
					a = new Bishop(x1,y1);
					a.inputSide(Constant.BLACK);
					black.chessPieces.add(a);
					Iterator<Chess> it = black.getIterator();
					while(it.hasNext()) {
						Chess current = it.next();
						if(current.getX()==x) {
							if(current.getY()==y) {
								black.chessPieces.remove(current);
								break;
							}
						}
						
					}

				}
			}
		}
	}
	
	public String levelUp() {
		String chess = JOptionPane . showInputDialog ( null , "Choose to levelUp(rook,knight,bishop,queen)") ; 
		return chess;
		
	}
	
	public Chess clone() {
		Pawn re = new Pawn(x , y);
		re.inputSide(side);
		re.raw = raw;
		return re;
	}
}
