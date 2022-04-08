package ReBack.core.controller;

import ReBack.core.data.Member;
import ReBack.core.repository.LectureRepository;
import ReBack.core.repository.MemberRepository;
import ReBack.core.repository.WriterInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class EducationController {

    @Autowired
    WriterInformationRepository writerInformationRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LectureRepository lectureRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/education")
    public String education() {return "education";}

    @GetMapping("/fitedu")
    public String fitedu() {return "fitedu";}

    @GetMapping("/shareedu")
    public String shareedu(Model model) {
        model.addAttribute("info", writerInformationRepository.findAll());
        return "shareedu";}

    @GetMapping("/writerResult/{memberCode}")
    public String writerResult(@PathVariable Long memberCode, Model model){
        model.addAttribute("member", memberRepository.findById(memberCode));
        model.addAttribute("info", writerInformationRepository.findAll());
        model.addAttribute("lecture", lectureRepository.findAll());
        return "writerResult";
    }
}
