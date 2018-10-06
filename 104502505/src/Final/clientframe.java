package Final;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class clientframe extends JFrame implements MouseListener, ActionListener{
	Timer gofram = new Timer(15,this);
	static clientmenu m=new clientmenu();
	static clientgame cg=new clientgame();
	static clienttop t=new clienttop();
	Image image = new ImageIcon("c4.png").getImage();
	Image ground = new ImageIcon("ground.png").getImage();
	
	static Client client;
	public clientframe() {
		if(t.first == true){
			gofram.start();
			setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Socket Programming");
			setSize(580,780);
			setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		clientframe s=new clientframe();
		s.add(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==gofram){
			if(t.first == false){
				t.first = true;
				gofram.stop();
				clientframe s=new clientframe();
				s.add(m);
				s.add(cg);
				client=m.client;
				client.cg=cg;
				cg.client=client;
				client.cf=s;
				cg.requestFocusInWindow();
				s.setVisible(true);
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
