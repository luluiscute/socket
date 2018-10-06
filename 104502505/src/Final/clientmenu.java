package Final;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class clientmenu extends JPanel implements  MouseListener,MouseMotionListener,ActionListener{
	JButton bclient=new JButton("client");
	JLabel back;
	Client client=new Client();
	JLabel ip=new JLabel("ip:");
	JLabel scorel=new JLabel("");
	
	JLabel clientwin;
	JLabel clientlose;
	
	JLabel sec = new JLabel();
	Timer second = new Timer(1000,this);
	
	JTextField inputip=new JTextField (40);
	Font font = new Font("OK", 1, 50);
	boolean first = true;
	boolean lock =false;
	
	int n=20;
	clientmenu(){
		setLayout(null);
		setBounds(0,0,580,100);
		
		back = new JLabel();
		back.setIcon(new ImageIcon("back2.png"));
		back.setBounds(0,0,565,100);
		this.add(bclient);
		this.add(ip);
		this.add(inputip);
		this.add(bclient);
		this.add(back);
		scorel.setVisible(false);
		bclient.setBounds(52,64,100,30);
		ip.setBounds(204,68,20,20);
		inputip.setBounds(277,68,150,20);
		
		this.addMouseListener(this);
		
		bclient.addActionListener(new ActionListener() {  // °Î¦WÃþ§O
            public void actionPerformed(ActionEvent e) {
                try {
                	if(first = true)
                		change();
                	setFocusable(false);
					client.cg.requestFocusInWindow();
					client.startconnect(inputip.getText());
					Thread a=new Thread (client);
			        a.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
	}
	void change(){
		first = false;
		scorel.setBounds(64, 38, 70, 70);
		scorel.setVisible(true);
		scorel.setText("0");
		scorel.setFont(font);
		sec.setBounds(273, 38, 70, 70);
		sec.setVisible(true);
		sec.setText("20");
		sec.setFont(font);
		back.setIcon(new ImageIcon("back2_2.png"));
		back.add(scorel);
		back.add(sec);
		this.remove(bclient);
		this.remove(ip);
		this.remove(inputip);
		repaint();
		second.start();
	}
	void win(){
		if(lock == false){
			lock = true;
			this.removeAll();
			clientwin = new JLabel();
			clientwin.setIcon(new ImageIcon("clientwin.png"));
			clientwin.setBounds(0,0,565,100);
			this.add(clientwin);
			repaint();
			second.stop();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.print("G");
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==second){
			n=n-1;
			sec.setText(Integer.toString(n));
			repaint();
			if(n<=0){
				if(lock == false){
					lock = true;
					this.removeAll();
					clientlose = new JLabel();
					clientlose.setIcon(new ImageIcon("clientlose.png"));
					clientlose.setBounds(0,0,565,100);
					this.add(clientlose);
					repaint();
					second.stop();
				}
			}
		}
	}
}
