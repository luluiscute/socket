package server;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class serverframe extends JFrame implements MouseListener, ActionListener{
	static servermenu m = new servermenu();
	static servergame g = new servergame();
	static servertop t = new servertop();
	
	
	Timer gofram = new Timer(15,this);

	int x = 168;
	int y = 170;

	public serverframe() {
		if(t.first == true){
			gofram.start();
			setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Socket Programming");
			setSize(580, 780);
			setVisible(true);
			System.out.println("GGGG");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
	}

	public static void main(String[] args) {
		serverframe s = new serverframe();
		System.out.println("TTTTTT");
		s.add(t);
	}
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==gofram){
			if(t.first == false){
				t.first = true;
				gofram.stop();
				serverframe s = new serverframe();
				s.add(m);
				s.add(g);
				s.m.sf = s;
				s.g.server=s.m.server;
				g.requestFocusInWindow();
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
