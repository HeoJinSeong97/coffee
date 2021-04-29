package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest{

	public static void main(String[] args) {
		// sql쿼리 실핼 필요시 사용방법.
		Connection conn = DBUtill.getMySqlConnection();
//		
//		쿼리작업란
//		new Sales(1, 12000, 2, "돌체 라떼").Insert();//확인완료
//		new Sales(1).Delete();//확인완료
		new Sales().Select();//확인완료
//		new Sales().totalPrice();//확인완료
		
//		DB연결해제
		DBUtill.close(conn);
	}
}
