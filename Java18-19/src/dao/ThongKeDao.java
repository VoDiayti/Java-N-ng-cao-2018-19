package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.ThongKeBean;

public class ThongKeDao {

	public ArrayList<ThongKeBean> getThongKeList() throws Exception {
		ArrayList<ThongKeBean> lsTK = new ArrayList<ThongKeBean>();
		dungchungdao db = new dungchungdao();
		db.KetNoi();
		String sql = "SELECT * FROM view_thongke ORDER BY TongSoTinChi DESC";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String maSinhVien = rs.getString("MaSV");
			String hoTen = rs.getString("HoTen");
			Date ngaySinh = rs.getDate("NgaySinh");
			boolean gioiTinh = rs.getBoolean("GioiTinh");
			String diaChi = rs.getString("DiaChi");
			String lop = rs.getString("Lop");
			String email = rs.getString("Email");
			String soDienThoai = rs.getString("SoDienThoai");
			int tongSoTinChi = rs.getInt("TongSoTinChi");
			ThongKeBean tk = new ThongKeBean(maSinhVien, hoTen, ngaySinh, gioiTinh, diaChi, lop, email, soDienThoai, tongSoTinChi);
			lsTK.add(tk);
		}
		System.out.println(lsTK);
		return lsTK;
	}
}	
