import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {
  id:number=100;
  customer:Customer;
  // customers:Customer[];
  constructor(private router:Router,private customerService:CustomerService) { }

  ngOnInit() {
    // if(localStorage.getItem("username")!=null){}
      this.customerService.getCustomerById(this.id).subscribe(data=> 
        {this.customer=data;});
  
    
  }
 
  logoutCustomer():void{
    if(localStorage.getItem("username")!=null){
        localStorage.removeItem("username");
        this.router.navigate(["login"]);
    }
  }



   editCustomer(customer:Customer):void{
    
    localStorage.removeItem("editCustomerId");
    localStorage.setItem("editCustomerId",customer.custId.toString());
    this.router.navigate(["edit-customer"]);
  
  }

}
