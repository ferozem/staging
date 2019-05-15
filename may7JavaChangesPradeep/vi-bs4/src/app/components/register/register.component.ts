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
  sex:any;
  status:any;
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  pwdPattern = "^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$";
  mobnumPattern = "^((\\+91-?)|0)?[0-9]{10}$"; 
  unamePattern = "^[a-z0-9_-]{8,15}$";
  constructor(private formBuilder:FormBuilder, private router:Router, private registerService:RegisterService) { }

  ngOnInit() {
    this.addCust = this.formBuilder.group(
      {
        custId:[],
        custFname:['',Validators.required],
        custLname:['',Validators.required],
        custDob:['',Validators.required],
        custGender:['',Validators.required],
        
        custAddressLine1:['',Validators.required],
        custAddressLine2:['',Validators.required],
        custCity:['',Validators.required],
        custState:['',Validators.required],
        custZipCode:['',Validators.required],
        custCountry:['',Validators.required],
        
        mobile:['',[Validators.required, Validators.pattern(this.mobnumPattern)]],
        custEmail:['',[Validators.required, Validators.pattern(this.emailPattern)]],
        customerbloodGroup:['',Validators.required],
        identityType:['',Validators.required],
        idNumber:['',Validators.required],
        userId:['',[Validators.required, Validators.pattern(this.unamePattern)]],
        password:['',[Validators.required, Validators.pattern(this.pwdPattern)]],
        maritalStatus:['',Validators.required]
      }
    );

    this.sex = [
      {id: 1, name: "Male"},
      {id: 2, name: "Female"}
      ];

      this.status = [
        {id: 1, name: "Single"},
        {id: 2, name: "Married"},
        {id: 3, name: "Divorced"}
        ];
  }

  onSubmit(){
    this.submitted=true;
    if(this.addCust.invalid){
      return;
    }
    this.registerService.createCustomer(this.addCust.value)
      .subscribe(data=>{
        this.router.navigate(["login"]); //go to reg-status page -- display message login sucessfull-- click here to login
      })
    
    
  }

}
