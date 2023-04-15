package mega.backend_onemore.MakeStar;

public class Star04_Kang {
  public static void main(String[] args) {
    /*
    일단 피라미드를 그리려면 모양을 쪼개서 살펴보자
    왼쪽 직각삼각형과 오른쪽 직각삼각형
    혹은 가운데를 기준으로 왼쪽과 오른쪽에 하나씩 더 찍어주면, 완성이 된다 뭐 요런 느낌으로다가.
     */

    //4.피라미드
    for (int i = 0; i < 5; i++) {  // 0 1 2 3 4
      for (int j = 4; j >= 0; j--) { // 4 3 2 1 0
        if (i < j) { //4 3 2 1 / 4 3 2 /4 3 / 4
          System.out.print(" ");
        } else { //0 / 1 0 / 2 1 0 / 3 2 1 0 / 4 3 2 1 0
          // 1 +2  3 5 7 9
          // 한 줄에 있는 모든 별을 찍는 for 문
          for (int k = 0; k <= i * 2; k++) {
            System.out.print("*");
          }
          break;
        }
      }
      System.out.println();
    }
    /*
    먼저 피라미드 1 설명
    for (int i = 0; i < 5; i++) {
    여기서 i=0 인 것은 크게 상관이 없어 보인다.
    바깥쪽 for문은 줄을 의미하는 것이고(행)
    안쪽 for문이 안에서 무엇을 찍을 것인가를 의미
    일단, 공백부터 봤을 때 첫줄 4 / 둘째 3 / 셋째 2 / 넷째 1 / 마지막 없음 => 공백이 계속 감소 중.
    i는 계속 바뀌지만, j는 항상 다섯이잖아.
    그럼 i에 대한 식으로 j도 나타낼 수 있나? 를 고민한다.
    공백은 자연스럽게 하나씩 줄어들게 하고 싶어요.
    i는 증가하니까, 그럼 i에 대한 식으로 공백을 나타낼 수 있을까를 고민.

     */
    // i: 0, 공백: 4, j:4~0 4 3 2 1
    // i: 1, 공백: 3, j:4~0 4 3 2
    // i: 2, 공백: 2, j:4~0 4 3
    // i: 3, 공백: 2, j:4~0 4
    // i: 4, 공백: 0 j: 4~0 / x
    // 즉, 규칙성 : i가 1증가 -> y는 1 씩 감소중.
    // 어 뭐야, 하나씩 보면, i가 0일때는 0보다 크고, i가 1일때는 1보다 크고
    // i가 2일 때는 2보다 크고, i가 3일 때는 3보다 크고, i가 4일 때는 4보다 커야ㅎ하므로,,, 없네!


    /*
    이제 별의 개수를 보자
    역시 j는 변하지 않으니까 변하고 있는 i에 대해서 식을 만들어보자.
    근데 보다보니까, j와 i의 연관 식으로 굳치 만들 필요가 없어.
    그냥 증가식 그 자체로 규칙성이 보이고 있잖아.
     */
    // i: 0, 별: 1, j:4~0
    // i: 1, 별: 3, j:4~0
    // i: 2, 별: 5, j:4~0
    // i: 3, 별: 7,
    // i: 4, 별: 9
    // 별의수 = i * 2 + 1

    // 0~5 -> 6
    // 1~5 -> 5

    // 0~i*2 -> i*2+1
    // break는 살짝 어색



    // 피라미드 2 수정
    /*
    break를 탈피하기 위해서...
    별을 찍는 건 공백이랑 상관없이 별만 잘 찍으면 되는 것 아니야? 에 대한 응답.
    앞선 코드에서 만약 break를 안 해줬다고 보면,
    일단 이 break는 두 번째 for문에 (j에) 걸린 break.
    그럼 공백을 i<j에만 찍고 아닐 때는 i>j인 경우에는 else에 걸려야 하는데, 그런 상황에서는 else에 있는 것이 몇 개가 될 줄 모른다.
              // 한 줄에 있는 모든 별을 찍는 for 문
          for (int k = 0; k <= i * 2; k++) {
            System.out.print("*");
          }
          지금 얘는 딱 한 번만 실행되어야 별이 5개가 나온다.
          그런데 break가 없으면 계속 걸리므로 5개씩 여러번이 찍힐 수 있다는 말.
          (잘은 모르겠지만, 일단 그렇게 받아들이자)


     */
    for (int i = 0; i < 5; i++) {  // 0 1 2 3 4
      for (int j = 4; j >= 0; j--) { // 4 3 2 1 0
        if (i < j) { //4 3 2 1 / 4 3 2 /4 3 / 4
          System.out.print(" ");
        }
      }
      for (int k = 0; k <= i * 2; k++) { // 좀 헷갈리니까. k<i*2+1 개라고 해도 무방함.(개수만 맞으면 되거든)
        System.out.print("*");
      }

      System.out.println();
    }
/*일단 피라미드 1과 피라미드 2의 차이는
for (int k = 0; k <= i * 2; k++) {
            System.out.print("*");
          }
  얘가 굳이 else 안에 들어있을 필요가 없다.
  그래서 뺐던 것.

  생각해보면 피라미드2 에서도 공백은 i가 j보다 작을 때만 찍으면 되는 것이고,
  그렇지 않은 경우에는 아무 일도 안 하면 되는데,
  굳이굳이굳이 피라미드2에서는 5번을 돌고 있다는 것.

  그래서 불필요함을 삭제하기 위해서
  피라미드 3에서는 for문 안에 있는 if를 전체 조건식으로 바꿔버리는 것이라고 생각하면 된다.
  매우 깔끔해졌음.
 */

    // 피라미드 3
    for (int i = 0; i < 5; i++) {  // 0 1 2 3 4
      for (int j = 4; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
