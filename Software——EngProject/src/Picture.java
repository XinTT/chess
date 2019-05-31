import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JComponent;

public class Picture extends JComponent{
	ChessPieces black;
	ChessPieces white;
	
	public Picture( ChessPieces b , ChessPieces w ) {
		black = b;
		white = w;
	}
	
	public ChessPieces getBlack() {
		return black;
	}
	
	public ChessPieces getWhite() {
		return white;
	}
	
	public void refreshPara( ChessPieces b , ChessPieces w ) {
		black = b;
		white = w;
	}
	
	protected void paintComponent(Graphics g) {
//		if(black == Window.black) {
//			System.out.println(true);
//		}else {
//			System.out.println(false);
//		}
		
		ChessBoard chessboard = new ChessBoard();
		chessboard.draw(g);

		Iterator<Chess> blackIterator = black.getIterator();
		Iterator<Chess> whiteIterator = white.getIterator();
		Chess current;
		while(blackIterator.hasNext()) {
			current = blackIterator.next();
//			System.out.println("x = " + current.getX());
//			System.out.println("y = " + current.getY());
//			System.out.println();
			current.draw(g);
//			if(current.selected) {
//				System.out.println("...");
//			}
		}
//		System.out.println("...");
		while(whiteIterator.hasNext()) {
			current = whiteIterator.next();
//			System.out.println("x = " + current.getX());
//			System.out.println("y = " + current.getY());
//			System.out.println();
			current.draw(g);

		}
//		System.out.println("---------------------------------------");
	}
}
