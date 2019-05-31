import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Knight extends Chess {
	
	public Knight(int x1 ,int y1) {
		super(x1 , y1);
	}

	public boolean move(int x1 , int y1 , ChessPieces black , ChessPieces white) {
		x1 = Constant.EDGE + ( (int)(x1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		y1 = Constant.EDGE + ( (int)(y1 - Constant.EDGE)/Constant.WIDTH ) * Constant.WIDTH;
		//����������һ�������ĵ�������������ӣ�����ȡ��������겻�ܵ��ڸ�������Ƕ���ѡ�иø����е����ӣ�
		//��������ֵ���boolean��
//		System.out.println("y1 = " + y1);
//		System.out.println("x1 = " + x1);
//		System.out.println("y = " + y);
//		System.out.println("x = " + x);
//		System.out.println(y1 - y);
//		System.out.println(x1 - x);
//		System.out.println();
		if( (Math.abs(y1 - y) == Constant.WIDTH && Math.abs(x1 - x) ==  2 * Constant.WIDTH) || 
				(Math.abs(x1 - x) == Constant.WIDTH && Math.abs(y1 - y) ==  2 * Constant.WIDTH) ) {
//			System.out.println("...");
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
						eat( current , iterator );//��������
						return false;//�������޸�
					}
				}
			}
			
//			System.out.println("...");
			iterator = oppositeSide.getIterator();
			while( iterator.hasNext() ) {
				current = iterator.next();
				if( current.x == x1 ) {
					if(current.y == y1) {
						eat( current , iterator );//��������
					}
				}
			}
			x = x1;//�������޸�
			y = y1;//�������޸�
			return true;//�������޸�
			
			
		}
//		System.out.println("...");
		return false;//�������޸�
	}
	
	public void draw(Graphics g) {
		Image imagew=new ImageIcon("images/7.jpg").getImage();
		Image imageb=new ImageIcon("images/8.jpg").getImage();
		if( side == Constant.WHITE ) {
			//g.setColor( Color.RED );
			g.drawImage(imagew,x+2, y+2,75,75,null);
		}else {
			g.drawImage(imageb, x+2, y+2, 75,75,null);
		}
		
//		g.drawRect(x , y , 30, 30);
//		System.out.println(x);
//		System.out.println(y);
	}
	
	public Chess clone() {
		Knight re = new Knight(x , y);
		re.inputSide(side);
		return re;
	}
}