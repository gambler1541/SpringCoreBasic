package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTon {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        // 요청이 올때마다 새로운 객체를 생성
        // 트래픽의 양에 따라 객체가 생성되고 소멸되는 문제점
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2); // 객체 두개가 다름
    }
}
