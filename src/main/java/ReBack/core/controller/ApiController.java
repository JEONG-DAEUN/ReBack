package ReBack.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ReBack.core.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import ReBack.core.data.Member;
import ReBack.core.Repository.UserInfoRepository;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/singUp")
    public String insertUser(@RequestBody Member userInfo) {
        if(userInfo.getName()=="" || userInfo.getName()==null) {
            userInfo.setName("member");
        }

        Optional<Member> adminchk = UserInfoRepository.findById(userInfo.getId());

        if(adminchk.isPresent()==true) {
            return "no";
        } else {
            String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
            userInfo.setPassword(encodedPassword);
            //System.out.println("길이: "+userInfo.getAdminPw().length());
            // 비밀번호 재확인은 구현안함
            // https://youngjinmo.github.io/2021/05/passwordencoder/
            UserInfoRepository.save(userInfo);
            return "ok";
        }
    }



}
