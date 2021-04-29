package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sales{
	private int ordernum;
	private int price;
	private int quantity;
	private String menu;
	public Sales() {}
	public Sales(int ordernum) {this.ordernum = ordernum;}
	public Sales(int ordernum, int price, int quantity, String menu) {
		this.ordernum = ordernum;
		this.price = price;
		this.quantity = quantity;
		this.menu = menu;
	}
	
	public void totalPrice() {
		Connection conn = DBUtill.getMySqlConnection();
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = conn.createStatement();
//			오늘 총 매출을 검색한다.
			String sql = "select ordernum, menu, quantity, sum(price) as psum from sales order by ordernum, menu";
			rs =  stmt.executeQuery(sql);
			int totalprice = 0;
			while (rs.next()) {
				totalprice += rs.getInt("psum");
			}
			System.out.println("총 매출: "+totalprice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				DBUtill.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void Select() {
//		해당 메서드는  모든 매출에대해 값을 전달해줍니다.
		Connection conn = DBUtill.getMySqlConnection();
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = conn.createStatement();
//			오늘 총 매출을 검색한다.
			String sql = "select ordernum, menu, quantity, sum(price) as psum from sales order by ordernum, menu";
			rs =  stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("ordernum")+" "+rs.getString("menu")+" "+
			rs.getInt("quantity")+" "+rs.getInt("psum"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				DBUtill.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void Insert() {
		// TODO Auto-generated method stub
		Connection conn = DBUtill.getMySqlConnection();
		PreparedStatement pstmt = null;
		try {
//			사용방법 new Sales(주문번호, 가격, 주문수량, 메뉴이름).Insert();
			String sql = "insert into sales(ordernum, price, quantity, menu) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernum);
			pstmt.setInt(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, menu);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtill.close(conn);
		}
	}
	public void Delete() {
		//컨트롤단에서 데이터삭제를 요청하면 실행합니다.
		//생성자를 생성해 넘겨받는 주문번호에 해당하는 데이터를 전부 삭제_사용하지 않을것 같은 코드
		Connection conn = DBUtill.getMySqlConnection();
		PreparedStatement pstmt = null;
		try {
//			사용방법 new Sales().Delete(주문번호);
			String sql = "delete from sales where ordernum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernum);
		
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				pstmt.close();
				DBUtill.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
