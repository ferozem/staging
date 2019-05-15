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
        custId:[localStorage.getItem("customerid"),[Validators.required, Validators.minLength(2)]],
        ticketDescription:['',[Validators.required, Validators.minLength(5), Validators.maxLength(15)]]
        //ticketStatus:['',Validators.required]
      
        
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
        console.log(this.createTicket.value);
        this.router.navigate(["/existing-customer"]); //go to reg-status page -- display message login sucessfull-- click here to login
      },(error:Response)=>{
        if(error.status === 403){
          alert('Requested service is currently down. Our Team is working on it.');
        }
        else{
         alert('Unexpected Error Occurred');
        }      
 
      
      
      // err=>{
      //   console.log(err);
      })
    
    
  }

}
