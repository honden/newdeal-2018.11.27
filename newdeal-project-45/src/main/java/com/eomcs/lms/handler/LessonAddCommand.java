package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonAddCommand implements Command {

  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard ) {
    this.keyboard = keyboard;
  }

  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      System.out.print("제목? ");
      String title = keyboard.nextLine();
      System.out.print("내용? ");
      String content = keyboard.nextLine();
      System.out.print("시작날짜[년월일을 붙여쓰시오.ex)20180101]? ");
      String sdt = keyboard.nextLine();
      System.out.print("종료날짜[년월일을 붙여쓰시오.ex)20180101]? ");
      String edt = keyboard.nextLine();
      System.out.print("총수업시간? ");
      String thr = keyboard.nextLine();
      System.out.print("일수업시간? ");
      String dhr = keyboard.nextLine();
      System.out.print("매니저(넘버)? ");
      String mno = keyboard.nextLine();

      DriverManager.registerDriver(new Driver());

      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");

      stmt =con.createStatement();

      //sql문 서버전송 => 서버에서 결과를 가져올 일을 할 객체 리턴
      stmt.executeUpdate("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values('"
          + title +"',"
          + content +","
          + sdt +","
          + edt +","
          + thr +","
          + dhr +","
          + mno +")");

      //dbms에서 한개의 레코드를 가져온다.
      System.out.printf("입력했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      try {stmt.close();}catch(Exception e) {}
      try {con.close();}catch(Exception e) {}
    }
  }
}
