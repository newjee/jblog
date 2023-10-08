package com.poscodx.jblog.controller;

import com.poscodx.jblog.security.Auth;
import com.poscodx.jblog.security.AuthUser;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
//없는 페이지 처리 (/user)
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    // 1-1. 회원가입 폼 화면
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(@ModelAttribute UserVo userVo) {
        return "user/join";
    }

    // 1-2. 회원가입 폼 입력 후 회원가입 성공 화면
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@ModelAttribute @Valid UserVo userVo,
                       BindingResult result,
                       Model model,
                       HttpSession session
                       ) {

        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error);}
//            System.out.println(result);
            model.addAllAttributes(result.getModel());
//            model.getAttribute("userVo", userVo);
            return "user/join";
        }
            userService.join(userVo);
            System.out.println(">>>>userVo " + userVo);
        session.setAttribute("authUser", userVo);

        return "redirect:/user/joinsuccess";
    }

    @RequestMapping(value = "/joinsuccess", method = RequestMethod.GET)
    public String joinsuccess(
            HttpSession session,
            @ModelAttribute BlogVo blogVo) {
        UserVo userVo = (UserVo) session.getAttribute("authUser");

        System.out.println("userId>>>>" + userVo.getId());
        blogVo.setBlogId(userVo.getId());
        System.out.println("userCon " + blogVo);
        blogService.insert(blogVo);

        //세션 종료
        session.invalidate();


        return "user/joinsuccess";
    }

    // 2-1. 로그인 화면
    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }


}

