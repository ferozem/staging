import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { Router } from '@angular/router';
import { invalid } from '@angular/compiler/src/render3/view/util';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  addForm:FormGroup;
  submitted:boolean=false;
  username:string;

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService:LoginService) { }

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
    if(this.addForm.invalid){
      return;
    }


    this.loginService.validateLogin(this.addForm.value).subscribe(data=>
      { 
      this.loginService.username=this.addForm.value.loginUserName;
      this.loginService.usertype=this.addForm.value.loginType;
      if(data){
        if(this.addForm.value.loginType==="Employee"){
          if(this.addForm.value.loginUserName==="pradeep"){
            this.router.navigate(["admin"]);
          }else{
            this.router.navigate(["login"]);
          }
        }else{
          this.router.navigate(["existing-customer"]);
        }
      }else{
        this.router.navigate(["login"]);
      }
      })
  }

}
