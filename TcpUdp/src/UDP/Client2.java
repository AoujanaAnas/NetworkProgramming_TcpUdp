package UDP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Client2 extends JFrame {

	 int port=5003; // Le port UDP de destination
     InetAddress adr=null;
     DatagramSocket sock=null;
     

     String message="";
     byte [] tampon;  
     byte[] tampon2=new byte[200];
	private JPanel contentPane;
	private JTextField msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)   throws SocketException, IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client2 frame = new Client2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(15, 83, 782, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		msg = new JTextField();
		msg.setBounds(25, 46, 478, 50);
		panel.add(msg);
		msg.setColumns(10);
		
		JTextArea msg_A = new JTextArea();
		msg_A.setBounds(25, 106, 478, 259);
		panel.add(msg_A);
		
		JButton btnNewButton = new JButton("envoy\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(msg.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter msg", "Envoyé", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					try { adr=InetAddress.getByName(null);}
				       catch(UnknownHostException e1) {
				       	 System.out.println("resolution impossible");
				         System.exit(2);
				        }
					 
				       try {
				    	   message=msg.getText();
					       tampon=message.getBytes();
					       DatagramPacket paquet=new DatagramPacket(tampon,tampon.length,adr,port);
					       try {
					    	      msg_A.setText(msg_A.getText()+ "\n Vous :" +msg.getText());
						} catch (Exception e2) {
							// TODO: handle exception
						}
					 
						sock=new DatagramSocket();
					
				       try {
						sock.send(paquet);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				       } catch (SocketException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				       
				       
				       
				       
				      
				       try {
				    	   DatagramPacket paquet2=new DatagramPacket(tampon2,tampon2.length);
						sock.receive(paquet2);
						  String message2=new String(tampon2);
						  msg_A.setText(msg_A.getText()+ "\n Client1 :" +message2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(553, 57, 115, 29);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(15, 16, 782, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client 2");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Trajan Pro", Font.BOLD, 23));
		lblNewLabel.setBounds(321, 16, 312, 25);
		panel_1.add(lblNewLabel);
	}

}

