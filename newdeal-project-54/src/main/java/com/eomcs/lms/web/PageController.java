package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//프론트 컨트롤러가 페이지 컨트롤러를 호출 할 때 메서드 규칙
public interface PageController {
String execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
