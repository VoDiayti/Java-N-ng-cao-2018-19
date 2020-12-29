package bo;

import java.util.ArrayList;

import bean.ThongKeBean;
import dao.ThongKeDao;

public class ThongKeBo {
	ThongKeDao tkdao = new ThongKeDao();

	public ArrayList<ThongKeBean> getThongKeList() throws Exception {
		return tkdao.getThongKeList();
	}
}
