import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class ServerThread extends Thread {

	ServerSocket server = null;
	Socket client;

	public ServerThread(Socket socket) {
		this.client = socket;

	}

	public void run() {
		String name = "";
		int number=0;
		int i=0;
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			name = in.readLine();
			do {
				number = Integer.parseInt(in.readLine());
				if (number==Server.n && Server.at==false) {
					out.writeBytes("You guessed the right number!"+'\n');
					Server.at=true;
					Server.nameWin=name;
					i++;
					out.writeBytes("Number of tries: "+i+"; the winner is "+Server.nameWin+"! Congratulations"+'\n');
				}else {
					if(number>Server.n && Server.at==false) {
						out.writeBytes("Too big"+'\n');
						i++;
					}else {
						if(number<Server.n && Server.at==false) {
							out.writeBytes("Too small"+'\n');
							i++;
						}else {
							out.writeBytes("lost"+'\n');
							out.writeBytes("You lost :(, the winner is: "+Server.nameWin+'\n');
							i++;
							break;
						}
					}
				}
					
			} while (Server.at==false);
			client.close();
		} catch (Exception e) {
		};

	}

}
