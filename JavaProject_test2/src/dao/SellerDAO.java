package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.GuestDTO;
import dto.SellerDTO;
import dto.UserDTO;
import service.SellerService;

public class SellerDAO {
	public static SellerDAO sdao=null; // 싱글톤 디자인 코딩시작
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String drivername="oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;	// 커넥션 자원 변수
	
	private SellerDAO() {
			
	}
	public static SellerDAO getInstance() { // 싱글톤
		if(sdao == null) {
			sdao = new SellerDAO();
		}
		return sdao;
	} // 싱글톤 디자인코딩 끝
	
	public void init() {// 드라이버 로드
		try {
			Class.forName(drivername);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean conn() { // 커넥션 가져오는 공통 코드를 메서드로 정의
			try {
				conn = DriverManager.getConnection(url,username, password);
//				System.out.println("커넥션 자원 획득 성공");
				return true;	// 커넥션 자원을 정상적으로 획득 할시
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return false;		// 커넥션 자원획득 실패시
		}
	
	public void insert(SellerDTO sdto) {	
		// TODO Auto-generated method stub
		if(conn()) {
			try {		
				String sql ="insert into "+sdto.getId()+"_s values (?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, sdto.getG_name());
				psmt.setInt(2, sdto.getG_num());
				psmt.setInt(3, sdto.getPrice());
				psmt.setString(4, sdto.getContent());

				int resultInt = psmt.executeUpdate();
				if(resultInt > 0) {
					conn.commit();	// 현재 작업 저장
				}else {
					conn.rollback();	// 현재 작업 취소 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else {
			
			System.out.println("데이터베이스 커넥션 실패");
		
		}		
	}

	
	public ArrayList<SellerDTO> selectAll(String id) {
		ArrayList<SellerDTO> slist = new ArrayList<SellerDTO>();
		if(conn()) {
			try {
				String sql = "select * from "+id+"_s";
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					SellerDTO temp = new SellerDTO();
						temp.setG_name(rs.getString("g_name"));
						temp.setG_num(rs.getInt("g_num"));
						temp.setPrice(rs.getInt("g_price"));
						temp.setContent(rs.getString("g_content"));
						slist.add(temp);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}	
		
		return slist;
	}



	
	

}
