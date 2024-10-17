package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.GuestDTO;

public class GuestDAO {
	
	public static GuestDAO gdao=null; // 싱글톤 디자인 코딩시작

	
	public static GuestDAO getInstance() { // 싱글톤
		if(gdao == null) {
			gdao = new GuestDAO();
		}
		return gdao;
	} // 싱글톤 디자인코딩 끝
	

	
	
		
		




}

