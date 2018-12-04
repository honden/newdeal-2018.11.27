package com.eomcs.lms.handler;

import java.sql.DriverManager;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import Dao.BoardDao;

public class BoardDetailCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;
  public BoardDetailCommand(Scanner keyboard,BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    DriverManager.registerDriver(new Driver());
    if(Board board) {
      boarSystem.out.printf("번호 : %d\n",rs.getInt("bno"));
      System.out.printf("내용 : %s\n",rs.getString("cont"));
      System.out.printf("작성일 : %s\n",rs.getDate("cdt"));
      System.out.printf("조회수 : %d\n",rs.getInt("view"));
      System.out.printf("작성자 : %d\n",rs.getInt("mno"));
      System.out.printf("수업 : %d\n",rs.getInt("lno"));
    }else {
      System.out.printf("해당 번호의 게시물이 없습니다!");
    }
  }catch (Exception e){
    e.printStackTrace();
  }finally {
    try {rs.close();}catch(Exception e) {}
    try {stmt.close();}catch(Exception e) {}
    try {con.close();}catch(Exception e) {}
  }
}
}
