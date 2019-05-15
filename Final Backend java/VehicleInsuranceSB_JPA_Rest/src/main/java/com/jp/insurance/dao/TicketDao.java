package com.jp.insurance.dao;

import java.util.List;

import com.jp.insurance.entities.Ticket;
import com.jp.insurance.exception.TicketException;

public interface TicketDao {
	
	public Long addTicket(Ticket ticket)throws TicketException;//C-create
	public List<Ticket> getTicketList()throws TicketException;//R All Customer -retrieve
	public boolean updateTicket(Ticket ticket)throws TicketException;//U-update
	public boolean deleteTicketById(Long ticketId)throws TicketException;//D-delete
	public Ticket getTicketById(Long ticketId)throws TicketException;//S-search
	public List<Ticket> getTicketListbyCustID(Integer custId)throws TicketException;

}
