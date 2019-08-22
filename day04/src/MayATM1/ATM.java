package MayATM1;

public interface ATM {
	boolean withdraw(int id, double soTien);
	boolean diposit(int id, double soTien);
	double queryBalance(int id);
	boolean login(String user, String password);
	boolean logout(String user);

}
