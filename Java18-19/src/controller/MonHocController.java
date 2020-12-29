package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MonHocBean;
import bo.MonHocBo;

/**
 * Servlet implementation class MonHocController
 */
@WebServlet("/MonHocController")
public class MonHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonHocController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    MonHocBo mhbo = new MonHocBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// Chon 1 mon hoc
		if(request.getParameter("maChon") != null) {
			try {
				MonHocBean monhoc = mhbo.getMonHocByMaMonHoc(request.getParameter("maChon"));
				System.out.print(monhoc);
				request.setAttribute("monhoc", monhoc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Them moi / Chinh sua 1 mon hoc
		if(request.getParameter("btnCreate") != null || request.getParameter("btnEdit") != null) {
			String maMonHoc = request.getParameter("maMH");
			String tenMonHoc = request.getParameter("tenMH");
			int soTinChi = Integer.parseInt(request.getParameter("soTC"));
			int soBuoi = Integer.parseInt(request.getParameter("soBuoi"));
			int soSVToiThieu = Integer.parseInt(request.getParameter("soSVTT"));
			int soSVToiDa = Integer.parseInt(request.getParameter("soSVTD"));
			int soSVDangKy = Integer.parseInt(request.getParameter("soSVDK"));
			String txt_ngayNhapHoc = request.getParameter("ngayNhapHoc");
			String txt_ngayHetHan = request.getParameter("ngayHetHan");
			try {
				Date ngayNhapHoc = new SimpleDateFormat ("yyyy-MM-dd").parse(txt_ngayNhapHoc);
				Date ngayHetHan = new SimpleDateFormat ("yyyy-MM-dd").parse(txt_ngayHetHan);
				if(request.getParameter("btnCreate") != null) {
					if(mhbo.getMonHocByMaMonHoc(maMonHoc) != null) {
						MonHocBean mhThem = new MonHocBean(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
						PrintWriter out = response.getWriter();
						request.setAttribute("checkMaMH", "Mã Môn Học đã tồn tại");
						request.setAttribute("monhoc", mhThem);
					}
					else {
						mhbo.themMonHoc(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
					}
					
				}
				else {
					mhbo.suaMonHoc(maMonHoc, tenMonHoc, soTinChi, soBuoi, soSVToiThieu, soSVToiDa, soSVDangKy, ngayNhapHoc, ngayHetHan);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// Xoa mon hoc
		if(request.getParameter("maXoa") != null) {
			try {
				int res = mhbo.xoaMonHoc(request.getParameter("maXoa"));
				if(res == 0) {
					request.setAttribute("checkXoa", "Môn học đã có SV đăng ký. Không thể xóa");
				}
				else {
					request.setAttribute("checkXoa", "Xóa thành công");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// Get all MonHoc
		ArrayList<MonHocBean> lsMH = new ArrayList<MonHocBean>();
		try {
			lsMH = mhbo.getMonHocList();
			System.out.println(lsMH);
			request.setAttribute("lsMH", lsMH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("QuanLyMonHoc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
