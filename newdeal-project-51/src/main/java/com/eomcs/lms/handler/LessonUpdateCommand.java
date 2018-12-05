package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import Dao.LessonDao;
@Component("/lesson/update")
public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {
      System.out.print("게시물번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      Lesson lesson = lessonDao.findByNo(no);

      System.out.printf("제목(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());
      System.out.printf("내용(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());
      System.out.printf("시작날짜(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());
      System.out.printf("종료날짜(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());
      System.out.printf("총시간(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());
      System.out.printf("일시간(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());

      lessonDao.update(lesson);

      System.out.println("변경했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
