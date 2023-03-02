package com.bit.ajax.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.BitSql;

public class ListDao {
   Connection conn;
   Statement stmt;
   ResultSet rs;
   PreparedStatement pstmt;
   
   public ListDto getOne(int num) {
//	   System.out.println(num);
//	   PreparedStatement pstmt=null;
      String sql="select * from list where num="+num;
      ListDto bean = new ListDto();
      try {
         conn = BitSql.getConnection();
         pstmt= conn.prepareStatement(sql);
         rs=pstmt.executeQuery(sql);
         if(rs.next()) {
//        	 System.out.println("listdao"+rs.getString("num"));
        	bean.setNum(rs.getInt("num"));
            bean.setSubject(rs.getString("subject"));
            bean.setContent(rs.getString("content"));
            bean.setDate(rs.getDate("date"));
         }
      } catch (SQLException e) {
      e.printStackTrace();
   }finally {
      
            try {
               if(rs!=null)rs.close();
               if(pstmt!=null)pstmt.close();
               if(conn!=null)conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
      
      }
            
            return bean;
      
   }
   
   public void insertOne(String subject, String content) {
	   System.out.println(subject);
	   System.out.println(content);
	   Connection conn = null;
	   PreparedStatement pstmt=null;
	   System.out.println("dddd");
	   System.out.println(conn);
//	   String sql = "insert into list values(?,?,?,now(),?)";
         String sql = "insert into list(subject,content,date)  values(?,?,now())";
//	   String sql="insert into list (subject,content) value ('";
//		sql+=subject+"','"+content+"')";
         try {
//            stmt=conn.createStatement();
//			stmt.executeUpdate(sql);
            
        	conn = BitSql.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, subject);
            pstmt.setString(2, content);
            
            System.out.println(pstmt);
//            pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            
            pstmt.executeUpdate();
            System.out.println("업데이트완료");
         } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("catch");
//            return 0;
         }finally {
            
            try {
               if(pstmt!=null)pstmt.close();
               if(conn!=null)conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
            
         }
      }
   
   public List<ListDto> getList() {
	  System.out.println("getlistdao");
//	  PreparedStatement pstmt=null;
      String sql = "select * from list order by num desc";
      List<ListDto> list = new ArrayList<ListDto>();
      try {
         conn = BitSql.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery(sql);
         
         while(rs.next()) {
            ListDto bean = new ListDto();
            bean.setNum(rs.getInt("num"));
            bean.setSubject(rs.getString("subject"));
            bean.setContent(rs.getString("content"));
//            bean.setDate(rs.getTimestamp("date"));
            bean.setDate(rs.getDate("date"));
            bean.setReadcount(rs.getInt("readcount"));
            
            list.add(bean);
         }
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
      return list;
   }

	public void update(int num, String subject, String content) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql = "update list set subject=?, content=?, date=now() where num=?";
        try {
        	conn = BitSql.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
		}
        
				
	}

	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql = "delete from list where num = ?";
        try {
        	conn = BitSql.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
		}
		
	}

	public void readCount(int num) {
		System.out.println("num"+num);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update list set readcount=readcount+1 where num=?";
//		update gallary set readcount=readcount+1 where num=?
		try {
			
			conn=BitSql.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
//			System.out.println("readcountdao=="+pstmt.executeUpdate());
			System.out.println(pstmt);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
			if(conn!=null) try{conn.close();}catch(SQLException ex) {}
			
		}
		
	}
	
	
	
	
	
	
	
	
}
