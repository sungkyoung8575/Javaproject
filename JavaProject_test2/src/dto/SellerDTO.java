package dto;

/*
private String id = null;
private String pwd = null;
private String name = null;
private String ck = null;	
private String addr = null;

private String g_name =null;
private int g_num = 0;
private int price = 0;
 */
public class SellerDTO extends UserDTO {
	private String s_name = null;
	private int s_num = 0;
	private String content = null;
	
	
	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "등록된상품 [상품명: " + getG_name() + ", 수량: " + getG_num()
				+ "개, 가격: " + getPrice() + "원]";
	}


	

}
