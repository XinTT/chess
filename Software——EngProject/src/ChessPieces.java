import java.util.Iterator;
import java.util.LinkedList;

public class ChessPieces {
	public LinkedList<Chess> chessPieces = null;
//	ChessPieces s;
	
	public ChessPieces() {
		chessPieces = new LinkedList<Chess>();
	}
	
	public ChessPieces(int pawn1x , int pawn1y , int pawn2x , int pawn2y
			,int pawn3x , int pawn3y , int pawn4x , int pawn4y
			,int pawn5x , int pawn5y , int pawn6x , int pawn6y
			,int pawn7x , int pawn7y , int pawn8x , int pawn8y
			,int rock1x , int rock1y , int rock2x , int rock2y
			,int knight1x , int knight1y , int knight2x , int knight2y
			,int bishop1x , int bishop1y , int bishop2x , int bishop2y
			,int kingx , int kingy , int queenx , int queeny
			,Constant side) {
		chessPieces = new LinkedList<Chess>();
		chessPieces.add(new Pawn(pawn1x , pawn1y));
		chessPieces.add(new Pawn(pawn2x , pawn2y));
		chessPieces.add(new Pawn(pawn3x , pawn3y));
		chessPieces.add(new Pawn(pawn4x , pawn4y));
		chessPieces.add(new Pawn(pawn5x , pawn5y));
		chessPieces.add(new Pawn(pawn6x , pawn6y));
		chessPieces.add(new Pawn(pawn7x , pawn7y));
		chessPieces.add(new Pawn(pawn8x , pawn8y));
		
		chessPieces.add(new Rock(rock1x , rock1y));
		chessPieces.add(new Rock(rock2x , rock2y));
		
		chessPieces.add(new Knight(knight1x , knight1y));
		chessPieces.add(new Knight(knight2x , knight2y));
		
		chessPieces.add(new Bishop(bishop1x , bishop1y));
		chessPieces.add(new Bishop(bishop2x , bishop2y));
		
		chessPieces.add(new King(kingx , kingy));
		
		chessPieces.add(new Queen(queenx , queeny));
		
		Iterator<Chess> iterator = chessPieces.iterator();
		while(iterator.hasNext()) {
			iterator.next().inputSide(side);
		}


	}
	
//	public void chooseSide(ChessPieces side) {
//		Iterator<Chess> iterator = chessPieces.iterator();
//		while(iterator.hasNext()) {
//		iterator.next().inputSide(side);
//		}
//	}
	
	public  Iterator<Chess> getIterator() {
		if(chessPieces == null) {
			return null;
		}
		return chessPieces.iterator();
	}
	
	public ChessPieces clone() {
		ChessPieces re = new ChessPieces();
		Iterator<Chess> iterator = chessPieces.iterator();
		while(iterator.hasNext()) {
			re.chessPieces.add(iterator.next().clone());
		}
//		re.chessPieces = (LinkedList<Chess>)chessPieces.clone();
		
		return re;
	}

	
}
