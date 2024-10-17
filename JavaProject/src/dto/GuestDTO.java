package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//	private String id = null;   
//	private String pwd = null;
//	private String name = null;
//	private String check = null;

public class GuestDTO extends UserDTO {

	private String date = null;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
