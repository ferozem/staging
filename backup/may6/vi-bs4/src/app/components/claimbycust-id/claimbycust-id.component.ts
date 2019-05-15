import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimService } from 'src/app/service/claim.service';
import { Claim } from 'src/app/models/claim';

import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-claimbycust-id',
  templateUrl: './claimbycust-id.component.html',
  styleUrls: ['./claimbycust-id.component.css']
})
export class ClaimbycustIdComponent implements OnInit {
  claims:Claim[];
  customer:Customer;

custId : string;
username = this.loginService.username;
addForm: FormGroup;
  submitted: boolean = false;
// custId =this.addForm.controls.custId.value;
  constructor(private formBuilder: FormBuilder, private router: Router, 
    private claimService: ClaimService,private loginService:LoginService,
    private customerService:CustomerService) { }

  ngOnInit() {

    this.customerService.getCustomerIdFromUserId().subscribe(
      data=> {this.custId=data;
        this.claimService.getClaimByCustId(this.custId).subscribe(
          data=> {this.claims=data;});
          console.log("inside claimbycustomer component");
          console.log(this.username);
      
      });


    

      
  }

  back():void{
    this.router.navigate(["existing-customer"]);
  }
  // onSubmit() {
  //   this.submitted = true;
  //   console.log(this.custId);
  //   if (this.addForm.invalid) {
  //     return;
  //   }
  //   this.claimService.getClaimByCustId(+this.custId).subscribe(

  //     data => {
  //       this.router.navigate(['listclaimbycustid']);
  //     },
  //     error => {
  //       alert(error);
  //     }
  //   );
  // }

}
