package com.cha103g5.model;

public class MemberVO {
	private String member_no;
	
	public MemberVO() {
		super();
		
	}
	
	public MemberVO(String member_no) {
		super();
		this.member_no = member_no;
	}



	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
}
