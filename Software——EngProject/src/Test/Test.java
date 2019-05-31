package Test;

import java.util.LinkedList;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Chess chess = null;
//		chess = new Chess(1 , chess);
//		System.out.println(EnumTest.SPRING.name);
//		System.out.println(EnumTest.SPRING.startMonth);
//		System.out.println(EnumTest.SPRING.endMonth);
//		
//		int x = 123;
//		System.out.println( ( (int)x/100 ) * 100 );
		LinkedList<String> l = new LinkedList<String>();
		l.add("1");
		l.add("2");
		LinkedList<String> l2 = (LinkedList<String>)l.clone();
//		Stack<Integer> l1 = (Stack)l.clone();
//		l1.add(1);
//		l1.add(2);
		System.out.println(l);
		String last = l.removeLast() ;
		last = "3";
		System.out.println(last);
		System.out.println(l);
		System.out.println(l2);
//		LinkedBlockingQueue<Integer> l2 = (LinkedBlockingQueue<Integer>)l1.clone();
//		System.out.println(l1);
//		System.out.println(l2);
//		System.out.println();
//		l2.add(2);
//		System.out.println(l1);
//		System.out.println(l2);
//		System.out.println(l2.remove());
//		System.out.println(l2.remove());
//		System.out.println(l2.remove());
	}

}
