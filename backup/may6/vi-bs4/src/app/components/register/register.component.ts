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
        
        mobile:['',Validators.required],
        custEmail:['',Validators.required],
        customerbloodGroup:['',Validators.required],
        identityType:['',Validators.required],
        idNumber:['',Validators.required],
        userId:['',Validators.required],
        password:['',Validators.required],
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
