package ReBack.core.controller;

import ReBack.core.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

import ReBack.core.data.Member;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/signUp1")
    public String insertUser1(@RequestBody Member member) {
        if (member.getMemberId() == "" || member.getMemberId() == null) {
//                == null && member.getEmail() == "" || member.getEmail() == null) {
            member.setMemberId("member");
//            member.setEmail("member");
        }

        Optional<Member> idCheck = memberRepository.findById(member.getMemberId());
//       Optional<Member> emailCheck = memberRepository.findById(member.getEmail());

        if (idCheck.isPresent() == true) {
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

    @PostMapping("/signUp")
    public String insertUser(@RequestBody Member member) {
        String inputId = member.getMemberId();
        if (inputId == "" || inputId == null) {
            return "ng";
        }
        Optional<Member> idCheck = memberRepository.findByMemberId(inputId);
        if (idCheck.isPresent() == true) {
            return "no";
        } else {
            return "ok";
        }
    }

    @PostMapping("/login")
    public String chkUser(@RequestBody Member member) {
        String inputId = member.getMemberId();
        Optional<Member> adminchk = memberRepository.findById(inputId);
        Member adminCheck = adminchk.get();
        //System.out.println(adminCheck.getAdminId());

        // 디비에 있는 비밀번호
        //System.out.println(adminCheck.getAdminPw());

        if (adminCheck.getMemberId().equals(inputId) &&
                passwordEncoder.matches(member.getMemberPassword(), adminCheck.getMemberPassword())) {
            // 입력한 비밀번호, 디비 비밀번호 비교
            return "ok";
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return "no";
        }
    }


//    @GetMapping("/check/sendSMS")
//    public @ResponseBody
//    String sendSMS(String memberPhoneNumber) {
//
//        Member rand  = new Member();
//        String numStr = "";
//        for(int i=0; i<4; i++) {
//            String ran = Integer.toString(rand.nextInt(10));
//            numStr+=ran;
//        }
//
//        System.out.println("수신자 번호 : " + memberPhoneNumber);
//        System.out.println("인증번호 : " + numStr);
//
//        certificationService.certifiedPhoneNumber(memberPhoneNumber,numStr);
//        return numStr;
//    }


}
