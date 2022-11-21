import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String readServer="";
		
		try{
			System.out.println("Client started...");
			
			Socket client=new Socket("localhost",7717);
			
			DataOutputStream out=new DataOutputStream (client.getOutputStream());
			
			DataInputStream in=new DataInputStream(client.getInputStream());
		
			BufferedReader input=new BufferedReader (new InputStreamReader(System.in));
			String name="", num="";
			System.out.print("Insert your name: ");
			name=input.readLine();
			out.writeBytes(name+'\n');
			do {
				System.out.print("Insert an integer number: ");
				num=input.readLine();
				out.writeBytes(num+'\n');
				readServer =in.readLine();
				if(readServer.equals("lost")==false) {
					System.out.println(readServer);
				}else {
					break;
				}
			}while(readServer.equals("You guessed the right number!")==false);
			
			readServer =in.readLine();
			System.out.print(readServer);
			
			client.close();
		}
		catch (Exception e){
		}
	}
}
