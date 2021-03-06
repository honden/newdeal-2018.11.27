package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import Dao.BoardDao;
@Component("/board/list")
public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;

  public BoardListCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {
    try {
      List<Board> list = boardDao.findAll();

      for (Board board : list) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), 
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

