package com.kh_lunch.lunchController;

import java.util.ArrayList;
import java.util.List;

import com.kh_lunch.model.services.LunchServices;
import com.kh_lunch.model.vo.Lunch;
import com.kh_lunch.view.LunchView;

public class LunchController {
	
	private LunchServices lunSrvs = new LunchServices();
	
	public void lunchController(){
		
		new LunchView().initView(this);
		
	}
	
	// 메뉴 리스트 뷰 불러오기
	public void menuListView() {
		new LunchView().menuList(this);
	}
	
	// 메뉴 리스트 가져오
	public List<Lunch> menuList(int ck) {
		
		List<Lunch> list = new ArrayList<Lunch>();
		
		list = lunSrvs.menuList(ck);
		new LunchView().lunchPrint(list);
		
		return list;
	}
	
	// 메뉴 추가
	public void menuInsert() {
		
		String menu = new LunchView().inputData("추가할 메뉴");
		
		Lunch l = new Lunch();
		l.setLunRestaurant(menu);
		
		lunSrvs.menuInsert(l);
		
	}
	
	// 메뉴 초기화
	public void menuUpdate() {
		
		int ck = lunSrvs.menuUpdate();
		
		if (ck != 0)
			System.out.println("초기화 성공");
	}
	
	
	// 랜덤 메뉴 뷰 선택
	public void menuSelView() {
		new LunchView().menuSel(this);
	}
	
	// 랜덤 메뉴 선택
	public void menuSel(Lunch l) {
		
		// services
		int ck = lunSrvs.menuSel(l);
		
		if (ck != 0)
			System.out.println("음식 선택 성공");
	}
	
	// 메뉴 삭제
	public void menuDelete() {
		
		String menu = new LunchView().inputData("삭제할 메뉴");
		
		int ck = lunSrvs.menuDelete(menu);
		
		if (ck != 0)
			System.out.println("음식 삭제 성공");
		
	}

}
