package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save_사용자_저장되는지_확인(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member save = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(save.getId());
        Assertions.assertThat(save).isEqualTo(findMember);
    }

    @Test
    void findAll_모두_조회되는지_확인(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> all = memberRepository.findAll();

        //then
        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all).contains(member1, member2);
    }
}