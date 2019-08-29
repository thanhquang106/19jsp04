package Collection.QuanLyCanBo;

public class NhanVien extends Canbo {
	private String CongViec;

	public NhanVien(String hoten, int namSinh, String gioiTinh, String diaChi, String CongViec) {
		super(hoten, namSinh, gioiTinh, diaChi);
		// TODO Auto-generated constructor stub
	}

	public String getCongViec() {
		return CongViec;
	}

	public void setCongViec(String congViec) {
		this.CongViec = congViec;
	}

}
