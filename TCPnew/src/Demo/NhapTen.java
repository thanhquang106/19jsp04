package Demo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.ServerSocket;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NhapTen
{

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		new NhapTen();
	}

	/**
	 * Create the application.
	 */
	public NhapTen()
	{
		initialize();
		try
		{
			ServerSocket ss = new ServerSocket(1996);
			ss.close();
			frame.setTitle("Server không hoạt động !!!");
			txtServer.setEnabled(false);
			txtTen.setEnabled(false);
			btOK.setEnabled(false);
		}
		catch (Exception e)
		{
			frame.setTitle("Có thể đăng nhập vào server :D");
		}
	}

	private JFrame frame;
	private JTextField txtTen;
	private JTextField txtServer;
	JButton btOK;
	private void initialize()
	{
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.dispose();
				frame.setVisible(false);
				System.exit(0);
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 317, 129);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTn = new JLabel("Tên : ");
		lblTn.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblTn);
		
		txtTen = new JTextField();
		txtTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ee) 
			{
				if(ee.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(!txtTen.getText().equals(""))
					{
						Client c = new Client();
						c.NhapTen(txtTen.getText().trim());
						
						frame.setVisible(false);
						frame.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nhập tên vào @@");
					}
				}
			}
		});
		txtTen.setBounds(66, 8, 235, 20);
		frame.getContentPane().add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblServer = new JLabel("Server : ");
		lblServer.setBounds(10, 39, 58, 14);
		frame.getContentPane().add(lblServer);
		
		txtServer = new JTextField();
		txtServer.setText("1996");
		txtServer.setColumns(10);
		txtServer.setBounds(66, 36, 235, 20);
		frame.getContentPane().add(txtServer);
		
		btOK = new JButton("OK");
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!txtTen.getText().equals(""))
				{
					Client c = new Client();
					c.NhapTen(txtTen.getText().trim());
					
					frame.setVisible(false);
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nhập tên vào @@");
				}
			}
		});
		btOK.setBounds(112, 67, 89, 23);
		frame.getContentPane().add(btOK);
		frame.setVisible(true);
		frame.setLocation(550, 250);
	}
}
