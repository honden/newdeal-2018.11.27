package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

@Controller
public class LoginFormController{

  @RequestMapping("/auth/form")
  public String loginForm(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception{
    response.setContentType("text/html;charset=UTF-8");

    return"/auth/form.jsp";
  }
}








