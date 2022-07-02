package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.lang.model.SourceVersion;

public class SingletonTest {

    @Test
    @DisplayName("Spring이 없는 순수한 DI Container")
    void pureContainer() {
        AppConfig ac = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.memberService();

        // 3. 참조 값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 4. memberService1 != memberService2 => 호출할 때 마다 객체를 생성하면 자원 낭비가 심하다
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }
}
