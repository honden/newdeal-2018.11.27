/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.newdeal.lms;

import java.util.Date;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      Date date;
      int s =0;
      
      System.out.print("번호?");
      int no = Integer.parseInt(keyIn.nextLine());
      
      System.out.print("내용?");
      String contents = keyIn.nextLine();
      
      date = new Date();      
      
      keyIn.close();
      
      System.out.printf("번호: %s%n",no);
      System.out.printf("내용: %s%n",contents);
      System.out.printf("작성일: %s%n",date);
      System.out.printf("조회수: %s%n",s);
      
    }
}
