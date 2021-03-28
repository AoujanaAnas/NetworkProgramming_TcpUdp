package Serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {

	public static void main(String[] args) throws IOException {
			ServerSocket socketserver = new ServerSocket(2020);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
		try {
		
			Socket socket1 = socketserver.accept(); 
			Socket socket2 = socketserver.accept(); 
		        
		        try {
		        	
		        System.out.println("Les clients sont connecté");
				    BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
					BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
					String msg1,msg2;
					while (true) {
						
				    msg1 = in1.readLine();
					PrintWriter out = new PrintWriter(socket2.getOutputStream());
					out.println(msg1);
					out.flush();
					
				    msg2 = in2.readLine();
					out = new PrintWriter(socket1.getOutputStream());
					out.println(msg2);
					out.flush();
					
					if(msg1.equals("fin")==true || msg2.equals("fin") == true) break;}
		        	
		        } 
		        catch(Exception e) {}
		        
		        socket1.close();
		  		socket2.close();
		  		socketserver.close();
			            
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}

