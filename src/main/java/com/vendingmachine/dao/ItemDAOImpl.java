package com.vendingmachine.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vendingmachine.entity.Item;
import com.vendingmachine.entity.Money;

@Repository
@Component
public class ItemDAOImpl implements ItemDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ItemDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Item> getItems() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Item> theQuery = currentSession.createQuery("from Item", Item.class);
		List<Item> items = theQuery.getResultList();
		
		return items;
	}

	@Override
	public Item selectProduct(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Item item = currentSession.get(Item.class, id);
		
		return item;
	}

	@Override
	public void save(Item item) {
		
		Session crtSession = entityManager.unwrap(Session.class);
		crtSession.saveOrUpdate(item);
	}

	@Override
	public void deleteById(int theId) {
		
		Session crtSession = entityManager.unwrap(Session.class);
		
		Query theQuery = crtSession.createQuery("delete from Item where id =: itemId");
		theQuery.setParameter("itemId", theId);
		theQuery.executeUpdate();
	}

}
