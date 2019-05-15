import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { Router } from '@angular/router';

import { CustomerService } from 'src/app/service/customer.service';
import { stringify } from '@angular/core/src/util';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginError:string;
  addForm:FormGroup;
  submitted:boolean=false;
  username:string;
  custId:string;

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService:LoginService, private customerService:CustomerService) { }

  ngOnInit() {
    
    this.addForm = this.formBuilder.group(
      {
        
        loginUserName:['',Validators.required],
        loginPassword:['',Validators.required],
        loginType:['Customer']
      }
    );
  }

  
  onSubmit(){
    console.log("in onSumbit")
    this.submitted=true;
    localStorage.setItem("username",this.addForm.value.loginUserName);
    localStorage.setItem("usertype",this.addForm.value.loginType);
    if(this.addForm.invalid){
      return;
    }

    console.log("checking if username set properly")
    console.log(this.loginService.getUserIdFromLoginService());
    console.log("checking if userType set properly");
    console.log(this.loginService.getUserTypeFromLoginService());

    if(this.addForm.value.loginType==="Customer"){
      console.log("LoginType is customer")
      this.loginService.validateUserLogin(this.addForm.value).subscribe(data=>{
        if(data){
          localStorage.setItem("isValidLogin", "true" );


          // this.customerService.getCustomerIdByUserId(localStorage.getItem("username")).subscribe(data=>{this.id=data});
          // localStorage.setItem("custId", this.id);


          this.customerService.getCustomerIdFromUserId().subscribe(
            data=> {this.custId=data;
              // this.claimService.getClaimByCustId(this.custId).subscribe(
              //   data=> {this.claims=data;});
              //   console.log("inside claimbycustomer component");
              //   console.log(this.username);
                console.log(this.custId);
                localStorage.setItem("customerid", this.custId);
            
            });
          
          
          
          this.router.navigate(["existing-customer"]);
        }else{
          this.loginError="Invalid Credentials"
        }
      });
    }else{
      console.log("LoginType is employee")
      this.loginService.validateEmpLogin(this.addForm.value).subscribe(data=>{
        if(data){
          localStorage.setItem("isValidLogin", "true" );
          this.router.navigate(["admin"]);
        }else{
          this.loginError="Invalid Credentials"
        }
      })
    }

    // this.loginService.validateLogin(this.addForm.value).subscribe(data=>
    //   { 
    //   console.log("validate login method of login in component--")
    //   if(data){
    //   localStorage.setItem("username",this.addForm.value.loginUserName);
    //   localStorage.setItem("usertype",this.addForm.value.loginType);
    //   console.log(this.addForm.value.loginType);

    //     if(this.addForm.value.loginType==="Employee"){
    //       console.log(this.addForm.value.loginType);
    //      this.router.navigate(["admin"]);
    //     } else{
    //       console.log(this.addForm.value.loginType);
    //       this.router.navigate(["existing-customer"]);
    //     }
    //   }else{
    //     this.router.navigate(["login"]);
    //   }
    //   })
  }

}

