package Model;

import java.sql.Connection;
import java.sql.ResultSet;

public class DBTest implements SQLControll{

	public static void main(String[] args) {
		// sql���� ���� �ʿ�� �����.
		Connection conn = DBUtill.getMySqlConnection();
//		
//		�����۾���
		
//		DB��������
		DBUtill.close(conn);
	}

	@Override
	public ResultSet Select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		
	}

}
