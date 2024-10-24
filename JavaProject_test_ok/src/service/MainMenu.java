package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MainDAO;
import dto.GuestDTO;
import dto.SellerDTO;
import dto.UserDTO;


public class MainMenu {
	UserDTO loginUser = null;
	
	private MainDAO mdao = MainDAO.getInstance();
	private GuestService gs = GuestService.getInstance();
	private SellerService ss = SellerService.getInstance();

	// 로그인 , 회원가입 
	public MainMenu() {
		menu();
	}
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 전체보기 - 확인용"); // 확인용 
			int selNum = in.nextInt();in.nextLine();
			if(selNum==1) {
				login();
			}else if (selNum == 2) {
				signup();	
			}else if (selNum == 3) {
				allList();
			}else {break;}
		}
		
	}
	
	private void allList() {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> a = mdao.selectAll();
		System.out.println(a.toString());
	}

	private void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("ID 입력");
		String id = in.nextLine();
		int g = check(id);
		if(g != 1) {
			int g2 = logincheck(id);	// 리턴값 : 개인 1 , 사업자 2 , 비밀번호 오류 -1
			if(g2==1) {
				GuestDTO login = mdao.selectGuest(id);
				loginUser = login;
				gs.loginGuest = (GuestDTO) loginUser;
				gs.menu();
				
			}else if(g2 ==2) {
				SellerDTO login = mdao.selectSeller(id);
				loginUser = login;
				ss.loginSeller = (SellerDTO) loginUser;
				ss.menu();
			}
			
		}else {
			System.out.println("id가 존재하지 않습니다");
		}

		
	}

	private void signup() { // 회원가입
		Scanner in = new Scanner(System.in);
		System.out.println("1. 개인 / 2. 사업자");
		int selnum = in.nextInt();in.nextLine();	// 개인인지 사업자인지 
		if(selnum == 1) {// 개인
			System.out.println("ID 입력");
			String id = in.nextLine();	
			int g = check(id);
			if(g ==1) {
				System.out.println("비밀번호 입력");
				String pwd = in.nextLine();
				System.out.println("이름 입력");
				String name = in.nextLine();
				System.out.println("주소 입력");
				String addr = in.nextLine();
				GuestDTO gdto = new GuestDTO();	
				gdto.setCk("g");
				gdto.setId(id);
				gdto.setPwd(pwd);
				gdto.setName(name);
				gdto.setAddr(addr);
				mdao.insertG(gdto);
				System.out.println("회원가입 완료");
			}else {
				System.out.println("중복된 id가 있습니다.");
			}
		}else if(selnum==2) {
			System.out.println("ID 입력");
			String id = in.nextLine();	
			int g = check(id);
			if(g ==1) {
				System.out.println("비밀번호 입력");
				String pwd = in.nextLine();
				System.out.println("이름 입력");
				String name = in.nextLine();
				System.out.println("주소 입력");
				String addr = in.nextLine();
				System.out.println("마켓이름 입력");
				String s_name = in.nextLine();
				System.out.println("사업자번호 숫자 10자리 입력");
				int s_num = in.nextInt();in.nextLine();
				SellerDTO sdto = new SellerDTO();
				sdto.setCk("s");
				sdto.setId(id);
				sdto.setPwd(pwd);
				sdto.setName(name);
				sdto.setAddr(addr);
				sdto.setS_name(s_name);
				sdto.setS_num(s_num);
				mdao.insertS(sdto);
				System.out.println("회원가입 완료");
			}else {
				System.out.println("중복된 id가 있습니다.");
			}
		}
	}



	public int check(String find) {		// 아이디 중복체크
		UserDTO g = mdao.selectID(find);
		if(g != null) {	// 값이 있을때 -1 리턴
			return -1;
		}
		return 1;
	}
	
	public int logincheck(String find) {
		Scanner in = new Scanner(System.in);
		UserDTO g2 = mdao.selectID(find);
		System.out.println("비밀번호입력");
		String pwd = in.nextLine();
		if(g2.getPwd().equals(pwd)) {
			if(g2.getCk().equals("g")) {
				return 1;	// 개인이면 1 리턴
			}else {
				return 2;
			}
		}
		return -1;		// 비밀번호 오류
	}



}
