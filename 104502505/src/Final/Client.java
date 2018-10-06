package Final;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable
{
	static Socket socket = null;
	String host;
	String x="168";
	String y="170";
	int control=0;
	private BufferedReader theInputStream;
    private PrintStream theOutputStream;
    static clientgame cg;
    static clientframe cf;
    
    public void startconnect(String x) throws IOException
    {
    	
        cf.setFocusable(true);
        cg.setFocusable(true);
        cg.requestFocusInWindow();
        cg.repaint();
        cf.setVisible(true);
        control=2;
        int port = 5987;
        host=x;
        try {
			socket = new Socket(host, 5987 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    public void deliver(){
    	try
        {
    		DataInputStream input = null;
            DataOutputStream output = null;
            input = new DataInputStream( socket.getInputStream() );
            output = new DataOutputStream( socket.getOutputStream() );
            while ( true )
            {
                System.out.println( input.readUTF() );
                break;
            }
        }
        catch ( IOException e )
        {
        }
    }
	@Override
	public void run() {
		
		try {
			theInputStream = new BufferedReader(
			        new InputStreamReader(socket.getInputStream()));
			theOutputStream = new PrintStream(socket.getOutputStream());
            String message;
            String analysis[]={"",""};
            
           
            // Åª¨ú¸ê®Æ°j°é
            while((message = theInputStream.readLine()) != null) {
                analysis=message.split(",");
                x=analysis[0];
                y=analysis[1];
                cg.repaint();
                
            }
           
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}