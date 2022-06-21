package hello.servlet.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res){

        List<Member> all = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        // model를 불러서 값을 설정
//        mv.getModel().put("member", member);
        mv.addObject("members", all);
        return mv;
    }
}
