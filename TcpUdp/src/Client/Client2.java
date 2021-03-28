package Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {
		
		String str;
		try {
		
			Socket socket = new Socket(InetAddress.getLocalHost(),2020);
		        System.out.println("Demande de connexion");

			    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        PrintWriter out = new PrintWriter (new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		        Scanner sc=new Scanner(System.in);
		  	  while (true) {
			  	str = in.readLine();
			  	System.out.println("Client 1 :"+str);
			  		
		  		System.out.println("Entrer votre message :");
		  		str = sc.nextLine();
		  		out.println(str);
		  		out.flush();
		  	    if (str.equals("fin")==true ) break;
		  	  }
		  	System.out.println("Fermer...");
		        socket.close();
		}
	catch (IOException e) {
		
			e.printStackTrace();
		}
		

		
	}

}
