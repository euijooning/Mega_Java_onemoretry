package mega.backend_onemore.Day24.Prac24;

import java.util.Random;

class FishFeed02 {

}

class FireShark02 {
  String name;
  FishFeed02[] ff;

  FireShark02(String name,int max) {
    this.name = name;
    ff = new FishFeed02[max];
    //System.out.println(max);
  }

  void eat(FishFeed02 f)   {
    int count = 0;
    while(ff[count] != null)
    {
      count++;
    }

    ff[count] = f;
  }

  int eat() {

    int count = 0;
    while(count<ff.length&&ff[count] != null)
    {
      count++;
    }

    return count;
  }


  void print()   {
    int temp=eat();
    System.out.println(this.name+"상어는 "+temp+"마리 만큼 잡아먹었습니다.");
  }

}


public class Q1_2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    FishFeed02[] ff = new FishFeed02[100];

    int fishCount = 0;

    Random r = new Random();

    for(int i = 0;i<100;i++)     {
      ff[i] = new FishFeed02();
    }

    FireShark02[] fs = new FireShark02[5];

    for(int i = 0;i<5;i++) {

      int temp =r.nextInt(7)+8;
      fs[i] = new FireShark02(Integer.toString((i+1)),temp);
    }


    for(int i = 0;i<5;i++) { //상어 5마리

      for(int j = 0;j<fs[i].ff.length;j++) { //상어가 먹을수 있는 물고기 배열 수만큼

        fs[i].eat(ff[fishCount++]);
        ff[fishCount-1] = null;
      }
      fs[i].print();
    }
  }

}


