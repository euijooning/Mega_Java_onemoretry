package mega.backend_onemore.Day30;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EXTime {

  public static void main(String[] args) {

    LocalDate d = LocalDate.now();
    LocalTime t = LocalTime.now();
    LocalDateTime dt = LocalDateTime.now();

    System.out.println("오늘 날짜 => " + d);
    System.out.println("오늘 시간 => " + t);
    System.out.println("오늘 날짜와 시간 => " + dt);

    String total = dt.getYear() + "년 ";
    total += dt.getMonthValue() + "월 ";
    total += dt.getDayOfMonth() + "일 ";
    total += dt.getDayOfWeek() + " ";
    total += dt.getHour() + "시 ";
    total += dt.getMinute() + "분 ";
    total += dt.getSecond() + "초 ";

    System.out.println();

    System.out.println(total);

    System.out.println();
    System.out.println("오늘부터 300일 기념일 : " + d.plusDays(300));
    System.out.println("오늘부터 12주 후의 날짜 : " + d.plusWeeks(12));

    System.out.println();

    LocalDate ld = LocalDate.of(2002, 12, 19);
    System.out.println("그날부터 900일 기념일 : " + ld.plusDays(900));
    System.out.println("그날부터 52주 후의 날짜 : " + ld.plusWeeks(52));

  }
}
