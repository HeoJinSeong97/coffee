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
		new Sales().Select();//Ȯ�οϷ�
//		new Sales().totalPrice();//Ȯ�οϷ�
		
//		DB��������
		DBUtill.close(conn);
	}
}
