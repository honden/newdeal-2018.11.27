package com.eomcs.lms.handler;

import java.util.Scanner;
import Dao.BoardDao;

public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardListCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {
    }
  }

