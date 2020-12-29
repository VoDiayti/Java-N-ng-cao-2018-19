package bean;

import java.util.Date;

public class MonHocBean {
	private String maMonHoc;
	private String tenMonHoc;
	private int soTinChi;
	private int soBuoi;
	private int soSVToiThieu;
	private int soSVToiDa;
	private int soSVDangKy;
	private Date ngayNhapHoc;
	private Date ngayHetHan;
	
	public MonHocBean(String maMonHoc, String tenMonHoc, int soTinChi, int soBuoi, int soSVToiThieu, int soSVToiDa,
			int soSVDangKy, Date ngayNhapHoc, Date ngayHetHan) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.soTinChi = soTinChi;
		this.soBuoi = soBuoi;
		this.soSVToiThieu = soSVToiThieu;
		this.soSVToiDa = soSVToiDa;
		this.soSVDangKy = soSVDangKy;
		this.ngayNhapHoc = ngayNhapHoc;
		this.ngayHetHan = ngayHetHan;
	}
	
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public int getSoBuoi() {
		return soBuoi;
	}
	public void setSoBuoi(int soBuoi) {
		this.soBuoi = soBuoi;
	}
	public int getSoSVToiThieu() {
		return soSVToiThieu;
	}
	public void setSoSVToiThieu(int soSVToiThieu) {
		this.soSVToiThieu = soSVToiThieu;
	}
	public int getSoSVToiDa() {
		return soSVToiDa;
	}
	public void setSoSVToiDa(int soSVToiDa) {
		this.soSVToiDa = soSVToiDa;
	}
	public int getSoSVDangKy() {
		return soSVDangKy;
	}
	public void setSoSVDangKy(int soSVDangKy) {
		this.soSVDangKy = soSVDangKy;
	}
	public Date getNgayNhapHoc() {
		return ngayNhapHoc;
	}
	public void setNgayNhapHoc(Date ngayNhapHoc) {
		this.ngayNhapHoc = ngayNhapHoc;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
	
}
