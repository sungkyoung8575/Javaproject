package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GuestDAO;
import dao.SellerDAO;
import dto.GuestDTO;
// 개인회원 서비스
public class GuestService {
	public static GuestService gs=null;
	private GuestDAO gdao = GuestDAO.getInstance();
	private GuestService() {
		
	}
	public static GuestService getInstance() {
		if(gs == null) {
			gs = new GuestService();
		}
		return gs;
	}
	
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1. 상품구매");
			System.out.println("2. 구매내역");
			System.out.println("3. 로그아웃");

			int selNum= in.nextInt();
			in.nextLine();
			switch(selNum) {
				case 1: buy(); break;
				case 2:	mylist(); break;
				case 3:	flag = false; break;
			}
		}
	}
	private void buy() {
		// TODO Auto-generated method stub
		//1 상품목록 보여주고 구매하기
		
	}
	private void mylist() {
		// TODO Auto-generated method stub
		//구매한 전체 리스트 보여주기
	}
	


}
