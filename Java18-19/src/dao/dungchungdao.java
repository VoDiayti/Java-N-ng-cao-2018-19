package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dungchungdao {
	public Connection cn;

	public void KetNoi() throws Exception {
		// Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Ket noi vao CSDL;
		String url = "jdbc:sqlserver://MSI\\VODAT:1433;databaseName=DangKyMonHoc;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	
}
