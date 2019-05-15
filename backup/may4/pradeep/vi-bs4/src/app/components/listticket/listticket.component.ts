import { Component, OnInit } from '@angular/core';
import { TicketService } from 'src/app/service/ticket.service';
import { Router } from '@angular/router';
import { Ticket } from 'src/app/models/ticket';

@Component({
  selector: 'app-listticket',
  templateUrl: './listticket.component.html',
  styleUrls: ['./listticket.component.css']
})
export class ListticketComponent implements OnInit {
  tickets:Ticket[];

  constructor(private router:Router,private ticketService:TicketService) { }

  ngOnInit() {
    this.ticketService.getTickets().subscribe(data=> 
      {this.tickets=data;});
  }

  editTicket(ticket:Ticket):void{
    
    localStorage.removeItem("editClaimId");
    
    localStorage.setItem("editTicketNumber",ticket.ticketNumber.toString());
    this.router.navigate(["editticket"]);
  
  }


}
