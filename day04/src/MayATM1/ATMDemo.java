package MayATM1;

public class ATMDemo implements  ATM {
	private int idATM;
	private int accountid;
	public ATMDemo(int idATM, int accountid) {
		super();
		this.idATM = idATM;
		this.accountid = accountid;
	}
	public int getIdATM() {
		return idATM;
	}
	public void setIdATM(int idATM) {
		this.idATM = idATM;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "ATMImpl [idATM=" + idATM + ", accountid=" + accountid + "]";
	}
	@Override
	public boolean withdraw(int id, double soTien) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean diposit(int id, double soTien) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double queryBalance(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean login(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean logout(String user) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
