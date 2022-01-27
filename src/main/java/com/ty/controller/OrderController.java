package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.OrderTest;
import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class OrderController {

	public static void main(String[] args) {
	OrderTest orderTest=new OrderTest();
	
	Item item=new Item();
	item.setId(10);
	item.setName("laptop");
	item.setPrice(100000);
	item.setQty(2);
	
	Item item1=new Item();
	item1.setId(11);
	item1.setName("book");
	item1.setPrice(2000);
	item1.setQty(3);
	
	Item item2=new Item();
	item2.setId(12);
	item2.setName("pen");
	item2.setPrice(100);
	item2.setQty(3);
	
	List<Item>list=new ArrayList();
	list.add(item);
	list.add(item1);
	list.add(item2);
	
	AmazonOrder amazonOrder=new AmazonOrder();
	amazonOrder.setId(1);
	amazonOrder.setAddress("davangere");
	amazonOrder.setItems(list);
	
	orderTest.addItems(amazonOrder,list);

	}

}
