package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class OrderTest {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void addItems(AmazonOrder amazonOrder,List<Item>list) {
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityTransaction.commit();
	}
	
	public AmazonOrder getItems(int id) {
		AmazonOrder amazonOrder=entityManager.find(AmazonOrder.class,id);
		return amazonOrder;
	}
	
	public void deleteItems(int id) {
		entityTransaction.begin();
		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		
		if(amazonOrder!=null) {
		entityManager.remove(amazonOrder);
		entityTransaction.commit();
		}
	}
	
	

	public void updateItems(int id) {
		entityTransaction.begin();
		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		List<Item>items=amazonOrder.getItems();
		items.addAll(items);
		entityManager.merge(amazonOrder);
		entityTransaction.commit();
	
	}
}
