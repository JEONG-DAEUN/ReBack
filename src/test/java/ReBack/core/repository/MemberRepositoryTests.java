package ReBack.core.repository;

import ReBack.core.data.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static ReBack.core.data.MemberType.WRITER;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1,100).forEach(i-> {
            Member member = Member.builder()
            .memberName("user"+i)
                    .memberPassword("1111")
                    .memberEmail("user"+i+"@aaa.com")
                    .memberPhoneNumber("0000")
                    .memberPostalCode(1)
                    .memberAddress("address"+i)
                    .memberType(WRITER)
                    .build();
                    memberRepository.save(member);
        });
    }
}
