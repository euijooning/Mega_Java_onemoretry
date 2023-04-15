package mega.backend_onemore._230331;

class Person {
  String name;

}

public class CallByReference_01 {

  static void changeName(Person person) {
    person.name = "B";

    System.out.println(person.name); //B 출력

  }

  public static void main(String[] args) {
    Person person = new Person();
    person.name = "A"; // 객체 생성 후 name을 변경

    changeName(person);

    System.out.println(person.name); // **B 출력
  }
}
/*
먼저 동일하게 main을 위한 공간과 changeName 을 위한 공간이 생긴다.
그리고 우리는 main에 대한 참조변수를 생성함. (main에 person 공간이 생성)
참조변수인 person 공간 안에는 무엇이 들어가냐? 바로 위치, 주솟값!(ex. 100번지)
이 위치는 person 객체의 위치!

person 객체의 위치는 new를 통해서 만들었기 때문에, 이런 동적인 메모리는
Heap이라는 공간에 저장됨. Heap에 person이 만들어진다는 소리다.
그리고 이 사람이 있는 위치가 100번지라는 말이다.

changeName에 매개변수로 person을 갖다주면 chqngeName에도 person의 공간이 하나 만들어진다.
그럼 여기서 만들어진 person과 main에서 만들어진 person은 다른 게 확실하다.(완전 독립적, 남남)

그런데, 이것 역시 call by value라고 인지를 하면,
call by value 에서는 값이 복사가 되었지.
따라서 changeName의 공간의 person에도 100번지(=값)가 똑같이 복사가 된다.(값이 복사되었다고 생각하세요)

그럼 main과 changeName()은 값이 다 들어와 있고, 별개의 변수도 있는 상태가 됨.
그런데 여기서 person.name을 'B'로 바꾼다는 게 뭐냐면,
어차피 얘(changeName에 있는 person)가 참조변수잖아. 이 person을 지지고 볶고 하는 게 아니라,
Heap에 있는 위치(100번지)를 찾아가는 것이다.
그리고 얘(heap에 있는 것)의 이름을 B로 바꾸는 것.
이게 changeName()에서 일어난 일이다.

그리고 이 메서드가 끝나면 얘가 없어지고 person도 날아간다.

이제 남은 main을 보면,
여기서도 출력할 때, person.name을 했죠.
따라서 main에서도 Heap에 있는 위치(100번지) 를 똑같이 찾아간다.
그럼 Heap에는 이미 이름이 B로 변경되어 있는 상태이다(아까 했으니까)

그래서 main에서의 변화도 밖에서도 보이는 것이다.

----------------------------------------------------------------------------------
사실상 자바에서는 모두 call by Value라고 봐도 될 것 같다.
다만, 그 복사되는 것이 primitive 타입이냐, 참조형이냐에 따라서 달라짐.
전자는 값이 복사되는 것이고, 후자는 위치(주소)가 복사되는 것.
주소면, 주소가 복사가 되는데 이것은 '원본'의 주소이기 때문에
원본을 변화시킬 수 있다.
그래서 함수에서의 변화가 바깥에서도 보이는 것.
값과 주소의 차이만 인지하고 있으면
사실상 두 개의 매커니즘은 동일한 것으로 인지해도 무방하다.
 */

