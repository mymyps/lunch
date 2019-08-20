package com.kh_lunch.model.services;

import java.sql.Connection;
import java.util.List;

import static com.kh_lunch.common.JdbcTemplate.*;
import com.kh_lunch.model.dao.LunchDao;
import com.kh_lunch.model.vo.Lunch;

public class LunchServices {
	
	private LunchDao lunDao = new LunchDao();
	
	public List<Lunch> menuList(int ck) {
		
		Connection conn = getConnection();
		
		List<Lunch> list = lunDao.menuList(conn, ck);
		
		if(list.isEmpty())
			rollback(conn);
		else
			commit(conn);
		
		close(conn);
		
		return list;
	}
	
	public void menuInsert(Lunch l) {
		
		Connection conn = getConnection();
		
		int ck = lunDao.menuInsert(conn, l);
		
		if ( ck == 0)
			rollback(conn);
		else
			commit(conn);
		
		close(conn);
		
	}
	
	// 먹은 메뉴 초기화'
	public int menuUpdate() {
		
		Connection conn = getConnection();
		
		int ck = lunDao.menuUpdate(conn);
		
		if (ck == 0)
			rollback(conn);
		else
			commit(conn);
		
		close(conn);
		
		return ck;
		
	}
	
	// 메뉴 선택
	public int menuSel(Lunch l) {
		
		Connection conn = getConnection();
		
		int ck = lunDao.menuSel(conn, l);
		
		if (ck == 0)
			rollback(conn);
		else
			commit(conn);
		
		close(conn);
		
		return ck;
		
	}
	
	// 메뉴 삭제
	public int menuDelete(String menu) {
		
		Connection conn = getConnection();
		
		int ck = lunDao.menuDelete(conn, menu);
		
		if (ck == 0)
			rollback(conn);
		else
			commit(conn);
		
		close(conn);
		
		return ck;
	}

}
