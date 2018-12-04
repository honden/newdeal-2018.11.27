package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonDetailCommand implements Command {

  Scanner keyboard;

  public LessonDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
      
      stmt = con.createStatement();
      
      rs = stmt.executeQuery( "select lno, title, cont, sdt, edt, tot_hr from lesson where lno = "+ no);

      //dbms에서 한개의 레코드를 가져온다.
      rs.next();
        System.out.println("번호 : "+rs.getInt("lno"));
        System.out.println("주제 : "+rs.getString("title"));
        System.out.println("내용 : "+rs.getString("cont"));
        System.out.println("기간 : "+rs.getDate("sdt")+" ~ "+rs.getDate("edt"));
        System.out.println("총시간 : "+rs.getInt("tot_hr"));
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      try {rs.close();}catch(Exception e) {}
      try {stmt.close();}catch(Exception e) {}
      try {con.close();}catch(Exception e) {}
    }
  }
}
