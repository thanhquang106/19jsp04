package Demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Client extends Thread
{
	Socket s = null;
	
	public Client()
	{
		
	}
	
	boolean run = true;
	public void run()
	{
		String snhan = "";
		while(run)
		{
			try
			{
				snhan = nhan();
				System.out.println(snhan);
				// ------------------------ Login Logout Server Stop ------------------------
				if(snhan.endsWith(" đã tham gia."))
				{
					String tmp = snhan.replace(" đã tham gia.", "");
					add_DanhSachOnline(tmp);
					continue;
				}
				
			    if(snhan.endsWith(" đã rời phòng."))
				{
					String tmp = snhan.replace(" đã rời phòng.", "");
					remove_DanhSachOnline(tmp);
					// Ở trên mặc định
					for (int i = 0; i < dem_DS_DangChat; i++)
					{
						if(DanhSach_DangChat[i].GetTen().equals(tmp))
						{
							DanhSach_DangChat[i].MatKetNoi();
							break;
						}
					}
					
					for (int i = 0; i < dem_DS_DangChat; i++)System.out.println(DanhSach_DangChat[i].GetTen());
					continue;
				}
			    
			    if(snhan.equals("Server Stop @@"))
				{
					txtOnline.setText("Server Stop @@");
					DisableGUI();
					for (int i = 0; i < dem_DS_DangChat; i++)DanhSach_DangChat[i].MatKetNoi();
					continue;
				}
			    
			 // ------------------------ Yêu cầu chat 1-1 ------------------------
			    //Client 1
			    //gui("K24.GetPort"+cbOnline.getSelectedItem());
			    if(snhan.endsWith("K24.GetPort"))
				{
					String tmp = snhan.replace("K24.GetPort", "");
					
					temp_port = myint(tmp);
					
					gui("K24.ChatWith"+temp_port);
					continue;
				}
			    
			    if(snhan.endsWith("K24.ChatStart"))
				{
					String tmp = snhan.replace("K24.ChatStart", "");
					char[] ctemp = tmp.toCharArray();
					String sten = "",sport = "";
					for (int i = 0; i < ctemp.length; i++)
					{
						if(ctemp[i] != '|')sten += ctemp[i];
						else
						{
							sport = tmp.replace((sten+"|"),"");
							break;
						}
					}
					//
					add_DanhSach_DangChat(sten, myint(sport));
					OpenGuiChatWithClient(myint(sport));
					continue;
				}
			    //Client 2
			    if(snhan.endsWith("K24.Chat?"))
				{
					String tmp = snhan.replace("K24.Chat?", "");
					char[] ctemp = tmp.toCharArray();
					String sten = "",sport = "";
					for (int i = 0; i < ctemp.length; i++)
					{
						if(ctemp[i] != '|')sten += ctemp[i];
						else
						{
							sport = tmp.replace((sten+"|"),"");
							break;
						}
					}
					//
					add_DanhSach_DangChat(sten, myint(sport));
					//
					gui("K24.Chatdi"+sport);
					continue;
				}
			 // ------------------------ Chat 1-1 ------------------------
			    if(snhan.endsWith("K24.Chat11"))
				{
					String tmp = snhan.replace("K24.Chat11", "");
					char[] ctemp = tmp.toCharArray();
					String sport = "",noidung = "";
					for (int i = 0; i < ctemp.length; i++)
					{
						if(ctemp[i] != '|')sport += ctemp[i];
						else
						{
							noidung = tmp.replace((sport+"|"),"");
							break;
						}
					}
					//
					//add_DanhSach_DangChat(sten, myint(sport));
					//
					
					int iport= myint(sport);
					for (int i = 0; i < dem_DS_DangChat; i++)
					{
						if (DanhSach_DangChat[i].GetPort() == iport)
						{
							DanhSach_DangChat[i].ON();
							DanhSach_DangChat[i].HienThi_txtALL(noidung);
						}
					}
					continue;
				}
			    
			}
			catch (Exception e)
			{
				System.err.println("while(true)_"+ten);
				CloseThread();
			}
		}
		/*
		if(snhan.endsWith(""))
		{
			String tmp = snhan.replace("", "");
			
			continue;
		}
		*/
	}
	
	// Tên port this
	String ten = "";
	int port = -1,temp_port = -1;
	
	void NhapTen(String Ten)
	{
		ten = Ten;
		StartClient();
	}
	
	void StartClient()
	{
		try
		{
			GUI_Client();
			s = new Socket("localhost",1996);
			//
			
			gui("CheckADD");
			if(nhan().equals("ADD"))
			{
				gui("K24.Login"+ten);//Gửi tên 
				port = myint(nhan());//nhận port
				lbSHOW.setText("Tên : "+ten);
				
				gui("K24.Get_DS_Online");//abc|efg|
				String ds = nhan();
				char[] cds = ds.toCharArray();
				String[] sds = new String[10];int demsds = 0;for(int i = 0;i<10;i++)sds[i] = new String();
				for (int i = 0; i < cds.length; i++)
				{
					if(cds[i] != '|')sds[demsds] += cds[i];
					else demsds++;
				}
				for (int i = 0; i < demsds; i++)add_DanhSachOnline(sds[i]);
			}
			else
			{
				HienThi_txtOnline("Server quá tải, \nvui lòng đăng nhập lại sau.");
				lbSHOW.setText("Server quá tải, vui lòng đăng nhập lại sau.");
			}
			
			//
			this.start();
		}
		catch (Exception e)
		{
			System.err.println("Client()");
			txtOnline.setText("Server không hoạt động");
			lbSHOW.setText("Server không hoạt động");
			DisableGUI();
		}
	}
	
	// Gửi và nhận
	public void gui(String nd)
	{
		try
		{
			BufferedWriter gui = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			gui.write(nd);
			gui.newLine();// Kết thúc dòng
			gui.flush();// Đẩy dữ liệu đi
		}
		catch (Exception e)
		{
			System.err.println("gui()");
			CloseThread();
		}
	}
	
	public String nhan()
	{
		String sn = "null";
		try
		{
			BufferedReader nhan = new BufferedReader(new InputStreamReader(s.getInputStream()));
			sn = nhan.readLine();
		}
		catch (Exception e)
		{
			
			System.err.println("nhan()");
			CloseThread();
		}
		return sn;
	}
	
	@SuppressWarnings("deprecation")
	void CloseThread()
	{
		run = false;
		this.stop();
	}
	
	//-------------------------------------------Danh sach online-------------------------------------------
	String[] DanhSachOnline = new String[10];int dem_online = 0;
	void add_DanhSachOnline(String Ten)
	{
		DanhSachOnline[dem_online] = Ten;
		dem_online++;
		
		//Tên của bạn
		for (int i = 0; i < dem_online; i++)
		{
			if(DanhSachOnline[i].equals(ten))DanhSachOnline[i] = ten+" (bạn)";
		}
		
		ReLoad_DS_Online();
	}
	
	void remove_DanhSachOnline(String Ten)
	{
		for (int i = 0; i < dem_online; i++)
		{
			if(DanhSachOnline[i].equals(Ten))
			{
				for (int j = i; j < (dem_online-1); j++)
				{
					DanhSachOnline[j] = DanhSachOnline[j+1];
				}
				dem_online--;
				for (int j = dem_online; j < 10; j++)
				{
					DanhSachOnline[j] = "";
				}
				break;
			}
		}
		
		ReLoad_DS_Online();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	void ReLoad_DS_Online()
	{
		// txt Online
		txtOnline.setText(null);
		for (int i = 0; i < dem_online; i++)HienThi_txtOnline(DanhSachOnline[i]);
		// Combobox
		cbOnline.setModel(new DefaultComboBoxModel(DanhSachOnline));
	}
	//-------------------------------------------Danh sach Chat Client-------------------------------------------
	DanhSach_Chat[] DanhSach_DangChat = new DanhSach_Chat[10];int dem_DS_DangChat = 0;
	
	void add_DanhSach_DangChat(String Ten,int Port)
	{
		//
		for (int i = 0; i < dem_DS_DangChat; i++)
		{
			if(DanhSach_DangChat[i].GetPort() == Port)return;
		}
		
		DanhSach_DangChat[dem_DS_DangChat] = new DanhSach_Chat(Ten, Port, this);
		dem_DS_DangChat++;
		//
	}
	
	void remove_DanhSach_DangChat(int Port)
	{
		for (int i = 0; i < dem_DS_DangChat; i++)
		{
			if(DanhSach_DangChat[i].GetPort() == Port)
			{
				for (int j = i; j < (dem_DS_DangChat-1); j++)
				{
					DanhSach_DangChat[j] = DanhSach_DangChat[j+1];
				}
				dem_DS_DangChat--;
				break;
			}
		}
	}
	
	public String GetTenClient()
	{
		return ten;
	}
	
	
	void OpenGuiChatWithClient(int Port)
	{
		for (int i = 0; i < dem_DS_DangChat; i++)
		{
			if(DanhSach_DangChat[i].GetPort() == Port)DanhSach_DangChat[i].ON();
		}
	}
	
	public static void main(String[] args)
	{
		new Client();
	}
	
	//-------------------------------------------Gui Client-------------------------------------------
	JTextArea txtOnline;
	@SuppressWarnings("rawtypes")
	JComboBox cbOnline;
	JFrame frame;
	JLabel lbSHOW;
	JButton btChat;
	@SuppressWarnings({ "rawtypes" })
	private void GUI_Client()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 220, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 194, 412);
		frame.getContentPane().add(scrollPane);
		
		txtOnline = new JTextArea();
		txtOnline.setEditable(false);
		scrollPane.setViewportView(txtOnline);
		
		cbOnline = new JComboBox();
		//cbOnline.setModel(new DefaultComboBoxModel(new String[] {"a", "b"}));
		cbOnline.setMaximumRowCount(10);
		cbOnline.setBackground(Color.WHITE);
		cbOnline.setForeground(Color.BLACK);
		cbOnline.setBounds(10, 459, 194, 20);
		frame.getContentPane().add(cbOnline);
		
		btChat = new JButton("Chat");
		btChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//JOptionPane.showMessageDialog(null, cbOnline.getSelectedItem());
				if(cbOnline.getSelectedItem().equals(ten+" (bạn)"))
				{
					JOptionPane.showMessageDialog(null, "Thích tự kỷ à =))");
				}
				else
				{
					gui("K24.GetPort"+cbOnline.getSelectedItem());
				}
			}
		});
		btChat.setBounds(10, 490, 194, 23);
		frame.getContentPane().add(btChat);
		
		lbSHOW = new JLabel("Đợi tí...");
		lbSHOW.setBounds(10, 11, 184, 14);
		frame.getContentPane().add(lbSHOW);
		frame.setVisible(true);
		frame.setLocation(1000, 60);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void DisableGUI()
	{
		cbOnline.setModel(new DefaultComboBoxModel(new String[] {"Disable"}));
		cbOnline.setEnabled(false);
		
		btChat.setEnabled(false);
	}
	
	public void HienThi_txtOnline(String nd)
	{
		txtOnline.append(nd+"\n");
	}
	
	public int myint(String in)
	{
		return Integer.parseInt(in);
	}
	
	public String myString(int in)
	{
		return String.valueOf(in);
	}
}
//------------------------------------------- Chat Client -------------------------------------------

class DanhSach_Chat extends Thread
{
	String Ten = "null";
	int Port = -1;
	Client c = null;
	boolean OpenGui = false;
	
	public DanhSach_Chat(String Ten,int Port,Client c)
	{
		this.Ten = Ten;
		this.Port = Port;
		this.c = c;
		
		GUI_DanhSach_Chat();
	}
	
	public int GetPort()
	{
		return Port;
	}
	
	public String GetTen()
	{
		return Ten;
	}
	
	
	//------------------------------------------- GUI Chat Client -------------------------------------------
	JFrame frame2;
	JTextArea txtALL,txtChat;
	private void GUI_DanhSach_Chat()
	{
		frame2 = new JFrame();
		frame2.setResizable(false);
		frame2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				
			}
		});
		frame2.setBounds(100, 100, 450, 316);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 204);
		frame2.getContentPane().add(scrollPane);
		
		txtALL = new JTextArea();
		txtALL.setEditable(false);
		scrollPane.setViewportView(txtALL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 226, 424, 51);
		frame2.getContentPane().add(scrollPane_1);
		
		txtChat = new JTextArea();
		txtChat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ee) 
			{
				if(ee.getKeyCode() == KeyEvent.VK_ENTER)
				{
					txtChat.setText(txtChat.getText().trim());
					//
					c.gui(("K24.Chat11"+Port+"|"+txtChat.getText().trim()));
					HienThi_txtALL("Bạn : "+txtChat.getText().trim());
					//
					txtChat.setText("");
				}
			}
		});
		scrollPane_1.setViewportView(txtChat);
		OFF();
		frame2.setLocation(100, 100);
		//frame2.setTitle(c.ten+" (bạn) đang chat với "+Ten+"_"+Port);
		frame2.setTitle(c.ten+" (bạn) đang chat với "+Ten);
		Random rd = new Random();
		frame2.setLocation(rd.nextInt(800), 100);
	}
	
	public void MatKetNoi()
	{
		txtALL.append("\n Mất kết nối \n");
		txtALL.setEnabled(false);
		txtChat.setText("Disable");
		txtChat.setEnabled(false);
		//Remove
		JOptionPane.showMessageDialog(null, "Mất kết nối với "+Ten);
		c.remove_DanhSach_DangChat(Port);
		c = null;
		Ten = null;
		Port = -1;
		frame2.dispose();
		OFF();
	}
	
	public void HienThi_txtALL(String nd)
	{
		txtALL.append(nd+"\n");
	}
	
	public boolean GetOpenGui()
	{
		return OpenGui;
	}
	
	public void ON()
	{
		OpenGui = true;
		frame2.setVisible(OpenGui);
	}
	
	public void OFF()
	{
		OpenGui = false;
		frame2.setVisible(OpenGui);
	}
}

























