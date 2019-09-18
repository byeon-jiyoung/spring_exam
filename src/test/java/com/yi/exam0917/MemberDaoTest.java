package com.yi.exam0917;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.MemberVO;
import com.yi.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class) //junit 돌게
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //설정파일을 참고할 수 있도록
public class MemberDaoTest {
	
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testInsert() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("userid");
		vo.setUserpw("userpw");
		vo.setUsername("username");
		vo.setEmail("username@email.com");
		dao.insertMember(vo);
	}
	
}
