package mega.backend_onemore._230317;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Login2Test {

  @Test
  @DisplayName("로그인 성공 테스트")
  void login() {
    // given
    String id = "hello";
    String pw = "world";
    String inputId = id;
    String inputPw = pw;
    // 일일이 데이터 값을 하드코딩 해주었음.

    // when
    boolean login_success = Login2.login(id, pw, inputId, inputPw);

    //then
    assertTrue(login_success);
  }

  @Test
  @DisplayName("로그인 실패 테스트- 비밀번호가 일치하지 않는 경우")
  void failslogin1() {
    // given
    String id = "hello";
    String pw = "world";
    String inputId = id;
    String inputPw = "strange";

    // when
    boolean login_fails1 = Login2.login(id, pw, inputId, inputPw);

    // then
    assertFalse(login_fails1);
  }

  @Test
  @DisplayName("로그인 실패 테스트- 비밀번호가 일치하지 않는 경우")
  void failslogin2() {
    // given
    String id = "hello";
    String pw = "world";
    String inputId = "goodbye";
    String inputPw = "strange";

    // when
    boolean login_fails2 = Login2.login(id, pw, inputId, inputPw);

    // then
    assertFalse(login_fails2);
  }
}