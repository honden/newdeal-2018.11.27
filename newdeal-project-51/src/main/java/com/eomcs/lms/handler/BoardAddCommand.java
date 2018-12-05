package com.eomcs.lms.handler;

import java.sql.DriverManager;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import Dao.BoardDao;
@Component("/board/add")
public class BoardAddCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardAddCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {
    try {
      Board board = new Board();
      
      System.out.print("내용? ");
      board.setContents(keyboard.nextLine());

      System.out.print("작성자번호? ");
      board.setWriterNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("수업번호? ");
      board.setLessonNo(Integer.parseInt(keyboard.nextLine()));

      DriverManager.registerDriver(new Driver());

      boardDao.insert(board);
      System.out.printf("입력했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
