package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.lang.model.SourceVersion;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("Spring이 없는 순수한 DI Container")
    void pureContainer() {
        AppConfig ac = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.memberService();

        // 3. 참조: 값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 4. memberService1 != memberService2 => 호출할 때 마다 객체를 생성하면 자원 낭비가 심하다
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        // 1. 조회: 싱글톤 객체 호출
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 2. 참조: 값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // 3. singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
