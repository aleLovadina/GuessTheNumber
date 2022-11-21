import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int n=(int)(Math.random()*100);
	public static boolean at=false;
	public static String nameWin="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Server is waiting for clients to connect...");
			ServerSocket server=new ServerSocket(7717);
				for (;;){
					Socket client;
					client=server.accept();
					ServerThread serverThread=new ServerThread(client);
					serverThread.start();
				}
		}
		catch (Exception e){}
	}
}