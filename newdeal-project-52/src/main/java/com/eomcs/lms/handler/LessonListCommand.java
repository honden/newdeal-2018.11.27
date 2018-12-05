package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import Dao.LessonDao;
@Component("/lesson/list")
public class LessonListCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonListCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {
      List<Lesson> list = lessonDao.findAll();

      for (Lesson lesson : list) {
        System.out.printf("%3d, %-20s, %s, ~, %s, %d, %d\n", 
            lesson.getNo(), 
            lesson.getTitle(),
            lesson.getStartDate(),
            lesson.getEndDate(),
            lesson.getTotalHours(), 
            lesson.getDayHours());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}