package mega.backend_onemore._230331;

/*
참고할 만한 상황이 뭐냐면
primitive 타입에서는 값을 전달하는 방법이 return밖에 없으니까
무조건 return을 했어야 했다.
아래처럼...

그런데, 객체 세상에서는 changeName(Person person) 내부에서의 변화가
return을 쓰지 않더라도, 내가 Person person만 바꿔도 외부로 영향이 가지.
  즉,
  static void changeName(Person person) {
    person.name = "B";
  }
이렇게만 해도 된다는 이야기.

즉, 메서드의 인자가 primitive 타입이 아니라 클래스(참조자료형) 이면
내가 얘를 리턴해서 쓰지 않고도 값과 상호작용이 가능하다는 이야기.

주소값을 참조해서 원본에 손을 댈 수 있는 상황이 되니까.
return을 넘기지 않아도 인자를 넘김으로써 이 값 자체가 수정이 가능하다는 이야기.
 */



class Person02 {
  String name;

}

public class CallByReference_02 {

  static Person changeName(Person person) {
    person.name = "B";

    return person;

  }

  public static void main(String[] args) {
    Person person = new Person();
    person.name = "A"; // 객체 생성 후 name을 변경

    changeName(person);

    System.out.println(person.name);
  }

}
