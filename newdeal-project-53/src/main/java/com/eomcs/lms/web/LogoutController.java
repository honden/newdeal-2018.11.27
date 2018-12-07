package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController{
  
  @RequestMapping("/auth/logout")
  public String logout(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception{
    
    request.getSession().invalidate();
    
    return "Redirect:login";
  }
}








