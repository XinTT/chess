import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ChessPieces black = new ChessPieces(Constant.A , Constant.P7 , Constant.B , Constant.P7
//				,Constant.C , Constant.P7 , Constant.D , Constant.P7
//				,Constant.E , Constant.P7 , Constant.F , Constant.P7
//				,Constant.G , Constant.P7 , Constant.H , Constant.P7
//				,0 , 0 , 0 , 0
//				,Constant.B , Constant.P8 , Constant.G , Constant.P8
//				,0 , 0 , 0 , 0
//				,0 , 0 , 0 , 0
//				,Constant.BLACK);
//		ChessPieces clone = black.clone();
		
		LinkedList<Integer> b = new LinkedList<Integer>();
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(7);
		LinkedList<Integer> c = (LinkedList<Integer>)b.clone();
		
		Iterator<Integer> bi = b.iterator();
		Iterator<Integer> ci = c.iterator();
		while(bi.hasNext()) {
			
			
			System.out.println(bi.next() == ci.next());
			
		}
		
	}

}
