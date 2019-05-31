import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Bishop extends Chess {
	
	public Bishop(int x1 ,int y1) {
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
		if( Math.abs(x1 - x) == Math.abs(y1- y) && Math.abs(y1 - y) !=0 &&Math.abs(x1-x)!=0  ) {
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
				if(barrier(current.x, current.y, x1, y1)) {
					return false;
				}
				if( current.x == x1 ) {
					if(current.y == y1) {
						eat( current , iterator );//��������
						return false;
					}
				}
			}
			
//			System.out.println("...");
			iterator = oppositeSide.getIterator();
			while( iterator.hasNext() ) {
				current = iterator.next();
				if(barrier(current.x, current.y, x1, y1)) {
					return false;
				}
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
	
	private boolean barrier(int barrierX , int barrierY ,int x1 , int y1) {
		if( (Math.abs(barrierX - x) == Math.abs(barrierY - y)) && ( 
				( (barrierY<y1 && y < barrierY) && (barrierX<x1 && x < barrierX) ) ||
				((y>barrierY && y1 < barrierY) && (barrierX>x1 && x > barrierX)) ||
				((y>barrierY && y1 < barrierY) && (barrierX<x1 && x < barrierX)) || 
				( (barrierY<y1 && y < barrierY) &&  (barrierX<x1 && x < barrierX) )	)
				) {
			return true;
		}
		
//		if( ( barrierX == x1 && barrierY < y1 && barrierY > y ) || 
//			( barrierX == x1 && barrierY > y1 && barrierY < y ) ||
//			( barrierY == y1 && barrierX < x1 && barrierX > x ) ||
//			( barrierY == y1 && barrierX > x1 && barrierX < x )) {
//			return true;
//		}
		return false;
	}
//	private boolean barrier(int barrierX, int barrierY ,int x1, int y1) {
//		if((x1-x>0&&y1-y>0&&x < barrierX && barrierX < x1&& y < barrierY && barrierY < y1)||(x1-x>0&&y1-y<0&&x<barrierX&& barrierX<x1&&y>barrierY&&barrierY>y1)
//		||(x1-x<0&&y1-y>0&&x>barrierX&&barrierX>x1&&y<barrierY&&barrierY<y1)||(x1-x<0&&y1-y<0&&x>barrierX&& barrierX>x1&&y>barrierY&&barrierY>y1)) {
//			return true;
//		}
//		else  {
//			return false;
//			}
//		}
	
	public void draw(Graphics g) {
		Image imagew=new ImageIcon("images/4.jpg").getImage();
		Image imageb=new ImageIcon("images/6.jpg").getImage();
		if( side == Constant.WHITE ) {
			//g.setColor( Color.RED );
			g.drawImage(imagew,x+2, y+2,75,75,null);
		}else {
			g.drawImage(imageb, x+2, y+2, 75,75,null);
		}
//		g.drawRect(x , y , 30, 30);
	}

	
	public Chess clone() {
		Bishop re = new Bishop(x , y);
		re.inputSide(side);
		return re;
	}
}