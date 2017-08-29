package com.bigdata2017.jdbc.bookshop.dao.test;

import java.util.List;

import com.bigdata2017.jdbc.bookshop.dao.BookDao;
import com.bigdata2017.jdbc.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testGetList();
		testDelete();

	}
	
	public static void testDelete() {
		new BookDao().delete();
	}
	
	public static void testGetList() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void testInsert() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setTitle("트와일라잇");
		vo.setAuthorName("스테파니메이어");
		
		vo.setTitle("뉴문");
		vo.setAuthorName("스테파니메이어");
		
		vo.setTitle("이클립스");
		vo.setAuthorName("스테파니메이어");
		
		vo.setTitle("아리랑");
		vo.setAuthorName("조정래");
		
		vo.setTitle("젊은그들");
		vo.setAuthorName("김동인");
		
		vo.setTitle("아프니까 청춘이다");
		vo.setAuthorName("김난도");
		
		vo.setTitle("귀천");
		vo.setAuthorName("천상병");
		
		vo.setTitle("태백산맥");
		vo.setAuthorName("조정래");
		
		vo.setTitle("풀하우스");
		vo.setAuthorName("원수연");
	}

}
