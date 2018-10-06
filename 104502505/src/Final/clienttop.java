package Final;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.*;


public class clienttop extends JPanel implements MouseListener, ActionListener {
	boolean first = true; 
	
	ImageIcon top;
	JLabel index;
	
	ImageIcon startImage;
	JLabel start;
	ImageIcon startImagePressed;
	
	ImageIcon buttomImage;
	JLabel buttom;
	ImageIcon buttomPressed;
	
	int move1 = 0;
	int move2 = 0;
	int move3 = 0;
	
	JLabel Jpicture1;
	JLabel Jpicture1_1;
	JLabel Jpicture2;
	JLabel Jpicture3;
	JLabel Jpicture3_1;
	JLabel Jpicture3_2;
	JLabel Jpicture4;
	JLabel Jpicture5;
	JLabel Jpicture6;
	JLabel Jpicture6_1;
	JLabel Jpicture7;
	JLabel Jpicture8;
	JLabel Jpicture8_1;
	JLabel Jpicture9;
	JLabel Jrule;

	boolean p1 = false;
	boolean p2 = false;
	boolean p3 = false;
	boolean p4 = false;
	boolean p5 = false;
	boolean p6 = false;
	boolean p7 = false;
	boolean p8 = false;
	boolean p9 = false;
	boolean p10 = false;
	
	
	Timer pic1 = new Timer(15,this);
	Timer pic1_1 = new Timer(15,this);
	Timer pic3_2 = new Timer(15,this);
	Timer pic6_1 = new Timer(15,this);
	Timer pic8 = new Timer(15,this);
	Timer pic8_1 = new Timer(1,this);
	
	clienttop() {
		setLayout(null);
		setBounds(0,0,580,780);
		this.setFocusable(true);
		this.addMouseListener(this);
		setIndex();
	}
	

	void setIndex(){
			
		top = new ImageIcon("top.png");
		index = new JLabel();
		index.setIcon(top);
		index.setBounds(0,0,565,760);
		
		startImage = new ImageIcon("startpressed.jpg");
		startImagePressed = new ImageIcon("start.jpg");
		start = new JLabel();
		start.setIcon(startImage);
		start.setBounds(138,489,260,92);
		start.addMouseListener(this);
		index.add(start);
		
		this.add(index);
		
	}
	
	void picture(){
		
		buttomImage = new ImageIcon("buttom.png");
		buttomPressed = new ImageIcon("buttomPressed.png");
		buttom = new JLabel();
		buttom.setIcon(buttomImage);
		buttom.setBounds(305,672,232,73);
		buttom.addMouseListener(this);
		//buttom.setVisible(false);


		Jrule = new JLabel();
		Jrule.setIcon(new ImageIcon("clientintroduce.png"));
		Jrule.setBounds(0,0,565,760);
		Jrule.add(buttom);
		this.add(Jrule);
		Jrule.setVisible(false);
		
		Jpicture9 = new JLabel();
		Jpicture9.setIcon(new ImageIcon("picture9.png"));
		Jpicture9.setBounds(0,0,565,760);
		this.add(Jpicture9);
		Jpicture9.setVisible(false);
		
		Jpicture8_1 = new JLabel();
		Jpicture8_1.setIcon(new ImageIcon("picture8_1.png"));
		Jpicture8_1.setBounds(0,0,565,760);
		this.add(Jpicture8_1);
		Jpicture8_1.setVisible(false);
		
		Jpicture8 = new JLabel();
		Jpicture8.setIcon(new ImageIcon("picture8.png"));
		Jpicture8.setBounds(0,0,565,760);
		this.add(Jpicture8);
		Jpicture8.setVisible(false);
		
		Jpicture7 = new JLabel();
		Jpicture7.setIcon(new ImageIcon("picture7.png"));
		Jpicture7.setBounds(0,0,565,760);
		this.add(Jpicture7);
		Jpicture7.setVisible(false);
		
		Jpicture6_1 = new JLabel();
		Jpicture6_1.setIcon(new ImageIcon("picture6_1.png"));
		this.add(Jpicture6_1);
		Jpicture6_1.setVisible(false);
		
		Jpicture6 = new JLabel();
		Jpicture6.setIcon(new ImageIcon("picture6.png"));
		Jpicture6.setBounds(0,0,565,760);
		this.add(Jpicture6);
		Jpicture6.setVisible(false);
		
		Jpicture5 = new JLabel();
		Jpicture5.setIcon(new ImageIcon("picture5.png"));
		Jpicture5.setBounds(0,0,565,760);
		this.add(Jpicture5);
		Jpicture5.setVisible(false);
		
		Jpicture4 = new JLabel();
		Jpicture4.setIcon(new ImageIcon("picture4.png"));
		Jpicture4.setBounds(0,0,565,760);
		this.add(Jpicture4);
		Jpicture4.setVisible(false);
		
		Jpicture3_2 = new JLabel();
		Jpicture3_2.setIcon(new ImageIcon("picture4-2.png"));
		this.add(Jpicture3_2);
		Jpicture3_2.setVisible(false);
		
		Jpicture3_1 = new JLabel();
		Jpicture3_1.setIcon(new ImageIcon("picture4-1.png"));
		Jpicture3_1.setBounds(0,0,565,760);
		this.add(Jpicture3_1);
		Jpicture3_1.setVisible(false);
		
		Jpicture3 = new JLabel();
		Jpicture3.setIcon(new ImageIcon("picture3.png"));
		Jpicture3.setBounds(0,0,565,760);
		this.add(Jpicture3);
		Jpicture3.setVisible(false);
		
		Jpicture2 = new JLabel();
		Jpicture2.setIcon(new ImageIcon("picture2.png"));
		Jpicture2.setBounds(0,0,565,760);
		this.add(Jpicture2);
		Jpicture2.setVisible(false);
		
		Jpicture1_1 = new JLabel();
		Jpicture1_1.setIcon(new ImageIcon("picture1_1.png"));
		this.add(Jpicture1_1);
		
		Jpicture1 = new JLabel();
		Jpicture1.setIcon(new ImageIcon("picture1.png"));
		Jpicture1.setBounds(0,0,565,760);
		this.add(Jpicture1);
		p1 = true;
		pic1.start();
		
	}
	
	void move(){
		Jpicture1_1.setBounds(525-move1,452,175,175);
		repaint();
	}
	void move2(){
		Jpicture3_2.setBounds(25,489-move1,175,175);
		repaint();
	}
	void move3(){
		Jpicture6_1.setBounds(402,751-move1,103,138);
		repaint();
	}
	void move4(){
		Jpicture8_1.setBounds(110+move2,424-move1,85,70);
		repaint();
	}
	void move5(){
		Jpicture8_1.setBounds(110+move2,74+move3,85,70);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == pic1){
			try{
				Thread.sleep(1000);
			}
			catch(Exception e1){
				System.out.println("Exception caught");
			}
			pic1.stop();
			if (p1 == true){
				Jpicture1_1.setVisible(true);
				pic1_1.start();
			}
			else if (p2 == true){
				Jpicture3.setVisible(true);
				p2 = false;p3 = true;
				pic1.start();
			}
			else if (p3 == true){
				Jpicture3_2.setVisible(true);
				Jpicture3_1.setVisible(true);
				p3 = false;
				pic3_2.start();
			}
			else if (p4 == true){
				Jpicture5.setVisible(true);
				p4 = false;p5 = true;
				pic1.start();
			}
			else if (p5 == true){
				Jpicture6_1.setVisible(true);
				Jpicture6.setVisible(true);
				p5 = false;
				pic6_1.start();
			}
			else if (p7 == true){
				Jpicture7.setVisible(true);
				p7 = false;p8 = true;
				pic8.start();
			}
			else if (p9 == true){
				Jpicture9.setVisible(true);
				p9 = false;p10 = true;
				pic1.start();
			}	
			else if (p10 == true){
				buttom.setVisible(true);
				Jrule.setVisible(true);
				p10 = false;
			}
		}
		if(e.getSource() == pic8){
			Jpicture8_1.setVisible(true);
			Jpicture8.setVisible(true);
			p8 = false;
			pic8.stop();
			pic8_1.start();
		}
		
		
		if(e.getSource() == pic1_1){
			move1 = move1+10;
			
			if(move1>500){
				try{
					Thread.sleep(1000);
				}
				catch(Exception e1){
					System.out.println("Exception caught");
				}
				pic1_1.stop();
				index.remove(Jpicture1_1);
				Jpicture2.setVisible(true);
				p1 = false;p2 = true;
				move1 = 0;
				pic1.start();
			}
			else
				move();
		}
		if(e.getSource() == pic3_2){
			move1 = move1+5;
			if(move1>375){
				try{
					Thread.sleep(1000);
				}
				catch(Exception e1){
					System.out.println("Exception caught");
				}
				pic3_2.stop();
				index.remove(Jpicture3_2);
				Jpicture4.setVisible(true);
				p4 = true;
				move1 = 0;
				pic1.start();
			}
			else
				move2();
		}
		if(e.getSource() == pic6_1){
			move1 = move1+10;
			
			if(move1>500){
				try{
					Thread.sleep(1000);
				}
				catch(Exception e1){
					System.out.println("Exception caught");
				}
				pic6_1.stop();
				index.remove(Jpicture6_1);
				Jpicture7.setVisible(true);
				p7 = true;
				move1 = 0;
				pic1.start();
			}
			else
				move3();
		}
		if(e.getSource() == pic8_1){
			move1 = move1+3;//y
			move2 = move2+1; //x

			if(move1>350){
				move3 = move3+4;//y
				move2 = move2+1; //x
				if(move2>208){
					try{
						Thread.sleep(1000);
					}
					catch(Exception e1){
						System.out.println("Exception caught");
					}
					pic8_1.stop();
					index.remove(Jpicture8_1);
					Jpicture9.setVisible(true);
					p9 = true;
					pic1.start();
				}
				else
					move5();
				}
			
			else
				move4();
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
		if(arg0.getSource() == start){
			start.setIcon(startImagePressed);
		}
		if(arg0.getSource() == buttom){
			buttom.setIcon(buttomPressed);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == start){
			start.setIcon(startImage);
			this.remove(index);
			picture();
		}
		
		if(arg0.getSource() == buttom){
			buttom.setIcon(buttomImage);
			//this.removeAll();
			repaint();
			first = false;
		}
	}
}
