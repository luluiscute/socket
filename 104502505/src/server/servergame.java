package server;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class servergame extends JPanel implements MouseListener ,KeyListener{
	Image image = new ImageIcon("c4.png").getImage();
	Image ground = new ImageIcon("ground.png").getImage();
	Image wall = new ImageIcon("wall.png").getImage();
	Image back = new ImageIcon("back.png").getImage();

	
	Server server;
	int x = 168;
	int y = 170;
	
	JLabel serwin;
	
	
	int map[][]={{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,0,0,1,1,0,1},
			{1,0,0,0,0,0,0,1,0,1},
			{1,1,1,1,1,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,1},
			{1,0,0,1,1,1,1,0,0,1},
			{1,0,0,0,0,0,1,1,0,1},
			{1,0,0,1,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1}};

	servergame() {
		setLayout(null);
		setBounds(0, 100, 580, 680);
		this.setFocusable(true);
		this.addMouseListener(this);
		this.addKeyListener(this);
		System.out.println("123456789");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("1");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		super.paint(g);
		for(int j=0;j<11;j++){
			for(int i=0;i<10; i++){
				switch(map[j][i]){
					case 0:
						g.drawImage(ground, i*57, j*58, this);
						break;
					case 1:
						g.drawImage(wall, i*57, j*58, this);
						break;
				
				}
			}
		}
		
		g.drawImage(image, x, y, this);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int a=(x-54)/57+1;
		int b=(y-54)/58+1;
		if (e.getKeyCode() == KeyEvent.VK_W) {
			if(y-58>0&&map[b-1][a]==0)
				y = y - 58;
			System.out.println("FFFFFUCK");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if(y+58<520&&map[b+1][a]==0)
				y = y + 58;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if(x-57>0&&map[b][a-1]==0)
				x = x - 57;	
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if(x+57<500&&map[b][a+1]==0)
				x = x + 57;
		}
		
		try {
			server.deliver(x, y);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


