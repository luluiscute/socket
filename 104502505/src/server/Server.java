package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
	private BufferedReader theInputStream;  // Ū���Ȥ�ݸ�ƪ��w�İ�
    private PrintStream theOutputStream;    // �N��ƥ�X���Ȥ�ݪ�����
    public static final int LISTEN_PORT = 5987;
    static Socket dsocket;
    serverframe sf;
    String times;
    public void listenRequest(serverframe s) throws IOException
    {
        sf=s;
		new RequestThread().run();
		
    }
    
    public void deliver(int x,int y) throws IOException{
    	String data=x+","+y;
    //	 theInputStream = new BufferedReader(
      //           new InputStreamReader(dsocket.getInputStream()));
             // �إ߸�ƥ�X����
             theOutputStream = new PrintStream(dsocket.getOutputStream());
             theOutputStream.println(data);
    }
    class RequestThread implements Runnable 
    {
        @Override
        public void run()
        {
        	ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket( LISTEN_PORT );
                dsocket=serverSocket.accept();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            System.out.println("Server listening requests...");
            System.out.printf("���s�u�i��!\n");
            sf.setFocusable(true);
        }
    }
}