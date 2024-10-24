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
import service.GuestService;
// 전체 회원관리
public class MainDAO {
	public static MainDAO ms=null;
	private String username="system";
	private String password="11111111";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String drivername="oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;	// 커넥션 자원 변수
	
	public MainDAO() {
		
	}
	public static MainDAO getInstance() {
		if(ms == null) {
			ms = new MainDAO();
		}
		return ms;
	}
	
	private void init() {// 드라이버 로드
		try {
			Class.forName(drivername);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private boolean conn() { // 커넥션 가져오는 공통 코드를 메서드로 정의
		try {
			conn = DriverManager.getConnection(url,username, password);
//			System.out.println("커넥션 자원 획득 성공");
			return true;	// 커넥션 자원을 정상적으로 획득 할시
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		// 커넥션 자원획득 실패시
	}


		
	public void insertG(GuestDTO gdto) { // 개인고객 insert , 개인테이블,시퀀스생성
		if(conn()) {
			try {
				String sql ="insert into alluser values (?,?,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, gdto.getCk());
				psmt.setString(2, gdto.getId());
				psmt.setString(3, gdto.getPwd());
				psmt.setString(4, gdto.getName());
				psmt.setString(5, gdto.getAddr());
				psmt.setString(6, "null");
				psmt.setInt(7, 0);
				int resultInt = psmt.executeUpdate();
				String sql2 = "create table "+gdto.getId()	// 컬럼명 임시/ 수정해야함
							+"_g (g_date timestamp default sysdate,"
							+ "g_name varchar2(20),"
							+ "g_num number(3),"
							+ "g_price number(6))";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				resultInt = psmt2.executeUpdate();
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
	
	public void insertS(SellerDTO dto) { // 사업자고객 insert
		if(conn()) {
			try {		
				String sql ="insert into alluser values (?,?,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getCk());
				psmt.setString(2, dto.getId());
				psmt.setString(3, dto.getPwd());
				psmt.setString(4, dto.getName());
				psmt.setString(5, dto.getAddr());
				psmt.setString(6, dto.getS_name());
				psmt.setInt(7, dto.getS_num());
				int resultInt = psmt.executeUpdate();
				String sql2 = "create table "+dto.getId()	
							+"_s(g_name varchar2(20),"
							+ "g_num number(3),"
							+ "g_price number(6),"
							+ "g_content varchar2(100))";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				resultInt = psmt2.executeUpdate();
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

		public UserDTO selectID(String find){ 
			if(conn()) {
				try {
					String sql = "select * from alluser where id=?";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, find);
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						UserDTO temp = new UserDTO();
						temp.setCk(rs.getNString("ck"));
						temp.setId(rs.getNString("id"));
						temp.setPwd(rs.getNString("pwd"));
						temp.setName(rs.getString("name"));
						return temp;
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
			return null;	
		}
		
		public SellerDTO selectSeller(String find){ 
			if(conn()) {
				try {
					String sql = "select * from alluser where id=?";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, find);
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						SellerDTO temp = new SellerDTO();
						temp.setCk(rs.getNString("ck"));
						temp.setId(rs.getNString("id"));
						temp.setPwd(rs.getNString("pwd"));
						temp.setName(rs.getString("name"));
						return temp;
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
			return null;	
		}
			
		public GuestDTO selectGuest(String find){ 
			if(conn()) {
				try {
					String sql = "select * from alluser where id=?";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, find);
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						GuestDTO temp = new GuestDTO();
						temp.setCk(rs.getNString("ck"));
						temp.setId(rs.getNString("id"));
						temp.setPwd(rs.getNString("pwd"));
						temp.setName(rs.getString("name"));
						return temp;
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
			return null;	
		}
			


		public ArrayList<UserDTO> selectAll(){
			ArrayList<UserDTO> userlist=new ArrayList<UserDTO>();
			if(conn()) {
				try {
					String sql = "select * from alluser";
					PreparedStatement psmt = conn.prepareStatement(sql);
					ResultSet rs = psmt.executeQuery();
					while(rs.next()) {
							UserDTO temp = new UserDTO();
							temp.setCk(rs.getNString("ck"));
							temp.setId(rs.getNString("id"));
							temp.setPwd(rs.getNString("pwd"));
							temp.setName(rs.getString("name"));
							userlist.add(temp);
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
			return userlist;
		}
		
		

	
}
