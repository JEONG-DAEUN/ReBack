package ReBack.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ReBack.core.Repository.MemberRepository;

import java.util.Optional;

import ReBack.core.data.Member;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/singUp")
    public String insertUser1(@RequestBody Member member) {
        if (member.getMemberId() == "" || member.getMemberId() == null) {
            member.setMemberId("member");
        }
//        Optional<Member> idCheck = memberRepository.findById(member.getMemberId());
        return "ok";
    }



    @PostMapping("/singUp1")
    public String insertUser(@RequestBody Member member) {

           String encodedPassword = passwordEncoder.encode(member.getMemberPassword());
           member.setMemberPassword(encodedPassword);
            memberRepository.save(member);
            return "ok";

    }

    @PostMapping("/Login")
    public String chkUser(@RequestBody Member userInfo) {

        Optional<Member> idCheck = memberRepository.findById(userInfo.getMemberId());
        Member adminCheck = idCheck.get();
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
