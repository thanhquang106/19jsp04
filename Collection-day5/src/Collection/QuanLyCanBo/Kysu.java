package Collection.QuanLyCanBo;

public class Kysu extends Canbo {
	private String DaoTao;

	public Kysu(String hoten, int namSinh, String gioiTinh, String diaChi, String DaoTao) {
		super(hoten, namSinh, gioiTinh, diaChi);
		// TODO Auto-generated constructor stub
	}

	public String getDaoTao() {
		return DaoTao;
	}

	public void setDaoTao(String daoTao) {
		DaoTao = daoTao;
	}

}
