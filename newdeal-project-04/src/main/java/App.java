import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Lesson[] lessons = new Lesson[LENGTH];

    int i = 0;

    while (i < LENGTH) {

      System.out.println("명령>");
      String command = keyboard.nextLine();

      if(command.equals("quit")) {
        System.out.println("안녕!");
        break;
      }else if(command.equals("/lesson/add")) {
        lessons[i] = new Lesson();

        System.out.print("번호? ");
        lessons[i].no = Integer.parseInt(keyboard.nextLine());

        System.out.print("수업명? ");
        lessons[i].title = keyboard.nextLine();

        System.out.print("설명? ");
        lessons[i].contents = keyboard.nextLine();

        System.out.print("시작일? ");
        lessons[i].startDate = Date.valueOf(keyboard.nextLine());

        System.out.print("종료일? ");
        lessons[i].endDate = Date.valueOf(keyboard.nextLine());

        System.out.print("총수업시간? ");
        lessons[i].totalHours = Integer.parseInt(keyboard.nextLine());

        System.out.print("일수업시간? ");
        lessons[i].dayHours = Integer.parseInt(keyboard.nextLine());

        i++; // 배열의 인덱스를 증가시킨다.
      }else if(command.equals("/lesson/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              lessons[j].no, lessons[j].title, lessons[j].startDate,
              lessons[j].endDate, lessons[j].totalHours);
        }
      } else {
        System.out.println("유효하지 않은 명령어입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }
}
