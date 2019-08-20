package com.kh_lunch.view;

import java.util.List;
import java.util.Scanner;

import com.kh_lunch.lunchController.LunchController;
import com.kh_lunch.model.vo.Lunch;

public class LunchView {
	
	private Scanner sc = null;
	
	public void initView(LunchController mc) {
		
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("========================");
			System.out.println("-- 오늘의 맛집을 찾아서!!! --");
			System.out.println("------------------------");
			System.out.println("--  1. 맛집 리스트       --");
			System.out.println("--  2. 메뉴 고르기       --");
			System.out.println("------------------------");
			System.out.println("--  0. 닫기            --");
			System.out.println("========================");
			System.out.print("- 입력 : ");

			int ck = sc.nextInt();
			
			if(ck > -1 && ck < 3) {

				switch (ck) {
				case 1:
					mc.menuListView();
					break;
				case 2:
					mc.menuSelView();
					break;
				case 0:
					System.exit(0);
					break;

				default:
					break;
				}
				
			}//if

		}
		
		
	}
	
	// String input
	public String inputData(String str) {
		
		sc = new Scanner(System.in);
		System.out.print(str + " 입력 : ");
		
		return sc.nextLine();
	}
	
	// print
	public void lunchPrint(List<?> list) {
		
		System.out.println("-----------------------------------------------");
		for (Object o : list) {
			System.out.println("| " + ((Lunch)o).getLunRestaurant() + "\t\t| 당첨(" + ((Lunch)o).getLunWin() +")"
					+ "   \t| 다녀간 횟수(" + ((Lunch)o).getLunCnt() + ") |" );
//			System.out.print(o);
		}
		System.out.println("-----------------------------------------------");
		System.out.println();
		
	}

	// -- 메뉴 보기 및 추가
	public void menuList(LunchController mc) {
		
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("************************");
			System.out.println("-- 오늘의 맛집을 찾아서!!! --");
			System.out.println("------------------------");
			System.out.println("--  1. 메뉴 리스트 보기   --");
			System.out.println("--  2. 메뉴 추가        --");
			System.out.println("--  3. 메뉴 초기화       --");
			System.out.println("--  4. 메뉴 삭제        --");
			System.out.println("------------------------");
			System.out.println("--  0. 돌아가기         --");
			System.out.println("************************");

			System.out.print("- 입력 : ");
			int ck = sc.nextInt();

			if(ck > -1 && ck < 5) {
			
				switch (ck) {
				case 1:
					mc.menuList(0);
					break;
				case 2:
					mc.menuInsert();
					break;
				case 3:
					mc.menuUpdate();
					break;
				case 4:
					mc.menuDelete();
					break;
				case 0:
					mc.lunchController();
					break;

				default:
					break;
				}

			}//if

		}

	}
	
	
	// 음식 선택!
	public void menuSel(LunchController mc) {
		
		System.out.println("//-- 이번주 먹지 않은 음식 리스트 --//");
		
		// 아직 먹지 않은 음식 리스트
		List<Lunch> list = new LunchController().menuList(1); // 2번째 쿼리문 값(1)
		
		if (list.size() != 0) {

			int menuRnd = (int)(Math.random() * list.size());
//			System.out.println("랜덤값 : " + menuRnd);

			System.out.println("식점 : " + list.get(menuRnd).getLunRestaurant());
			Lunch l = list.get(menuRnd);

			mc.menuSel(l);
		}else
			System.out.println("요번주 다 먹어봤슴따!!");
		
		
	}

}
