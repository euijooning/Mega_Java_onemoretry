package mega.backend_onemore.Day28;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MapTest1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("보 바위 가위 선택하세요 : ");
        //String user = sc.next();
        int user = sc.nextInt();

        int com = r.nextInt(3); // 0~2

        HashMap<Integer, String> comMap = new HashMap<>();
        //Map에 값을 집어넣기
        comMap.put(0,"보");
        comMap.put(1,"바위");
        comMap.put(2,"가위");

        // 값 꺼내서 결과 출력
        //System.out.println("User : " + user +", Com : "+comMap.get(com));
        System.out.println("User : " + comMap.get(user)+", Com : "+comMap.get(com)); //  숫자입력하면 알아서 문자로 바꿔줌.
    }
}
