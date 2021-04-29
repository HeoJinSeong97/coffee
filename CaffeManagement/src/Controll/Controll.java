package Controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.DBUtill;
import Model.Sales;

public class Controll {
   Connection connection = null;
   Statement statement = null;
   ResultSet resultSet = null;

   Controll() {connection = DBUtill.getMySqlConnection();
//   String DName = "com.mysql.jdbc.Driver";
//
//   try {
//      Class.forName(DName);
//
//      String url = "jdbc:mysql://192.168.55.5:3306/coffeemanagement";
//      String user = "coffee";
//      String password = "0000";
//
//      connection = DriverManager.getConnection(url, user, password);
//      statement = connection.createStatement();
//      System.out.println("DB연동 성공");          //확인용 실제 실행시 주석처리 바람
//   } catch (Exception e) {
//      e.printStackTrace();
//   }

   }

   public void showMenuTable() {      //메뉴 테이블 전체 Show
      if (tableIsEmpty("menu")) {
         String sql="select * from menu";
         try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               System.out.println("메뉴 : " + resultSet.getString(1) + " 가격 : " + resultSet.getInt(2) + " info : "
                     + resultSet.getString(3) + " 재고 : " + resultSet.getInt(4));
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }else {
         System.out.println("테이블에 값이 없습니다.");
      }
   }
   public void showSalesTable() {   //매출 관리 테이블 전체 Show
//      if (tableIsEmpty("sales")) {
//         String sql="select * from sales";
//         try {
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//               System.out.println("orderIdx : " + resultSet.getInt(1) + "Ordernum : " + resultSet.getInt(2) + " Price : "
//                     + resultSet.getInt(3) + " quantity : " + resultSet.getInt(4)+" orderdate : "+resultSet.getDate(5));
//            }
//         } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//      }else {
//         System.out.println("테이블에 값이 없습니다.");
//      }
	   new Sales().Select();
	   
   }
   public void showCustomerTable() {      //고객 테이블 전체 Show
      if (tableIsEmpty("customer")) {
         String sql="select * from customer";
         try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               System.out.println("ordernum : " + resultSet.getInt(1) + " menu : " + resultSet.getString(2) + " price : "
                     + resultSet.getInt(3) + " quantity : " + resultSet.getInt(4));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }else {
         System.out.println("테이블에 값이 없습니다.");
      }
   }
   
   public void insertMenu(String menuName, int price, String info, int remain) {      //admin이 메뉴 추가할때 사용하는함수
      String sql = "insert into menu values('"+menuName+"', "+price+", '"+info+"', "+remain+")";
      try {
         statement.executeUpdate(sql);
         System.out.println("메뉴 추가 성공");      // 메뉴 추가 확인용 실제 실행시 주석 및 삭제 바람
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public void insertSales(int ordernum, int price, int quantity, String menu) {      //customer이 메뉴 주문 할 때 사용하는 함수
//      String sql = "insert into sales(ordernum,price,quantity,orderdate) values("+ordernum+", "+price+", "+quantity+", '"+orderdate+"')";
//      try {
//         statement.executeUpdate(sql);
//         System.out.println("매출관리 테이블 추가 성공");      // 매출관리테이블 추가 확인용 실제 실행시 주석 및 삭제 바람
//      } catch (SQLException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
	   new Sales(ordernum, price, quantity, menu).Insert();
   }
   public void insertCustomer(String menu, int price, int quantity) {      //admin이 메뉴 추가할때 사용하는함수
      String sql = "insert into Customer values('"+menu+"', "+price+", "+quantity+")";
      try {
         statement.executeUpdate(sql);
         System.out.println("주문 추가 성공");      // 고객 주문테이블 추가 확인용 실제 실행시 주석 및 삭제 바람
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void deleteMenu(String menu) {               //admin 메뉴 삭제
      String sql="delete from menu where menu="+menu;
      try {
         statement.executeUpdate(sql);
         System.out.println("메뉴 :"+menu+" 삭제 성공");         //삭제 여부 확인 실제사용시 주석 및 삭제바람
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public void deleteCustomer(int ordernum) {            //주문 완료 및 삭제시 고객 테이블의 주문 삭제
      String sql="delete from customer where customerordernum = "+ordernum;
      try {
         statement.executeUpdate(sql);
         System.out.println("customer 테이블의 주문 삭제 완료");       //주문 삭제 확인 메세지 실제사용시 삭제 및 주석 바람
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public void selectBetweenDate(String date1,String date2) {   //기간사이의 매출관리 테이블 보여주는 함수 date는 String타입으로 YYYY-MM-DD형식으로 바람
      String sql="select * from sales where orderdate between '"+date1+" 00:00:00' and '"+date2+" 23:59:59'";
      try {
         resultSet=statement.executeQuery(sql);
         while(resultSet.next()) {
            System.out.println("orderIdx : " + resultSet.getInt(1) + "Ordernum : " + resultSet.getInt(2) + " Price : "
                  + resultSet.getInt(3) + " quantity : " + resultSet.getInt(4)+" orderdate : "+resultSet.getDate(5));
            System.out.println("확인 메세지");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }

   public boolean tableIsEmpty(String tableName) { // 테이블이 비었는지 확인하는 함수
      boolean isEmpty = true;
      String sql = "select * from " + tableName;
      try {
         resultSet = statement.executeQuery(sql);
         if (resultSet.next())
            isEmpty = false;
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return isEmpty;
   }
   
   
   public void close() {                     // 종료 함수 마지막에 꼭 첨부해야함
      try {
         resultSet.close();
         statement.close();
         connection.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         System.out.println("종료");
      }
   }
}