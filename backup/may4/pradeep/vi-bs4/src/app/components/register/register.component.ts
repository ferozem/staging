import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  addCust:FormGroup;
  submitted:boolean=false;

  constructor(private formBuilder:FormBuilder, private router:Router, private registerService:RegisterService) { }

  ngOnInit() {
    this.addCust = this.formBuilder.group(
      {
        custId:[],
        custFname:['',Validators.required],
        custLname:['',Validators.required],
        custDob:['',Validators.required],
        custGender:['',Validators.required],
        custAddress:['',Validators.required],
        mobile:['',Validators.required],
        custEmail:['',Validators.required],
        customerbloodGroup:['',Validators.required],
        identityType:['',Validators.required],
        idNumber:['',Validators.required],
        userId:['',Validators.required],
        maritalStatus:['',Validators.required]
      }
    );
  }

  onSubmit(){
    this.submitted=true;
    if(this.addCust.invalid){
      return;
    }
    this.registerService.createCustomer(this.addCust.value)
      .subscribe(data=>{
        this.router.navigate(["list-emp"]); //go to reg-status page -- display message login sucessfull-- click here to login
      })
    
    
  }

}
