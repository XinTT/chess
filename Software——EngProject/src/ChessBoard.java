import java.awt.Graphics;

public class ChessBoard {
	public void draw(Graphics g) {
		g.drawLine(Constant.A,Constant.P1 + Constant.WIDTH,Constant.A,Constant.P8);
		g.drawLine(Constant.B,Constant.P1 + Constant.WIDTH,Constant.B,Constant.P8);
		g.drawLine(Constant.C,Constant.P1 + Constant.WIDTH,Constant.C,Constant.P8);
		g.drawLine(Constant.D,Constant.P1 + Constant.WIDTH,Constant.D,Constant.P8);
		g.drawLine(Constant.E,Constant.P1 + Constant.WIDTH,Constant.E,Constant.P8);
		g.drawLine(Constant.F,Constant.P1 + Constant.WIDTH,Constant.F,Constant.P8);
		g.drawLine(Constant.G,Constant.P1 + Constant.WIDTH,Constant.G,Constant.P8);
		g.drawLine(Constant.H,Constant.P1 + Constant.WIDTH,Constant.H,Constant.P8);
		g.drawLine(Constant.H + Constant.WIDTH,Constant.P1 + Constant.WIDTH,Constant.H + Constant.WIDTH,Constant.P8);
		
		
		g.drawLine(Constant.A,Constant.P1 + Constant.WIDTH,Constant.H + Constant.WIDTH,Constant.P1 + Constant.WIDTH);
		g.drawLine(Constant.A,Constant.P1,Constant.H + Constant.WIDTH,Constant.P1);
		g.drawLine(Constant.A,Constant.P2,Constant.H + Constant.WIDTH,Constant.P2);
		g.drawLine(Constant.A,Constant.P3,Constant.H + Constant.WIDTH,Constant.P3);
		g.drawLine(Constant.A,Constant.P4,Constant.H + Constant.WIDTH,Constant.P4);
		g.drawLine(Constant.A,Constant.P5,Constant.H + Constant.WIDTH,Constant.P5);
		g.drawLine(Constant.A,Constant.P6,Constant.H + Constant.WIDTH,Constant.P6);
		g.drawLine(Constant.A,Constant.P7,Constant.H + Constant.WIDTH,Constant.P7);
		g.drawLine(Constant.A,Constant.P8,Constant.H + Constant.WIDTH,Constant.P8);
	}
}
