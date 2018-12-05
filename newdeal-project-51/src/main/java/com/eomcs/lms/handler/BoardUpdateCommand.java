package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import Dao.BoardDao;
@Component("/board/update")
public class BoardUpdateCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;
  public BoardUpdateCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {
    try {
      System.out.print("게시물번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      Board board = boardDao.findByNo(no);
      
      System.out.printf("내용(%s)? ", board.getContents());
      board.setContents(keyboard.nextLine());

      boardDao.update(board);
      
      //dbms에서 한개의 레코드를 가져온다.
      System.out.println("변경했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
