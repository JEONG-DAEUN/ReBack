package ReBack.core.controller;

import ReBack.core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ReBack.core.Repository.MemberRepository;

import java.util.Optional;
import java.util.Random;

import ReBack.core.data.Member;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private TestService certificationService;


    @PostMapping("/singUp1")
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
        Optional<Member> adminchk = memberRepository.findByMemberId(inputId);
        Member adminCheck = adminchk.get();

        if (adminCheck.getMemberId().equals(inputId) && passwordEncoder.matches(member.getMemberPassword(), adminCheck.getMemberPassword())) {
            return "ok";
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return "no";
        }
    }


    @GetMapping("/check/sendSMS")
    public @ResponseBody
    String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        certificationService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }


//    @RequestMapping(value = "/phoneCheck", method = RequestMethod.GET)
//    @ResponseBody
//    public String sendSMS(@RequestParam("phone") String userPhoneNumber) {
//        // 휴대폰 문자보내기
//        int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);
//        //난수 생성
//        testService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
//        return Integer.toString(randomNumber);
//    }


    }
