import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class SelectionListener implements MouseListener {
	Picture pic;
	ChessPieces black;
	ChessPieces white;
	public static Constant checkInTurn;
	public static boolean takeUp;
	
	public SelectionListener(Picture p , ChessPieces b , ChessPieces w) {
		pic = p;
		black = b;
		white = w;
		takeUp = false;
		checkInTurn = Constant.WHITE;
	}

	
	public void refreshPara( ChessPieces b , ChessPieces w ) {
		black = b;
		white = w;
	}
	@Override
	public void mouseClicked(MouseEvent mE) {
		// TODO Auto-generated method stub
		if(takeUp) {
//			System.out.println("...");
			return;
		}
//		System.out.println("...");
//		System.out.println(takeUp);
		
		Iterator<Chess> iterator;
		Chess current = null;
		boolean found = false;
		int clickedX = Constant.EDGE + ( (int)( mE.getX() - Constant.EDGE )/Constant.WIDTH ) * Constant.WIDTH;
		int clickedY = Constant.EDGE + ( (int)( mE.getY() - 30 - Constant.EDGE )/Constant.WIDTH ) * Constant.WIDTH;
//		System.out.println(mE.getX());
//		System.out.println(mE.getY());
//		System.out.println(clickedX);
//		System.out.println(clickedY);
//		System.out.println(Constant.EDGE + ( Math.floor( ( mE.getY() - Constant.EDGE )/Constant.WIDTH )) * Constant.WIDTH);
//		System.out.println("...");
		
		
		if(checkInTurn == Constant.BLACK) {
//			System.out.println("...");
			
			iterator = black.getIterator();
			while(iterator.hasNext() && !found) {
				current = iterator.next();
				if(current.getX() == clickedX) {
					if(current.getY() == clickedY) {
						found = true;
						
					}
				}
			}
		}else if(checkInTurn == Constant.WHITE) {
//			System.out.println("...");
//			System.out.println(takeUp);
			
			iterator = white.getIterator();
			while(iterator.hasNext() && !found) {
				
				current = iterator.next();
//				System.out.println(current.getX());
//				System.out.println(current.getY());
//				System.out.println();
				if(current.getX() == clickedX) {
					if(current.getY() == clickedY) {
						found = true;
//						System.out.println("found");
					}
				}
			}
		}
		
//		System.out.println(current == null);
		if(found) {
//			System.out.println("...");
			current.select();
			takeUp = true;
		}
		
//		System.out.println(current != null);
//		System.out.println(takeUp);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
