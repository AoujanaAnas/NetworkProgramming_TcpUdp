package UDP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Client1 extends JFrame {

	private JPanel contentPane;
	private JTextField msg;
	  int port=5003; // Le port UDP de destination
	 InetAddress adr=null;
     DatagramSocket sock=null;
     String message="";
     byte [] tampon;  
     
     byte[] tampon2=new byte[200];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SocketException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client1 frame = new Client1();
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
	public Client1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(15, 67, 814, 370);
		contentPane.add(panel);
		panel.setLayout(null);
		
		msg = new JTextField();
		msg.setBounds(34, 34, 477, 55);
		panel.add(msg);
		msg.setColumns(10);
		
	
		
		JTextArea msg_A = new JTextArea();
		msg_A.setBounds(34, 119, 477, 235);
		panel.add(msg_A);
		
		JButton envoi = new JButton("envoy\u00E9");
		envoi.setBackground(Color.CYAN);
		envoi.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		envoi.setBounds(543, 47, 115, 29);
		envoi.addActionListener(new ActionListener() {
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
				    	   
						sock=new DatagramSocket();
					
						msg_A.setText(msg_A.getText()+ "\n Vous :" +msg.getText());
						sock.send(paquet);
					    msg.setText("");
				
				       } catch (IOException e1) {}
					
					
					DatagramPacket paquet2=new DatagramPacket(tampon2,tampon2.length);
					try {
						sock.receive(paquet2);
						String message2=new String(tampon2); 
						msg_A.setText(msg_A.getText()+ "\n Client2 :" +message2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				}
				
			}
		});
		panel.add(envoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setForeground(new Color(255, 0, 0));
		panel_1.setBounds(15, 16, 814, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client 1");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(340, 0, 480, 36);
		panel_1.add(lblNewLabel);
		
	}
}
