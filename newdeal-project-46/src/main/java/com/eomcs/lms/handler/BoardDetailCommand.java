package com.eomcs.lms.handler;

import java.sql.DriverManager;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;
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
      board.getNo(rs.getInt("bno"));
      board.getContents(rs.getString("cont"));
      board.getCreatedDate(rs.getDate("cdt"));
      board.getViewCount(rs.getInt("view"));
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
