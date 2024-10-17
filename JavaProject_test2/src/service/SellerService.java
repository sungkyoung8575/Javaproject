package service;

import java.util.Scanner;

import dao.SellerDAO;
import dto.GuestDTO;
import dto.SellerDTO;

public class SellerService {

	public static SellerService ss=null; // 싱글톤 디자인 코딩시작
	private SellerDAO sdao = SellerDAO.getInstance();

	private SellerService() {
			
	}
	public static SellerService getInstance() { // 싱글톤
		if(ss == null) {
			ss = new SellerService();
		}
		return ss;
	} // 싱글톤 디자인코딩 끝

	public void menu() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1. 주문 접수건 확인");
			System.out.println("2. 상품올리기");
			System.out.println("3. 상품 전체보기");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 로그아웃");
			int selNum= in.nextInt();
			in.nextLine();
			switch(selNum) {
				case 1: orderList(); break;
				case 2:	g_add(); break;
				case 3: g_all(); break;
				case 4: g_mod();break;
				case 5: g_del();break;
				case 6:	flag = false; break;
			}
		}
		in.close();
	}
		
		
	private void g_all() { // 올린상품 전체보기
		// TODO Auto-generated method stub
		
	}
	private void g_del() {	// 상품삭제
		// TODO Auto-generated method stub
		
	}
	private void g_mod() {	// 상품 수정
		// TODO Auto-generated method stub
		
	}
	private void g_add() {	// 상품등록
		Scanner in = new Scanner(System.in);
		System.out.println("상품명 입력");
		String g_name = in.nextLine();
		System.out.println("수량 입력");
		int g_num = in.nextInt();in.nextLine();
		System.out.println("가격 입력");
		int price = in.nextInt();in.nextLine();
		SellerDTO sdto = new SellerDTO();
		sdto.setG_name(g_name);
		sdto.setG_num(g_num);
		sdto.setPrice(price);
		sdao.insert(sdto);
		
		
	}
	private void orderList() { //주문건 확인하기
		// TODO Auto-generated method stub
		
	}




	
	
}
