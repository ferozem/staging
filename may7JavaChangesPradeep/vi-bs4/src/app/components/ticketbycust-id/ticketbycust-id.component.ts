import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Ticket } from 'src/app/models/ticket';
import { Router } from '@angular/router';
import { TicketService } from 'src/app/service/ticket.service';

@Component({
  selector: 'app-ticketbycust-id',
  templateUrl: './ticketbycust-id.component.html',
  styleUrls: ['./ticketbycust-id.component.css']
})
export class TicketbycustIdComponent implements OnInit {
tickets:Ticket;
  custId : number=100;
  addForm: FormGroup;
    submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private ticketService: TicketService) { }

  ngOnInit() {
    this.ticketService.getTicketByCustId(this.custId).subscribe(
      data=> {this.tickets=data;});
  }

  back():void{
    this.router.navigate(["existing-customer"]);
  }

}
