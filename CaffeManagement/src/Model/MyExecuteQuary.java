package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyExecuteQuary {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	public MyExecuteQuary() {
		// TODO Auto-generated constructor stub
		conn = DBUtill.getMySqlConnection();
	}
	void customerInsert(String sql) {
//		insert�� ����
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public void myExecuteUpdate(String sql) {
	      Connection conn = DBUtill.getMySqlConnection();
	      try {
	         stmt = conn.createStatement();
	         stmt.executeUpdate(sql);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         DBUtill.close(conn);
	      }
	   }
	
	public void close() {                     // ���� �Լ� �������� �� ÷���ؾ���
	      try {
	         rs.close();
	         stmt.close();
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
//	         e.printStackTrace();
	      }finally {
	         System.out.println("����");
	      }
	   }
	}

