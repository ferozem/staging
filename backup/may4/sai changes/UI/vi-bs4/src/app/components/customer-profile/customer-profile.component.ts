import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {
  customer:Customer;
  custId:string;

  // customers:Customer[];
  constructor(private router:Router,private customerService:CustomerService) { }


  ngOnInit() {
      console.log("inside on init of profile component")
      this.customerService.getCustomerIdFromUserId().subscribe(data=> 
        {
          this.custId=data;
          console.log("we got the customerID");
          console.log(this.custId);
          this.customerService.getCustomerById(this.custId).subscribe(data=>{
            this.customer=data;
          })
        });   
        
        
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
