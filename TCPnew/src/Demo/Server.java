package Demo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Chat Final By K24
 * 
 * */

public class Server
{
	// ---------------------------- Server ---------------------------- 
	ServerSocket ss = null;
	Socket s = null;
	
	public Server()
	{
		try
		{
			Gui_Server();
			
			ss = new ServerSocket(1996);
			max_client = 5;
			
			frame.setTitle("I'm Server :D");
			HienThi_txtALL("Server mở tại cổng 1996 \nSố lượng client có thể vào "+max_client);
			
			while (true)
			{
				s = ss.accept();
				
				if(dem<max_client)
				{
					add(s);
				}
				else 
				{
					gui("Server đầy.");
					HienThi_txtALL("Server quá tải !!!");
				}
			}
		}
		catch (Exception e)
		{
			HienThi_txtALL("Hoa đã có chủ vui lòng chọn port khác =))"); 
		}
		
	}
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
		}
	}
	// -------------------- Quản lý port hay quản lý client --------------------
	int max_client = 10;
	DanhSach_Socket[] ds_socket = new DanhSach_Socket[max_client];int dem = 0;
	
	void add(Socket s)
	{
		for (int i = 0; i < dem; i++)
		{
			if(ds_socket[i].port == s.getPort())return;
		}
		ds_socket[dem] = new DanhSach_Socket(s,this);dem++;
	}
	
	void remove(Socket s)
	{
		for (int i = 0; i < dem; i++)
		{
			if(ds_socket[i].port == s.getPort())
			{
				for (int j = i; j < (dem-1); j++)ds_socket[j] = ds_socket[j+1];dem--;
				System.out.println("remove "+s.getPort());
				break;
			}
		}
	}
	
	int find(int port)
	{
		int f = -1;
		for (int i = 0; i < dem; i++)
		{
			if(ds_socket[i].port == port)
			{
				f = i;
				break;
			}
		}
		return f;
	}
	
	void GuiTinALL(String nd)
	{
		for (int i = 0; i < dem; i++)
		{
			ds_socket[i].gui(nd);
		}
	}
	
	void GuiTinALLNotMe(String ten,String nd)
	{
		for (int i = 0; i < dem; i++)if(!ds_socket[i].ten.equals(ten))ds_socket[i].gui(nd);
	}
	
	void Client_Gui_Client(int portnhan,String nd)
	{
		ds_socket[find(portnhan)].gui(nd);
	}
	
	int TimPort(String ten)
	{
		for (int i = 0; i < dem; i++)
		{
			if(ten.equals(ds_socket[i].ten))
			{
				return (ds_socket[i].port);
			}
		}
		
		return -1;
	}
	
	String TimTen(int port)
	{
		for (int i = 0; i < dem; i++)
		{
			if(port == ds_socket[i].port)
			{
				return (ds_socket[i].ten);
			}
		}
		
		return "null";
	}
	

	String GetOnline()
	{
		String ds = "";
		for (int i = 0; i < dem; i++)
		{
			ds += (ds_socket[i].ten+"|");//abc|efg|
		}
		
		return ds;
	}
	
	void Remove_txtOnline(String ten)
	{
		txtOnline.setText(txtOnline.getText().replace(ten+"\n", ""));
	}
	
	public static void main(String[] args)
	{
		new Server();

	}
	
	//-------------------------------------------Gui Servers-------------------------------------------
	private JFrame frame;
	JTextArea txtALL,txtOnline,txtChat;
	private void Gui_Server()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				//EXIT
				GuiTinALL("Server Stop @@");
			}
		});
		frame.setBounds(100, 100, 565, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 380);
		frame.getContentPane().add(scrollPane);
		
		txtALL = new JTextArea();
		txtALL.setEditable(false);
		scrollPane.setViewportView(txtALL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 11, 119, 380);
		frame.getContentPane().add(scrollPane_1);
		
		txtOnline = new JTextArea();
		txtOnline.setEditable(false);
		scrollPane_1.setViewportView(txtOnline);
		frame.setVisible(true);
		frame.setLocation(400, 100);
	}
	// 
	public void HienThi_txtALL(String nd)
	{
		txtALL.append(nd+"\n");
	}
	
	public void HienThi_txtOnline(String nd)
	{
		txtOnline.append(nd+"\n");
	}
}

//************************** DanhSach_Socket **************************
class DanhSach_Socket extends Thread
{
	Socket s = null;
	int port = -1;String ten;
	Server f = null;
	
	public DanhSach_Socket(Socket s,Server f)
	{
		this.s = s;
		port = this.s.getPort();
		
		this.f = f;
		this.start();
	}
	
	boolean run = true;
	@Override
	public void run()
	{
		String snhan;
		while(run)
		{
			try
			{
				snhan = nhan();
				// ------------------------ Login Logout ------------------------
				if(snhan.equals("null"))CloseThread();
				
				if(snhan.equals("CheckADD"))
				{
					gui("ADD");
				}
				
				if(snhan.startsWith("K24.Login"))
				{
					String tmp = snhan.replaceFirst("K24.Login", "");
					
					ten = tmp;
					gui(String.valueOf(port));//gửi lại port
					
					f.GuiTinALLNotMe(ten,(ten+" đã tham gia."));//gửi lời đăng nhập
					
					f.HienThi_txtALL((ten+" đã tham gia."));
					f.HienThi_txtOnline(ten);
					continue;
				}
				
				if(snhan.startsWith("K24.Get_DS_Online"))
				{
					gui(f.GetOnline());
					continue;
				}
				
				// ------------------------ Yêu cầu chat 1-1 ------------------------
				if(snhan.startsWith("K24.GetPort"))
				{
					String tmp = snhan.replaceFirst("K24.GetPort", "");
					String gPort = myString(f.TimPort(tmp));
					gui(gPort+"K24.GetPort");
					
					//f.HienThi_txtALL(ten+" get port "+tmp+" = "+gPort);
					continue;
				}
				
				if(snhan.startsWith("K24.ChatWith"))
				{
					String tmp = snhan.replaceFirst("K24.ChatWith", "");
					
					f.Client_Gui_Client(myint(tmp), ten+"|"+port+"K24.Chat?");
					continue;
				}
				
				if(snhan.startsWith("K24.Chatdi"))
				{
					String tmp = snhan.replaceFirst("K24.Chatdi", "");
					
					f.Client_Gui_Client(myint(tmp), (ten+"|"+port+"K24.ChatStart"));
					continue;
				}
				
				// ------------------------ Chat 1-1 ------------------------
				if(snhan.startsWith("K24.Chat11"))
				{
					String tmp = snhan.replaceFirst("K24.Chat11", "");
					char[] ctemp = tmp.toCharArray();
					String noidung = "",sport = "";
					for (int i = 0; i < ctemp.length; i++)
					{
						if(ctemp[i] != '|')sport += ctemp[i];
						else
						{
							noidung = tmp.replace((sport+"|"),"");
							break;
						}
					}
					
					f.Client_Gui_Client(myint(sport), (port+"|"+ten+" : "+noidung+"K24.Chat11"));
					f.HienThi_txtALL(ten+" gửi cho "+f.TimTen(myint(sport))+" : "+noidung);
					continue;
				}
				
			}
			catch (Exception e)
			{	
				System.err.println("while(run)_"+ten);
				CloseThread();
			}
		}
		/*
		if(snhan.startsWith("K24."))
		{
			String tmp = snhan.replaceFirst("K24.", "");
			
			continue;
		}
		*/
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
		f.HienThi_txtALL(ten+" đã rời phòng.");
		f.GuiTinALLNotMe(ten, ten+" đã rời phòng.");
		
		run = false;
		f.Remove_txtOnline(ten);
		f.remove(s);
		this.stop();
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
















