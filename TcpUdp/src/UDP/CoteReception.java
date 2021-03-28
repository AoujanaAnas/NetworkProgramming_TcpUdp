package UDP;

import java.net.*;
import java.io.*;

public class CoteReception { 
    public static void main(String[] args) throws IOException, SocketException {
       int port=5003;
       InetAddress adr=null;
      
       byte[] tampon=new byte[200];
       byte[] tampon2=new byte[200];
       String message;
       String message2;
      int port1;
       
    
       DatagramSocket sock=new DatagramSocket(port);
     
       
       DatagramPacket paquet;
     
       
       int i;
      
       tampon=new byte[200];
       paquet=new DatagramPacket(tampon,tampon.length);
    
       System.out.println("En attente de Datagramme.....");
       sock.receive(paquet);
  
       message=new String(tampon);  
     
       /*if (message.equals("FIN")) break;*/
       InetAddress address = paquet.getAddress();
      
	   int portC =paquet.getPort();
      
	   System.out.println("Reçu de : Machine = "+address+" Port = "+portC);
	   
       System.out.println(message   );
       
       String msg=message;
       System.out.println("msg" );
       
      
       
      /* paquet2=new DatagramPacket(message.getBytes(),message.getBytes().length,address,portC);
      
       System.out.println("port est "+paquet2.getPort()+"mesg   "+new String(tampon2));
       sock.send(paquet2);
       System.out.println("port est "+paquet2.getPort()+"mesg   "+new String(tampon2));*/
     while(true) {
    	 tampon=new byte[200];
         paquet=new DatagramPacket(tampon,tampon.length);
      
         System.out.println("En attente de Datagramme.....");
         sock.receive(paquet);
         message=new String(tampon);  
         if (message.equals("FIN")) break;
         InetAddress address1 = paquet.getAddress();
  	     int portC1 =paquet.getPort();
  	     port1=portC1;
  	   System.out.println("Reçu de : Machine = "+address1+" Port = "+portC1);
  	   System.out.println("port 1 est "+ portC);
         System.out.println(message   );
         
         
         
         DatagramPacket paquet2=new DatagramPacket(message.getBytes(),message.getBytes().length,address,portC);
         
         System.out.println("port est "+paquet2.getPort()+"mesg   "+new String(tampon));
         sock.send(paquet2);
         
         
     
         DatagramPacket paquet3=new DatagramPacket(tampon2,tampon2.length);
      
         System.out.println("En attente de Datagramme.....");
         sock.receive(paquet3);
         message=new String(tampon2);  
         if (message.equals("FIN")) break;
         address1 = paquet3.getAddress();
  	     portC1 =paquet3.getPort(); 
  	     portC=portC1;
  	   System.out.println("Reçu de : Machine = "+address1+" Port = "+portC1);
  	   System.out.println("port 1 est "+ portC);
         System.out.println(message   );
         
         
          paquet2=new DatagramPacket(message.getBytes(),message.getBytes().length,address,port1);
         
         System.out.println("port est "+paquet2.getPort()+"mesg   "+new String(tampon));
         sock.send(paquet2);
	 
     }

     System.out.println("Fermer...");
     sock.close();
    }
}
