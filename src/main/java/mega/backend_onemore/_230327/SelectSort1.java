package mega.backend_onemore._230327;

public class SelectSort1 {

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
  }

}
