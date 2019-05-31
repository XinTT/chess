import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class State {

	static LinkedList<ChessPieces> blackHistory; 
	static LinkedList<ChessPieces> whiteHistory;
	
	public State(ChessPieces b , ChessPieces w) {
		blackHistory = new LinkedList<ChessPieces>();
		whiteHistory = new LinkedList<ChessPieces>();
//		blackHistory.add(b.clone());
//		whiteHistory.add(w.clone());
	}
	
	public static void remember( ChessPieces b , ChessPieces w ) {
		blackHistory.add(b.clone());
		whiteHistory.add(w.clone());
	}
	
	public static void recall(Picture pic , MoveListener movl , SelectionListener sel) {
		ChessPieces black = null;
		ChessPieces white = null;
		try {
			black = blackHistory.removeLast();
			white = whiteHistory.removeLast();
		}catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(null, "Can not remove any more.");
			return ;
		}
		
		//try catch()
		
		if(SelectionListener.checkInTurn == Constant.BLACK) {//移到里面来了
			SelectionListener.checkInTurn = Constant.WHITE;
		}else if(SelectionListener.checkInTurn == Constant.WHITE){
//			System.out.println("...");
			SelectionListener.checkInTurn = Constant.BLACK;
		}
		
		
//		Window.black = black;
//		Window.white = white;
		movl.refreshPara(black, white);
		sel.refreshPara(black, white);
		pic.refreshPara(black, white);
		pic.repaint();
//		System.out.println("...");
	}
	
}
