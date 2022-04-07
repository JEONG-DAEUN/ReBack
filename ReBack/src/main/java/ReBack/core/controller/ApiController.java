package ReBack.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ReBack.core.repository.MemberRepository;

import java.util.Optional;

import ReBack.core.data.Member;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/singUp1")
    public String insertUser1(@RequestBody Member member) {
        if (member.getMemberId() == "" || member.getMemberId() == null){
//                == null && member.getEmail() == "" || member.getEmail() == null) {
            member.setMemberId("member");
//            member.setEmail("member");
        }

        Optional<Member> idCheck = memberRepository.findById(member.getMemberId());
//       Optional<Member> emailCheck = memberRepository.findById(member.getEmail());

        if (idCheck.isPresent() == true ){
//                && idCheck.isPresent() ==true ) {
            return "no";
        } else {
//           String inputEmail = member.getEmail();
//           member.setEmail(inputEmail);
           String encodedPassword = passwordEncoder.encode(member.getMemberPassword());
           member.setMemberPassword(encodedPassword);
            //System.out.println("길이: "+userInfo.getAdminPw().length());
            // 비밀번호 재확인은 구현안함
            // https://youngjinmo.github.io/2021/05/passwordencoder/
           memberRepository.save(member);
            return "ok";
        }
//
    }

    @PostMapping("/singUp")
    public String insertUser(@RequestBody Member member) {
        if (member.getMemberId() == "" || member.getMemberId() == null){
//                == null && member.getEmail() == "" || member.getEmail() == null) {
            member.setMemberId("member");
//            member.setEmail("member");
        }

        Optional<Member> idCheck = memberRepository.findById(member.getMemberId());
//       Optional<Member> emailCheck = memberRepository.findById(member.getEmail());

        if (idCheck.isPresent() == true ){
            return "no";
        } else {
            return "ok";
        }
//
    }

    @PostMapping("/Login")
    public String chkUser(@RequestBody Member userInfo) {

        Optional<Member> adminchk = memberRepository.findById(userInfo.getMemberId());
        Member adminCheck = adminchk.get();
        //System.out.println(adminCheck.getAdminId());

        // 디비에 있는 비밀번호
        //System.out.println(adminCheck.getAdminPw());

        if(adminCheck.getMemberId().equals(userInfo.getMemberId()) &&
                passwordEncoder.matches(userInfo.getMemberPassword(), adminCheck.getMemberPassword())) {
            // 입력한 비밀번호, 디비 비밀번호 비교
            return "ok";
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return "no";
        }}





}
