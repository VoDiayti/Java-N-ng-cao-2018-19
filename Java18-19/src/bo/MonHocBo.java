package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.MonHocBean;
import dao.MonHocDao;

public class MonHocBo {
	MonHocDao mhdao = new MonHocDao();

	public ArrayList<MonHocBean> getMonHocList() throws Exception {
		return mhdao.getMonHocList();
	}

	public MonHocBean getMonHocByMaMonHoc(String maMH) throws Exception {
		return mhdao.getMonHocByMaMonHoc(maMH);
	}

	public int themMonHoc(String maMonHoc, String tenMonHoc, int soTinChi, int soBuoi, int soSVToiThieu, int soSVToiDa, int soSVDangKy, Date ngayNhapHoc, Date ngayHetHan) throws Exception {
		return mhdao.themMonHoc(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
	}

	public int suaMonHoc(String maMonHoc, String tenMonHoc, int soTinChi, int soBuoi, int soSVToiThieu, int soSVToiDa, int soSVDangKy, Date ngayNhapHoc, Date ngayHetHan) throws Exception {
		return mhdao.suaMonHoc(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
	}

	public int xoaMonHoc(String maMonHoc) throws Exception {
		return mhdao.xoaMonHoc(maMonHoc);
	}
}
