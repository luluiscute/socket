package Final;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class clientgame extends JPanel implements MouseListener{
	Image image = new ImageIcon("c4.png").getImage();
	Image ground = new ImageIcon("ground.png").getImage();
	Image wall = new ImageIcon("wall.png").getImage();
	Image mouse = new ImageIcon("mouse_2.png").getImage();
	Font font = new Font("OK", 1, 50);
	private BufferedReader theInputStream;  // 讀取客戶端資料的緩衝區
    private PrintStream theOutputStream;
    //Socket dsocket;
	
	int hit=0;
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
	int draw = 0;
	int mousex = 0;
	int mousey = 0;
	static Client client;
	clientgame() {
		setLayout(null);
		setBounds(0, 100, 580, 680);
		this.setFocusable(true);
		this.addMouseListener(this);
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
		g.drawImage(image,Integer.valueOf(client.x),Integer.valueOf(client.y), this);
		//if (draw == 1)
		//	g.drawImage(mouse,mousex-20,mousey-20,this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mousex = arg0.getX();
		mousey = arg0.getY();
		draw = 1;
		//System.out.println("x"+arg0.getX()+"y"+arg0.getY()+"xx"+Integer.valueOf(client.x)+"yy"+Integer.valueOf(client.y));
		if(arg0.getX()<=Integer.valueOf(client.x)+50 && arg0.getX()>=Integer.valueOf(client.x)&&arg0.getY()<=Integer.valueOf(client.y)+50 && arg0.getY()>=Integer.valueOf(client.y)){
			hit++;
			client.cf.m.scorel.setText(""+hit);
			client.cf.m.scorel.setFont(font);
			String data=Integer.toString(hit);
			System.out.println(data);
			if(Integer.valueOf(hit)>=5){
				client.cf.m.win();
			}
		//	theOutputStream.println(data);
	
             // 建立資料丟出物件
			try {
				deliver(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		repaint();
	}
	 public void deliver(String data) throws IOException{
	    	theOutputStream = new PrintStream(Client.socket.getOutputStream());
			theOutputStream.println(data);
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
