import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	public final static int SCREEN_WIDE=800;
	public final static int SCREEN_HEIGHT=800;
	public static ChessPieces black;
	public static ChessPieces white;
	public static JFrame window;
	
	public static void main(String[] args) {
		window = new JFrame ( ) ;
		
		black = new ChessPieces(Constant.A , Constant.P7 , Constant.B , Constant.P7
				,Constant.C , Constant.P7 , Constant.D , Constant.P7
				,Constant.E , Constant.P7 , Constant.F , Constant.P7
				,Constant.G , Constant.P7 , Constant.H , Constant.P7
				,Constant.A , Constant.P8 , Constant.H , Constant.P8
				,Constant.B , Constant.P8 , Constant.G , Constant.P8
				,Constant.C , Constant.P8 , Constant.F , Constant.P8
				,Constant.E , Constant.P8 , Constant.D , Constant.P8
				,Constant.BLACK);
		white = new ChessPieces(Constant.A , Constant.P2 , Constant.B , Constant.P2
				,Constant.C , Constant.P2 , Constant.D , Constant.P2
				,Constant.E , Constant.P2 , Constant.F , Constant.P2
				,Constant.G , Constant.P2 , Constant.H , Constant.P2
				,Constant.A , Constant.P1 , Constant.H , Constant.P1
				,Constant.B , Constant.P1 , Constant.G , Constant.P1
				,Constant.C , Constant.P1 , Constant.F , Constant.P1
				,Constant.E , Constant.P1 , Constant.D , Constant.P1
				,Constant.WHITE);
		Picture pic = new Picture( black , white );
		State state = new State(black , white);

		

		
		
		window.setBackground(Color.blue);
		window.setSize(SCREEN_WIDE,SCREEN_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(pic);
		window.setVisible(true);
		SelectionListener cl = new SelectionListener(pic , black , white);
		MoveListener al = new MoveListener(pic , black , white);
		window.addMouseListener(cl);
		window.addMouseListener(al);
		
		
		JPanel jp1 = new JPanel();
		jp1.setSize(SCREEN_WIDE , Constant.EDGE);
//		JPanel jp2 = new JPanel();
//		JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,jp1,jp2);
//		jSplitPane.setDividerLocation(Constant.EDGE);
//		jp2.add(pic);
//		jp2.setVisible(true);
//		jp.setSize(SCREEN_WIDE, Constant.EDGE);
		JButton jb = new JButton("Undo");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("...");
				state.recall(pic , al , cl);
			}
		});
		jp1.setLayout(null);
		jp1.add(jb);
		jb.setBounds( 350, 20, 80, 40 );

		
//		jp1.add(jb);
//		window.add(jb);
//		jSplitPane.setOneTouchExpandable(false);
//		jSplitPane.setDividerSize(2);
//		jSplitPane.setEnabled(false); 
//		window.add(jSplitPane);
		window.add(jp1);
//		jp1.add(jb , new FlowLayout());
//		jp.add(jb , BorderLayout.CENTER);
	}
	
	public static void dispose() {
		window.dispose();
	}
	
	
	
}
