package com.kh_lunch.model.dao;

import static com.kh_lunch.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.kh_lunch.model.vo.Lunch;

public class LunchDao {
	
	public List<Lunch> menuList(Connection conn, int ck) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Lunch> list = new ArrayList<Lunch>();
		String sql = "";

		/////////////////////////////////////////////////////
		String[] weekDay = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };   
		//		1 : 월요일
		Calendar cal = Calendar.getInstance(); 
		int num = cal.get(Calendar.DAY_OF_WEEK)-1; 
		String today = weekDay[num]; 
		/////////////////////////////////////////////////////
		
		
		if (ck == 0)
			sql = "select * from lunch";
		else {
			// 0 : 아직 선택 안된 리스트 / 그외 : 한번 먹은 리스트 
			if (num == 4 || num == 5) {
				System.out.println("오늘의 요일 : " + today ); 
				sql = "select rownum, a.* from(select * from lunch where lun_win = 0 order by lun_cnt)a where rownum between 1 and 6";
			}else {
				sql = "select * from lunch where lun_win = 0";
			}
		}
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Lunch l = new Lunch();
				
				/*
				"LUN_NUM" number,
			    "LUN_RESTAURANT" varchar2(100),
			    "LUN_WIN" number DEFAULT 0,
	          	"LUN_CNT" number DEFAULT 0,
			    "LUN_DATE" DATE 
				 */
				
				l.setLunNum(rs.getInt("LUN_NUM"));
				l.setLunRestaurant(rs.getString("LUN_RESTAURANT"));
				l.setLunWin(rs.getInt("LUN_WIN"));
				l.setLunCnt(rs.getInt("LUN_CNT"));
				l.setLunDate(rs.getDate("LUN_DATE"));
				
				list.add(l);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return list;
	}
	
	
	// insert
	
	public int menuInsert(Connection conn, Lunch l) {
		
		PreparedStatement stmt = null;
		String sql = "insert into lunch VALUES(seq_lun_num.nextval, ?, default , default, sysdate)";

		int ck = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			
//			stmt.setInt(1, l.getLunNum()); // 디비 시쿼스로 대체
			stmt.setString(1, l.getLunRestaurant());
			
			ck = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return ck;
		
	}
	
	// 메뉴 초기화
	
	public int menuUpdate(Connection conn) {
		
		int ck = 0;
		
		PreparedStatement stmt = null;
		String sql = "update lunch SET lun_win = 0";

		try {
			
			stmt = conn.prepareStatement(sql);
			ck = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return ck;
	}

	public int menuSel(Connection conn, Lunch l) {
		
		int ck = 0;
		PreparedStatement stmt = null;
		String sql = "";
		
		sql = "update lunch set lun_win = 1, lun_cnt = ? where lun_restaurant = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, l.getLunCnt() + 1);
			stmt.setString(2, l.getLunRestaurant());
			
			ck = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return ck;
	}
	
	// menu delete
	public int menuDelete(Connection conn, String menu) {
		
		int ck = 0;
		PreparedStatement stmt = null;
		String sql = "delete from lunch where lun_restaurant = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menu);

			ck = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return ck;
	}
}
