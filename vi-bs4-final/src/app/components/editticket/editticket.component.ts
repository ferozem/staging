import { Component, OnInit } from '@angular/core';
import { TicketService } from 'src/app/service/ticket.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-editticket',
  templateUrl: './editticket.component.html',
  styleUrls: ['./editticket.component.css']
})
export class EditticketComponent implements OnInit {

  //id:number=100;
  editForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private ticketService:TicketService) { }

  ngOnInit() {

    let ticketNumber = localStorage.getItem("editTicketNumber");
      if (!ticketNumber) {
        alert("Invalid Action!");
        this.router.navigate(["listticket"]);
        return;
      }


    this.editForm = this.formBuilder.group(
      {
        ticketNumber: [],
        custId:[localStorage.getItem("customerid")],
        ticketDescription: ['', Validators.required],
        ticketStatus: ['', Validators.required],
        
      }
    );
    this.ticketService.getTicketById(+ticketNumber).subscribe(data => {
      //assign the data to editform
      this.editForm.setValue(data);
    });

  }

  onSubmit() {
    this.submitted = true;
    if (this.editForm.invalid) {
      return;
    }
    this.ticketService.updateTicket(this.editForm.value)
      .subscribe(
        data => {
          this.router.navigate(["/listticket"]);
        },
        error => {
          alert(error);
        }
      );
  }

}
