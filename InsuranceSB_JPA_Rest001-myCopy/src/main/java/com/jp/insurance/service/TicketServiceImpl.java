package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.TicketDao;
import com.jp.insurance.entities.Ticket;
import com.jp.insurance.exception.TicketException;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Override
	@Transactional
	public Long addTicket(Ticket ticket) throws TicketException {
		// call dao layer method and return to Client.
		return ticketDao.addTicket(ticket);
	}

	@Override
	public List<Ticket> getTicketList() throws TicketException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return ticketDao.getTicketList();
	}

	@Override
	@Transactional
	public boolean updateTicket(Ticket ticket) throws TicketException {
		// call dao layer method and return to Client.
		return ticketDao.updateTicket(ticket);
	}

	@Override
	@Transactional
	public boolean deleteTicketById(Long ticketId) throws TicketException {
		// call dao layer method and return to Client.
		return ticketDao.deleteTicketById(ticketId);
	}

	@Override
	public Ticket getTicketById(Long ticketId) throws TicketException {
		// call dao layer method and return to Client.
		return ticketDao.getTicketById(ticketId);
	}

	@Override
	public List<Ticket> getTicketListbyCustID(Integer custId) throws TicketException {
		// TODO Auto-generated method stub
		return ticketDao.getTicketListbyCustID(custId);
	}
}
