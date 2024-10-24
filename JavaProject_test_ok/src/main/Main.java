
package main;

import service.MainMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainMenu mm = new MainMenu();

/*

최소 생성 회원테이블
create table alluser(
ck varchar2(1) check (ck in ('g','s')),	
id varchar2(10) primary key,
pwd varchar2(10),
addr varchar2(10),
name varchar2(6),
s_name varchar2(20),		
s_num number(10)); 	


개인회원 테이블 = id_g		// 마이페이지용
상품명,수량,금액,구매날짜
g_name varchar2(20),
g_num number(3),
g_price number(6),
g_date timestamp default sysdate);


사업자회원 테이블 = id_s		// 상품등록관리용?
상품명,수량,금액,상세정보
g_name varchar2(20),
g_num number(3),
g_price number(6),
g_content varchar2(100));


판매페이지 테이블?
주문접수 테이블?


sequence	
nextval	
		
 */

		
		
	}

}
