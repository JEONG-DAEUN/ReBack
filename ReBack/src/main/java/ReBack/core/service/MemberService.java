package ReBack.core.service;


import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
    @Autowired
    ReBack.core.repository.MemberRepository memberRepository;
}
