package com.lashou.oa.cs.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lashou.oa.cs.domain.OrderItem;
import com.lashou.oa.cs.domain.Orders;

@Controller
@RequestMapping("/cs/user")
public class UserController {
	
	@Resource
	MessageSource messageSource;
	
	@Resource
	private SessionFactory sessionFactory;

	@RequestMapping("/orderlist/{buyerId}")
	public ModelAndView orderList(@PathVariable String buyerId, 
			@RequestParam(defaultValue="1") String page, HttpServletResponse rep) {
		
		System.out.println(buyerId);
		System.out.println(page);
		
		if(buyerId.equals(0)) {
//			rep.setHeader("status", "404");
			return null;
		}
		
		ModelAndView mv = new ModelAndView();
		List<Orders> orders = new ArrayList<Orders>();
		mv.addObject("orders", orders);
		
		
		mv.setViewName("cs/user_orderlist");
		return mv;
	}
	
	@RequestMapping("/test")
	public void test(@RequestParam(value="s", defaultValue="0", required=false) Integer s) {
		
		if (s==0) {
			System.out.println("who are you");
			return;
		}
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();  
		    transaction.begin(); 
//			private Long orderId;
//			private Long parentId;
//			private Integer buyerId;
//			private Integer sellerId;
//			private BigDecimal totalFee;
//			private BigDecimal payed;
//			private BigDecimal epursePayed;
//			private BigDecimal freeMoney;
//			private BigDecimal conveyFee;
//			private BigDecimal freeConveyFee;
//			private Short status;
//			private Date buyTime;
//			private Date payTime;
//			private Date invalidTime;
//			private Date updateTime;
//			private Integer cityId;
//			private Short payType;
//			private Short source;
//			private String serialNumber;
//			private Integer addressId;
//			
			/*
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setBuyTime(df.format(new Date(System.currentTimeMillis())));
			order.setInvalidTime(df.format(new Date(System.currentTimeMillis()+30*60*1000)));
			*/
			long orderId = 150712345678l;
			
//			Orders order = new Orders();
//			order.setOrderId(new Long(orderId));
//			order.setParentId(new Long(0));
//			order.setBuyerId(new Integer(10));
//			order.setSellerId(new Integer(0));
//			order.setTotalFee(new BigDecimal(100.00));
//			order.setPayed(new BigDecimal(0));
//			order.setEpursePayed(new BigDecimal(0));
//			order.setFreeMoney(new BigDecimal(0));
//			order.setConveyFee(new BigDecimal(0));
//			order.setFreeConveyFee(new BigDecimal(0));
//			order.setStatus(new Short((short)0));
//			order.setBuyTime(new Date(System.currentTimeMillis()));
//			order.setInvalidTime(new Date(System.currentTimeMillis()+30*60*1000));
//			order.setUpdateTime(new Date(System.currentTimeMillis()));
//			order.setCityId(new Integer(2419));
//			order.setSource(new Short((short)1));
//			order.setAddressId(new Integer(231234));
//			order.setDel(new Short((short)0));
//			order.setPayType(new Short((short)0));
//			session.save(order);
			
			//long orderId2 = 150712345679l;
			Orders order2 = new Orders();
			//order2.setOrderId(new Long(orderId2));
			order2.setParentId(orderId);
			order2.setBuyerId(new Integer(10));
			order2.setSellerId(new Integer(200));
			order2.setTotalFee(new BigDecimal(100.00));
			order2.setPayed(new BigDecimal(0));
			order2.setEpursePayed(new BigDecimal(0));
			order2.setFreeMoney(new BigDecimal(0));
			order2.setConveyFee(new BigDecimal(0));
			order2.setFreeConveyFee(new BigDecimal(0));
			order2.setStatus(new Short((short)0));
			order2.setBuyTime(new Date(System.currentTimeMillis()));
			order2.setInvalidTime(new Date(System.currentTimeMillis()+30*60*1000));
			order2.setUpdateTime(new Date(System.currentTimeMillis()));
			order2.setCityId(new Integer(2419));
			order2.setSource(new Short((short)1));
			order2.setAddressId(new Integer(231234));
			order2.setDel(new Short((short)0));
			order2.setPayType(new Short((short)0));
			//session.save(order2);
			
//			private Long detailId;
//			private Integer buyerId;
//			private Integer sellerId;
//			private Integer goodsId;
//			private Integer amount;
//			private BigDecimal price;
//			private BigDecimal costPrice;
//			private BigDecimal totalFee;
//			private Date payTime;
//			private Orders orders;
			
			OrderItem orderItem =  new OrderItem();
			orderItem.setOrders(order2);
			orderItem.setBuyerId(new Integer(10));
			orderItem.setSellerId(new Integer(200));
			orderItem.setGoodsId(new Integer(72));
			orderItem.setAmount(new Integer(2));
			orderItem.setPrice(new BigDecimal(50.00));
			orderItem.setCostPrice(new BigDecimal(50.00*0.98));
			orderItem.setTotalFee(new BigDecimal(100.00));
			session.save(orderItem);
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
	
	@RequestMapping("/test2")
	public void test2(@RequestParam(value="s", defaultValue="0", required=false) Integer s) {
		if (s==0) {
			System.out.println("who are you");
			return;
		}
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();  
		    transaction.begin();
		    
		    long orderId = 150712345678l;
			Orders order2 = new Orders();
			order2.setParentId(orderId);
			order2.setBuyerId(new Integer(10));
			order2.setSellerId(new Integer(200));
			order2.setTotalFee(new BigDecimal(100.00));
			order2.setPayed(new BigDecimal(0));
			order2.setEpursePayed(new BigDecimal(0));
			order2.setFreeMoney(new BigDecimal(0));
			order2.setConveyFee(new BigDecimal(0));
			order2.setFreeConveyFee(new BigDecimal(0));
			order2.setStatus(new Short((short)0));
			order2.setBuyTime(new Date(System.currentTimeMillis()));
			order2.setInvalidTime(new Date(System.currentTimeMillis()+30*60*1000));
			order2.setUpdateTime(new Date(System.currentTimeMillis()));
			order2.setCityId(new Integer(2419));
			order2.setSource(new Short((short)1));
			order2.setAddressId(new Integer(231234));
			order2.setDel(new Short((short)0));
			order2.setPayType(new Short((short)0));
			//session.save(order2);
			
			OrderItem orderItem =  new OrderItem();
			//orderItem.setOrders(order2);
			orderItem.setBuyerId(new Integer(10));
			orderItem.setSellerId(new Integer(200));
			orderItem.setGoodsId(new Integer(72));
			orderItem.setAmount(new Integer(2));
			orderItem.setPrice(new BigDecimal(50.00));
			orderItem.setCostPrice(new BigDecimal(50.00*0.98));
			orderItem.setTotalFee(new BigDecimal(100.00));
			order2.addItem(orderItem);
			session.save(order2);
			
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
	
	@RequestMapping("/testQuery")
	public void testQuery() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();  
		    transaction.begin();
		    Orders order = (Orders) session.get(Orders.class, new Long(1));
		    System.out.println("---------------------");
		    Set<OrderItem> items = order.getItems();
		    for(OrderItem it: items) {
		    	System.out.println(it);
		    }
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
