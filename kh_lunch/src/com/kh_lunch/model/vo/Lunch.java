package com.kh_lunch.model.vo;

import java.util.Date;

public class Lunch {
	
	/*
	create table LUNCH(
		    "LUN_NUM" number,
		    "LUN_RESTAURANT" varchar2(100),
		    "LUN_WIN" number DEFAULT 0,
          	"LUN_CNT" number DEFAULT 0,
		    "LUN_DATE" DATE
	);
	
	-- num
	create sequence seq_lun_num
	start with 1
	increment by 1
	maxvalue 10000
	nocycle
	nocache;

	drop sequence seq_lun_num;
	
	insert into lunch VALUES(seq_lun_num.nextval, '맥주창고', default, default, sysdate);
	insert into lunch VALUES(seq_lun_num.nextval, '돈까스', default, default, sysdate);
	insert into lunch VALUES(seq_lun_num.nextval, '산들해', default, default, sysdate);
	insert into lunch VALUES(seq_lun_num.nextval, '국수', default, default, sysdate);
	insert into lunch VALUES(seq_lun_num.nextval, '김밥집', default, default, sysdate);
	*/
	
	private int lunNum;
	private String lunRestaurant;
	private int lunWin;
	private int lunCnt;
	private Date lunDate;
	
	public Lunch() {
		// TODO Auto-generated constructor stub
	}

	public Lunch(int lunNum, String lunRestaurant, int lunWin, int lunCnt, Date lunDate) {
		super();
		this.lunNum = lunNum;
		this.lunRestaurant = lunRestaurant;
		this.lunWin = lunWin;
		this.lunCnt = lunCnt;
		this.lunDate = lunDate;
	}

	public int getLunNum() {
		return lunNum;
	}

	public void setLunNum(int lunNum) {
		this.lunNum = lunNum;
	}

	public String getLunRestaurant() {
		return lunRestaurant;
	}

	public void setLunRestaurant(String lunRestaurant) {
		this.lunRestaurant = lunRestaurant;
	}

	public int getLunWin() {
		return lunWin;
	}

	public void setLunWin(int lunWin) {
		this.lunWin = lunWin;
	}

	public int getLunCnt() {
		return lunCnt;
	}

	public void setLunCnt(int lunCnt) {
		this.lunCnt = lunCnt;
	}

	public Date getLunDate() {
		return lunDate;
	}

	public void setLunDate(Date lunDate) {
		this.lunDate = lunDate;
	}

	@Override
	public String toString() {
		return "Lunch [lunNum=" + lunNum + ", lunRestaurant=" + lunRestaurant + ", lunWin=" + lunWin + ", lunCnt="
				+ lunCnt + ", lunDate=" + lunDate + "]";
	}

	
	
}