package com.jp.insurance.service;

import java.util.List;

import com.jp.insurance.entities.Ticket;
import com.jp.insurance.exception.TicketException;

public interface TicketService {
	//CRUDS Operation
	public Long addTicket(Ticket Ticket)throws TicketException;//C-create
	public List<Ticket> getTicketList()throws TicketException;//R All Ticket -retrieve
	public boolean updateTicket(Ticket Ticket)throws TicketException;//U-update
	public boolean deleteTicketById(Long ticketId)throws TicketException;//D-delete
	public Ticket getTicketById(Long ticketId)throws TicketException;//S-search
	public List<Ticket> getTicketListbyCustID(Integer custId)throws TicketException;//R All Tickets -By Cust ID
}
