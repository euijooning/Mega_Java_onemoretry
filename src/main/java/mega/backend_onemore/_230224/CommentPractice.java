package mega.backend_onemore._230224;

interface Parent{
  void m2();
}
interface  GrandParent{
  void m1();
}
/*
class MyService implements Comment{
  // 얘가 구현해야 하는 메서드의 수는? 총 5개!
}

 */

public interface CommentPractice extends Parent, GrandParent{
  void createComent(Long boardId);
  void updateComent(Long boardId, Long commentId);
  void deleteComent(Long commentId);


}

