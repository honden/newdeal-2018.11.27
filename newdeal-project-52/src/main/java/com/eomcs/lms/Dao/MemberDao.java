package com.eomcs.lms.Dao;

import com.eomcs.lms.domain.Member;

public interface MemberDao {
  Member findByEmailPassword(String email, String password) 
      throws Exception;
}