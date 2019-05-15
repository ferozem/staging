import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TicketService } from 'src/app/service/ticket.service';

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit {

  createTicket:FormGroup;

  submitted:boolean=false;
  constructor(private formBuilder:FormBuilder, private router:Router, private ticketService:TicketService) { }

  ngOnInit() {
    this.createTicket = this.formBuilder.group(
      {
        ticketNumber:[],
        ticketDescription:['',Validators.required],
        ticketStatus:['',Validators.required]
      
        
      }
    );
  }
  onSubmit(){
    console.log(this.createTicket.value);
    this.submitted=true;
    if(this.createTicket.invalid){
      return;
    }

    this.ticketService.createTicket(this.createTicket.value)
      .subscribe(data=>{
        this.router.navigate(["/listticket"]); //go to reg-status page -- display message login sucessfull-- click here to login
      },err=>{
        console.log(err);
      })
    
    
  }

}
