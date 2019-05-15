import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ticket } from '../models/ticket';


@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8082/api/tickets";

  getTickets() {
    return this.http.get<Ticket[]>(this.baseUrl);
  }

  createTicket(ticket: Ticket) {
    console.log('Service Called');
    console.log(ticket);
    return this.http.post(this.baseUrl + "/save", ticket);
  }
  updateTicket(ticket: Ticket) {
    return this.http.put(this.baseUrl + "/" + ticket.ticketNumber, ticket);
  }
  deleteTicket(id: number) {
    return this.http.delete(this.baseUrl + "/" + id);
  }
  getTicketById(id: number) {

    return this.http.get<Ticket>(this.baseUrl + "/" + id);
  }

  getTicketByCustId(id:number){

    return this.http.get<Ticket>(this.baseUrl+"/getTicket/byCustId/"+id);
    
  }
}

