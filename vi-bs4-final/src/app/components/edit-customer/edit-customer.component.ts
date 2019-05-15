import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  custId:string;
  editForm: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private customerService:CustomerService, private loginService:LoginService) { }

  ngOnInit() {

    this.editForm = this.formBuilder.group(
      {
        custId: [],
        custFname: ['', Validators.required],
        custLname: ['', Validators.required],
        custDob: ['', Validators.required],
        custGender: ['', Validators.required],

        custAddressLine1:['',Validators.required],
        custAddressLine2:['',Validators.required],
        custCity:['',Validators.required],
        custState:['',Validators.required],
        custZipCode:['',Validators.required],
        custCountry:['',Validators.required],
        
        mobile: ['', Validators.required],
        custEmail: ['', Validators.required],
        customerbloodGroup: ['', Validators.required],
        identityType: ['', Validators.required],
        idNumber: ['', Validators.required],
        userId: ['', Validators.required],
        password:['',Validators.required],
        maritalStatus: ['', Validators.required],
      }
    );
   
    // this.custId=this.customerService.getCustomerIdFromUserId(); 
    this.customerService.getCustomerIdFromUserId().subscribe(data=> 
      {
        this.custId=data;
        console.log("after getUserIdFromLoginService() in edit-customer---we got the customerID");
        console.log(this.custId);
        this.customerService.getCustomerById(this.custId).subscribe(data => {
          //assign the data to editform
          this.editForm.setValue(data);
        });
      });

    
    // this.customerService.getCustomerIdFromUserId().subscribe(data=> 
    //   {
    //     this.custId=data;
    //     console.log("we got the customerID");
    //     console.log(this.custId);
    //   });  

    

  }

  onSubmit() {
    this.submitted = true;
    if (this.editForm.invalid) {
      return;
    }
    this.customerService.updateCustomer(this.editForm.value)
      .subscribe(
        data => {
          this.router.navigate(["customer-profile"]);
        },
        error => {
          alert(error);
        }
      );
  }

}
