package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest{

	public static void main(String[] args) {
		// sql���� ���� �ʿ�� �����.
		Connection conn = DBUtill.getMySqlConnection();
//		
//		�����۾���
//		new Sales(1, 12000, 2, "��ü ��").Insert();//Ȯ�οϷ�
//		new Sales(1).Delete();//Ȯ�οϷ�
//		new Sales().Select();//Ȯ�οϷ�
//		new Sales().totalPrice();//Ȯ�οϷ�
//		new Menu().select();
		Customer c = new Customer();
		c.setOrdernum(1);
		c.setMenu("�Ƹ޸�ī��");
		c.setQuantity(2);
		c.setPrice(5400);
		String sql="insert into customer(ordernum,menu,price,quantity) values("+c.getOrdernum()
				+", '"+c.getMenu()+"', "+c.getPrice()+", "+c.getQuantity()+")";
		c.customerInsert(sql);
		
//		DB��������
		DBUtill.close(conn);
	}
}
