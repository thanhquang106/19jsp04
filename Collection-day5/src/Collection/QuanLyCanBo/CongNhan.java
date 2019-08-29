package Collection.QuanLyCanBo;

public class CongNhan extends Canbo {
	private String bac;

	public CongNhan(String hoten, int namSinh, String gioiTinh, String diaChi, String bac) {
		super(hoten, namSinh, gioiTinh, diaChi);
		// TODO Auto-generated constructor stub
	}

	public String getBac() {
		return bac;
	}

	public void setBac(String bac) {
		this.bac = bac;
	}

}
