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
//  �ֹ��ð��� sql insert�ÿ� �ڵ����� ������ �ð��� �Էµǵ��� �߽��ϴ�.
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
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
//			���� �� ������ �˻��Ѵ�.
			String sql = "select ordernum, menu, sum(quantity) as quantity, sum(price) as psum from sales group by ordernum, menu";
			rs =  stmt.executeQuery(sql);
			int totalprice = 0;
			while (rs.next()) {
				totalprice += rs.getInt("psum");
			}
			System.out.println("�� ����: "+totalprice+"��");
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
//		�ش� �޼����  ��� ���⿡���� ���� �������ݴϴ�.
		Connection conn = DBUtill.getMySqlConnection();
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = conn.createStatement();
//			���� �� ������ �˻��Ѵ�.
			String sql = "select ordernum, menu, quantity, sum(price) as psum from sales group by ordernum, menu";
			rs =  stmt.executeQuery(sql);
			System.out.println("�ֹ���ȣ\t�޴�\t\t����\t�հ�");
			while (rs.next()) {
				System.out.println(rs.getInt("ordernum")+"\t"+rs.getString("menu")+"\t\t"+
			rs.getInt("quantity")+"\t"+rs.getInt("psum"));
			}
			totalPrice();
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
//			����� new Sales(�ֹ���ȣ, ����, �ֹ�����, �޴��̸�).Insert();
			String sql = "insert into sales(ordernum, price, quantity, menu) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernum);
			pstmt.setInt(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, menu);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtill.close(conn);
		}
	}
	public void Delete() {
		//��Ʈ�Ѵܿ��� �����ͻ����� ��û�ϸ� �����մϴ�.
		//�����ڸ� ������ �Ѱܹ޴� �ֹ���ȣ�� �ش��ϴ� �����͸� ���� ����_������� ������ ���� �ڵ�
		Connection conn = DBUtill.getMySqlConnection();
		PreparedStatement pstmt = null;
		try {
//			����� new Sales().Delete(�ֹ���ȣ);
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
