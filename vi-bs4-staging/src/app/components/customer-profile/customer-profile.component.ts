import { Component, OnInit, OnDestroy } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit, OnDestroy {
  // id:number=100;
  customer: Customer;
  custId: string;
  // customers:Customer[];
  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit() {
    // if(localStorage.getItem("username")!=null){}
    // this.customerService.getCustomerById(this.id).subscribe(data=> 
    //   {this.customer=data;});

    console.log("inside on init of profile component")
    this.getCustomerId();

  }
  getCustomerId() {
    this.customerService.getCustomerIdFromUserId().subscribe(data => {
      this.custId = data;
      console.log("we got the customerID");
      console.log(this.custId);
      this.customerService.getCustomerById(this.custId).subscribe(data => {
        this.customer = data;
      })
    });


  }

  logoutCustomer(): void {
    if (localStorage.getItem("username") != null) {
      localStorage.removeItem("username");
      this.customer = null;
      this.router.navigate(["login"]);
    }
  }



  editCustomer(customer: Customer): void {

    localStorage.removeItem("editCustomerId");
    localStorage.setItem("editCustomerId", customer.custId.toString());
    this.router.navigate(["edit-customer"]);

  }

  ngOnDestroy() {
    this.customer = null;
  }

}
