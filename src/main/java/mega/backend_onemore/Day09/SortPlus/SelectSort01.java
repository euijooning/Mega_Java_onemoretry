package mega.backend_onemore.Day09.SortPlus;

public class SelectSort01 {

  public static void main(String[] args) {

    int[] a = new int[100_000];
    int cnt1 = 0; // 반복횟수 비교를 위해 일부러 선언

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        cnt1++;
        if (a[i] < a[j]) {
          // swap
          int temp = a[j];
          a[j] = a[i];
          a[i] = temp;
        }
      }
    }

    int cnt2 = 0; // 반복횟수 비교를 위해 일부러 선언 22
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        cnt2++;
        if (a[i] > a[j]) {
          int temp = a[j];
          a[j] = a[i];
          a[i] = temp;
        }
      }
    }

    System.out.println("순진하게 구현했을 때(cnt1) : " + cnt1);
    System.out.println("============");
    System.out.println("불필요한 비교를 뺐을 때(cnt2) : " + cnt2);

//    // 오름차순 정렬:
//    // 아래의 과정을 원소의 개수 만큼 반복한다:
//    int[] numbers = {13, 46, 24, 52, 20, 9};
//    for (int i = 0; i < numbers.length; i++) {
//      // 지금 정렬할 자리를 지정한다 -> i
//      // i를 기준으로 오른쪽을 보면서 가장 작은 값을 찾는다
//      int min = 100;
//      int minIndex = -1;
//      for (int j = i + 1; j < numbers.length; j++) {
//        if (min > numbers[j]) {
//          min = numbers[j];
//          minIndex = j;
//        }
//      }
//
//      if (minIndex == -1) {
//        continue;
//      }
//
//      // 가장 작은 값과 지금 정렬할 자리를 swap
//      int temp = numbers[i];
//      numbers[i] = numbers[minIndex];
//      numbers[minIndex] = temp;
//    } // -> 하나의 숫자가 정렬이 됨
//
//    System.out.println(Arrays.toString(numbers));
  }

}

