package mega.backend_onemore.Day30;

import java.util.Calendar;
import java.util.Date;

public class ExCalendar {

  public static void main(String[] args) {

    Calendar c = Calendar.getInstance();
    System.out.print(c.get(Calendar.YEAR)+ "년도 ");
    System.out.print(c.get(Calendar.MONTH)+1 + "월 "); //월을 나타내는 함수는 0부터 시작한대.
    System.out.print(c.get(Calendar.DATE) + "일 ");
    System.out.print(c.get(Calendar.HOUR) + "시 ");
    System.out.print(c.get(Calendar.MINUTE) + "분 ");
    System.out.print(c.get(Calendar.SECOND) + "초 ");
    System.out.println();
    Date date = c.getTime();
    System.out.println(date);
  }

}
