package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.MonHocBean;

public class MonHocDao {
	

	public ArrayList<MonHocBean> getMonHocList() throws Exception {
		ArrayList<MonHocBean> lsMH = new ArrayList<MonHocBean>();
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "SELECT * FROM MONHOC";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String maMonHoc = rs.getString("MaMH");
			String tenMonHoc = rs.getString("TenMH");
			int soTinChi = rs.getInt("SoTinChi");
			int soBuoi = rs.getInt("SoBuoi");
			int soSVToiThieu = rs.getInt("SoSVToiThieu");
			int soSVToiDa = rs.getInt("SoSVToiDa");
			int soSVDangKy = rs.getInt("SoSVDangKy");
			Date ngayNhapHoc = rs.getDate("NgayNhapHoc");
			Date ngayHetHan = rs.getDate("NgayHetHan");
			MonHocBean mh = new MonHocBean(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
			lsMH.add(mh);
		}
		return lsMH;
	}

	public MonHocBean getMonHocByMaMonHoc(String maMH) throws Exception {
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "SELECT * FROM MONHOC WHERE MaMH = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maMH);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String maMonHoc = rs.getString("MaMH");
			String tenMonHoc = rs.getString("TenMH");
			int soTinChi = rs.getInt("SoTinChi");
			int soBuoi = rs.getInt("SoBuoi");
			int soSVToiThieu = rs.getInt("SoSVToiThieu");
			int soSVToiDa = rs.getInt("SoSVToiDa");
			int soSVDangKy = rs.getInt("SoSVDangKy");
			Date ngayNhapHoc = rs.getDate("NgayNhapHoc");
			Date ngayHetHan = rs.getDate("NgayHetHan");
			MonHocBean mh = new MonHocBean(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
			return mh;
		}
		return null;
	}

	public int themMonHoc(String maMonHoc, String tenMonHoc, int soTinChi, int soBuoi, int soSVToiThieu, int soSVToiDa, int soSVDangKy, Date ngayNhapHoc, Date ngayHetHan) throws Exception {
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "INSERT INTO MONHOC VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maMonHoc);
		stmt.setString(2, tenMonHoc);
		stmt.setInt(3, soTinChi);
		stmt.setInt(4, soBuoi);
		stmt.setInt(5, soSVToiThieu);
		stmt.setInt(6, soSVToiDa);
		stmt.setInt(7, soSVDangKy);
		stmt.setDate(8, new java.sql.Date(ngayNhapHoc.getTime()));
		stmt.setDate(9, new java.sql.Date(ngayHetHan.getTime()));
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt; // return id
	}

	public int suaMonHoc(String maMonHoc, String tenMonHoc, int soTinChi, int soBuoi, int soSVToiThieu, int soSVToiDa, int soSVDangKy, Date ngayNhapHoc, Date ngayHetHan) throws Exception {
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "UPDATE MONHOC SET TenMH = ?, SoTinChi = ?, SoBuoi = ?, SoSVToiThieu = ?, SoSVToiDa = ?, SoSVDangKy = ?, NgayNhapHoc = ?, NgayHetHan = ? WHERE MaMH = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, tenMonHoc);
		stmt.setInt(2, soTinChi);
		stmt.setInt(3, soBuoi);
		stmt.setInt(4, soSVToiThieu);
		stmt.setInt(5, soSVToiDa);
		stmt.setInt(6, soSVDangKy);
		stmt.setDate(7, new java.sql.Date(ngayNhapHoc.getTime()));
		stmt.setDate(8, new java.sql.Date(ngayHetHan.getTime()));
		stmt.setString(9, maMonHoc);
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt; // return id
	}

	public int xoaMonHoc(String maMonHoc) throws Exception {
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "DELETE FROM MONHOC WHERE MaMH = ? AND MaMH NOT IN (SELECT MaMH FROM DANGKY)";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maMonHoc);
		int cnt = stmt.executeUpdate();
		System.out.println("cnt = " + cnt);
		return cnt;
	}
}
