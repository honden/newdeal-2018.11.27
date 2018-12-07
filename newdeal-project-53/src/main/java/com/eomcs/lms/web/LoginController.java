package com.eomcs.lms.web;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
public class LoginController{
  MemberDao memberDao;

  public LoginController(MemberDao memberDao) {
    this.memberDao = memberDao;
  } 
  
  @RequestMapping("/auth/login")
  public String login(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception{
    
      HashMap<String,Object> params = new HashMap<>();
      params.put("email", request.getParameter("eamil"));
      params.put("password", request.getParameter("password"));
      
      Member member = memberDao.findByEmailPassword(params);
      HttpSession session = request.getSession();
      
      if (member != null) {
        System.out.println(member);
        session.setAttribute("loginUser", member);
        return "Redirect:../board/list";
      } else {
        session.invalidate();
        return "Redirect:form";
      }
  }
}








