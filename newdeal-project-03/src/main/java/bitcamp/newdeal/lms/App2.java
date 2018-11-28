package bitcamp.newdeal.lms;

import java.util.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    final int size = 20;

    int[] no = new int[size];
    String[] name = new String[size];
    String[] email = new String[size];
    int[] password = new int[size];
    String[] p = new String[size];
    String[] pn = new String[size];
    Date[] date = new Date[size];
    int len=0;
    
    for(int i=0;i<size;i++) {
      System.out.print("번호?");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("이름?");
      name[i] = keyIn.nextLine();

      System.out.print("이메일?");
      email[i] = keyIn.nextLine();

      System.out.print("암호?");
      password[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("사진?");
      p[i] = keyIn.nextLine();

      System.out.print("전화?");
      pn[i] = keyIn.nextLine();

      date[i] = new Date();
      len++;
      
      System.out.print("계속하시겠습니까?(Y/n)");
      String anser = keyIn.nextLine();

      if(anser.equals("")||anser.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();
    //출력: 번호 이름 이메일 전화 가입일

    for(int i = 0; i<len;i++) {
      System.out.printf("%d,%s,%s,%s,%s%n",no[i],name[i],email[i],pn[i],date[i]);
    }
  }
}
