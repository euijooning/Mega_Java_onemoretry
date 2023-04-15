package mega.backend_onemore.Day09.SortPlus;

public class SelectSortSample {


    public static void main(String[] args) {

      // 오름차순 정렬
      // 아래 과정을 원소의 개수 만큼 만복한다.
      // 지금 정렬할 자리를 지정한다.
      // 지금 정렬할 자리를 기준으로 오른쪽을 보면서 가장 작은 값을 찾는다.
      // 가장 작은 값과 지금 정렬할 자리를 swqp
      // > 하나의 숫자가 정렬이 된다.

      int[] numbers = {13, 46, 24, 52, 20, 9};
      // 오름차순 정렬
      // 아래 과정을 원소의 개수 만큼 만복한다.
      for (int i = 0; i<numbers.length; i++) {
        // 지금 정렬할 자리를 지정한다. => i
        // 지금 정렬할 자리를 기준으로 오른쪽을 보면서 가장 작은 값을 찾는다. => for문

        int min = 100; // 최솟갑을 찾을 것이므로 최대한 큰 수를 처음에 상정
        // 값이 중요한 게 아니라, 사실 우리는 위치를 찾으려고 하는 것이므로, 위치도 중요.
        int minIndex = -1;

        for (int j = i+1; j<numbers.length; j++) {
          if (min > numbers[j]) {
            min = numbers[j]; // 값 대입
            minIndex = j; // 인덱스도 업데이트
          }
        }

        // 그런데, 여기서 하나 문제가 생김. 내가 최솟값이면 어떡해?
        // 그 경우 한번 고려해줘야 한다.
        if (minIndex == -1) {
          continue; // 건너뛴다.
        }

        // 가장 작은 값과 지금 정렬할 자리를 swqp
        // 임시변수 하나 생성하고 값 대입하고 서로 바꾸는 절차를 기억하라

        // 지금 우리는 numbers[i] <-> numbers[minIndex] 하려고 한다.
        int temp = numbers[i];
        numbers[i] = numbers[minIndex];
        numbers[minIndex] = temp; // 치환 완료됨.
        // > 하나의 숫자가 정렬이 된다,
      }

      // 츌력
      //System.out.println(Arrays.toString(numbers)); //훨씬 간단해짐.

      for (int i = 0; i< numbers.length; i++) {
        System.out.println(numbers[i]);
      }
    }

  }


