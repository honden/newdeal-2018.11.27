package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

  BoardDao boardDao;
  LessonDao lessonDao;

  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }
  
  @RequestMapping("list")
  public String list(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Board> list = boardDao.findAll();
    request.setAttribute("list", list);

    return "board/list";
  }
 
  @RequestMapping("add")
  public String add(
      Board board, 
      HttpSession session)
          throws Exception {

    board.setContents(session.getParameter("contents"));

    Member loginUser = session.getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());

    boardDao.insert(board);

    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(int no,
      Model model)throws Exception {
      model.addAttribute("count", boardDao.delete(no));
      return "board/delete";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model)
      throws Exception {
      Board board = boardDao.findByNo(no);
      model.addAttribute("board", board);
      return "board/detail";
  }
  
  @RequestMapping("form")
  public String form(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    request.setAttribute("lessons", lessons);
    
    return "board/form";
  }
  
  @RequestMapping("update")
  public String update(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setContents(request.getParameter("contents"));

    boardDao.update(board);

    return "redirect:list";
  }
}








