package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler l = new LessonHandler(keyboard);
    MemberHandler m = new MemberHandler(keyboard);
    BoardHandler b1 = new BoardHandler(keyboard);
    BoardHandler b2 = new BoardHandler(keyboard);
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        l.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        l.listLesson();
      
      } else if (command.equals("/member/add")) {
        m.addMember();
        
      } else if (command.equals("/member/list")) {
        m.listMember();
        
      } else if (command.equals("/board/add")) {
        b1.addBoard();
        
      } else if (command.equals("/board/list")) {
        b1.listBoard();
        
      } else if (command.equals("/board2/add")) {
        b2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        b2.listBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
