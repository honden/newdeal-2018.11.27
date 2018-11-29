import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Lesson[] lessons = new Lesson[LENGTH];
    Member[] members = new Member[LENGTH];
    Board[] boards = new Board[LENGTH];
    
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
      } else if(command.equals("/member/add")) {
        Member member = new Member();
        
        System.out.print("번호? ");
        member.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("이름? ");
        member.name = keyboard.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyboard.nextLine();
        
        System.out.print("암호? ");
        member.password = keyboard.nextLine();
    
        System.out.print("사진? ");
        member.photo = keyboard.nextLine();
    
        System.out.print("전화? ");
        member.tel = keyboard.nextLine();
    
        member.registeredDate = new Date(System.currentTimeMillis()); 
        
        members[i] = member;
        i++;
      }else if(command.equals("/member/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[j].no, members[j].name, members[j].email, 
              members[j].tel, members[j].registeredDate);
        }
      }else if(command.equals("/board/add")) {
        Board board = new Board();
        
        System.out.print("번호? ");
        board.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("내용? ");
        board.contents = keyboard.nextLine();
        
        board.createdDate = new Date(System.currentTimeMillis()); 
        
        board.viewCount = 0;
        
        boards[i] = board;
        i++;
      }else if(command.equals("/board/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-20s, %s, %d\n", 
              boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
        }
      }else {
        System.out.println("유효하지 않은 명령어입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }
}
