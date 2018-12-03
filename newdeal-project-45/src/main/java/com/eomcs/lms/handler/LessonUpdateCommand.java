package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");
      
      stmt =con.createStatement();
      
      System.out.print("게시물번호? ");
      String no = keyboard.nextLine();

      ResultSet rs = stmt.executeQuery(
          "select title, cont from lesson where lno = "+no);
      rs.next();
      String oldTitle = rs.getString("title");
      String oldContent = rs.getString("cont");
      rs.close();
      
      System.out.printf("제목(%s)? ", oldTitle);
      String title = keyboard.nextLine();
      System.out.printf("내용(%s)? ", oldContent);
      String content = keyboard.nextLine();
      System.out.printf("시작날짜? ");
      String sdt = keyboard.nextLine();
      System.out.printf("종료날짜? ");
      String edt = keyboard.nextLine();
//      System.out.printf("총시간? ");
//      String thr = keyboard.nextLine();
//      System.out.printf("일시간? " );
//      String dhr = keyboard.nextLine();
      System.out.printf("매니져? ");
      String mno = keyboard.nextLine();


      //sql문 서버전송 => 서버에서 결과를 가져올 일을 할 객체 리턴
      stmt.executeUpdate("update lesson set "
          + "title='"+ title 
          + "', cont='"+ content 
          + "', sdt='"+ sdt 
          + "', edt='"+ edt 
//          + "', thr='"+ thr 
//          + "', dhr='"+ dhr
          + "', mno="+ mno
          + " where lno="+ no);

      //dbms에서 한개의 레코드를 가져온다.
      System.out.println("변경했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      try {stmt.close();}catch(Exception e) {}
      try {con.close();}catch(Exception e) {}
    }

  }
}
