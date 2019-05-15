import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  id:number=100;
  editForm: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private customerService:CustomerService) { }

  ngOnInit() {

    this.editForm = this.formBuilder.group(
      {
        custId: [],
        custFname: ['', Validators.required],
        custLname: ['', Validators.required],
        custDob: ['', Validators.required],
        custGender: ['', Validators.required],
        custAddress: ['', Validators.required],
        mobile: ['', Validators.required],
        custEmail: ['', Validators.required],
        customerbloodGroup: ['', Validators.required],
        identityType: ['', Validators.required],
        idNumber: ['', Validators.required],
        userId: ['', Validators.required],
        maritalStatus: ['', Validators.required],
      }
    );
   

    this.customerService.getCustomerById(+this.id).subscribe(data => {
      //assign the data to editform
      this.editForm.setValue(data);
    });

  }

  onSubmit() {
    this.submitted = true;
    if (this.editForm.invalid) {
      return;
    }
    this.customerService.updateCustomer(this.editForm.value)
      .subscribe(
        data => {
          this.router.navigate(["list-emp"]);
        },
        error => {
          alert(error);
        }
      );
  }

}
