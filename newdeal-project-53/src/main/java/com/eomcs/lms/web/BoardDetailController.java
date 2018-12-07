package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Controller("/board/detail")
public class BoardDetailController{

  BoardDao boardDao;
  
  public BoardDetailController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping("/board/detail")
  public String detail(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception{
  
    int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findByNo(no);
      request.setAttribute("board", board);
      
      response.setContentType("text/html;charset=UTF-8");
      return "/board/detail.jsp";
    
  }
}




