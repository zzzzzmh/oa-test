package com.lashou.oa.cms.web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lashou.oa.cms.domain.Category;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cms/cate")
public class CategoryController {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@RequestMapping("/testAdd")
	public void testAdd() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();  
		    transaction.begin();
		    Category root = new Category("服务类");
		    Category meishi = new Category("美食");
		    Category chuancai = new Category("川菜");
		    Category beijing = new Category("北京菜");
		    root.addChild(meishi);
		    meishi.addChild(chuancai);
		    meishi.addChild(beijing);
		    session.save(root);
		    root.setCategory("生活");
		    transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
