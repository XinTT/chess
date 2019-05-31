import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class MoveListener implements MouseListener {
	Picture pic;
	ChessPieces black;
	ChessPieces white;
	
	
	public MoveListener(Picture p , ChessPieces b , ChessPieces w) {
		pic = p;
		black = b;
		white = w;
	}
	
	public void refreshPara( ChessPieces b , ChessPieces w ) {
		black = b;
		white = w;
	}

	@Override
	public void mouseClicked(MouseEvent mE) {
		ChessPieces curBlack = black.clone();
		ChessPieces curWhite = white.clone();
//		if(black == Window.black) {
//			System.out.println(true);
//		}else {
//			System.out.println(false);
//		}
		// TODO Auto-generated method stub
		if(!SelectionListener.takeUp) {
//			System.out.println("...");
			return;
		}
//		System.out.println("...");
		
		Iterator<Chess> iterator;
		Chess current = null;
		boolean found = false;
		int clickedX = Constant.EDGE + ( (int)( mE.getX() - Constant.EDGE )/Constant.WIDTH ) * Constant.WIDTH;
		int clickedY = Constant.EDGE + ( (int)( mE.getY() - 30 - Constant.EDGE )/Constant.WIDTH ) * Constant.WIDTH;

		
		
		if(SelectionListener.checkInTurn == Constant.BLACK) {
			iterator = black.getIterator();
			while(iterator.hasNext() && !found) {
				current = iterator.next();
				if(current.selected) {
					found = true;
				}
			}
		}else if(SelectionListener.checkInTurn == Constant.WHITE){
			iterator = white.getIterator();
			while(iterator.hasNext() && !found) {
				current = iterator.next();
				if(current.selected) {
					found = true;
				}
			}
		}
		
		
		
		
		
//		if(current.getX() == mE.getX()) {
//			if(current.getY() == mE.getY()) {
//				return;
//			}
//		}
		if( (mE.getX() > Constant.A && mE.getX() < Constant.H + Constant.WIDTH) &&
				(mE.getY()-30 > Constant.P8 && mE.getY() -30 < Constant.P1 + Constant.WIDTH) ) {
			if( current.move(mE.getX() , mE.getY() - 30, black , white) ) {
				State.remember(curBlack, curWhite);
				current.release();
//				System.out.println(found);
				if(SelectionListener.checkInTurn == Constant.BLACK) {//移到里面来了
					SelectionListener.checkInTurn = Constant.WHITE;
				}else if(SelectionListener.checkInTurn == Constant.WHITE){
//					System.out.println("...");
					SelectionListener.checkInTurn = Constant.BLACK;
				}
				SelectionListener.takeUp = false;
				pic.repaint();
			}else if( current.getX() != clickedX && current.getY() != clickedY ) {
				current.release();
				SelectionListener.takeUp = false;
			}
			
		}
		
		
		
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
