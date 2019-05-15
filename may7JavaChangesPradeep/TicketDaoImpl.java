package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Ticket;
import com.jp.insurance.exception.TicketException;

//prep-work 1 -@Repository TicketDaoImpl
@Repository
public class TicketDaoImpl implements TicketDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Long addTicket(Ticket ticket) throws TicketException {
		System.out.println("From dao: " + ticket);
		entityManager.persist(ticket);
		return ticket.getTicketNumber();
	}
	
	@Override
	public List<Ticket> getTicketList() throws TicketException {
		Query query = entityManager.createQuery("from Ticket");
		return query.getResultList();
	}

	@Override
	public boolean updateTicket(Ticket ticket) throws TicketException {
	
		return entityManager.merge(ticket)!=null;
	}

	@Override
	public boolean deleteTicketById(Long ticketId) throws TicketException {
		Ticket ticket = getTicketById(ticketId);
		if(ticket == null)
		return false;
		else{
			entityManager.remove(ticket);
			return true;
		}
	}

	@Override
	public Ticket getTicketById(Long ticketId) throws TicketException {
		
		return entityManager.find(Ticket.class, ticketId);
	}

	@Override
	public List<Ticket> getTicketListbyCustID(Integer custId) throws TicketException {
		List<Ticket> ticketList=null;
		System.out.println("GET CLAIM BY CUST ID:");
		Query query = entityManager.createQuery("from Ticket where CUST_ID =:custId");
		query.setParameter("custId", custId);
		if(!query.getResultList().isEmpty())
		{
			ticketList = query.getResultList();

		}
		System.out.println("Ticket List by Cust Id: "+ticketList  );
		return query.getResultList();
	
	}
}
