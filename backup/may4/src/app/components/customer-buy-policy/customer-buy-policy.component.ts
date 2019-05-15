import { Component, OnInit } from '@angular/core';
import { BuyPolicyService } from 'src/app/service/buy-policy.service';
import { Validators, FormBuilder, FormGroup, FormGroupName } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../../models/product';
import { Years } from '../../models/years';
import { Vehicle } from 'src/app/models/vehicle';

@Component({
  selector: 'app-customer-buy-policy',
  templateUrl: './customer-buy-policy.component.html',
  styleUrls: ['./customer-buy-policy.component.css']
})
export class CustomerBuyPolicyComponent implements OnInit {

  addForm: FormGroup;
  vehicle:FormGroupName;
  submitted: boolean = false;
  id: number = 100;
  products: Product[];
  productNumber: number;
  years: Years[];
  // vehicle: Vehicle={};

  constructor(private formBuilder: FormBuilder, private router: Router, private buyPolicyService: BuyPolicyService) { }

  ngOnInit() {
    // this.addForm = this.formBuilder.group(
    //   {
    //     custId:[],
    //     productNumber:['',Validators.required],
    //     tenure:['',Validators.required],
    //     policyIssueDate:['',Validators.required],
    //     vehicleType:['',Validators.required],
    //     vehicleRegNumber:['',Validators.required],
    //     vehicleChasisNumber:['',Validators.required],
    //     vehicleEngineNumber:['',Validators.required],
    //     vehicleManufacturer:['',Validators.required],
    //     vehicleModelNumber:['',Validators.required],
    //     vehicleMfgMMYYYY:['',Validators.required],
    //     vehicleIdvValue:['',Validators.required],
    //     nomineeName:['',Validators.required],
    //     nomineeDate:['',Validators.required],
    //     nomineeRelation:['',Validators.required],
    //     nomineeIdtype:['',Validators.required],
    //     nomineeIdnumber:['',Validators.required],
    //     nomineePhonenumber:['',Validators.required]
    //   }

    this.addForm = this.formBuilder.group(
      {
        custId: [],
        productNumber: ['', Validators.required],
        tenure: ['', Validators.required],
        policyIssueDate: ['', Validators.required],      
        vehicle: this.formBuilder.group({
          vehicleType: ['', Validators.required],
          vehicleRegNumber: ['', Validators.required],
          vehicleChasisNumber: ['', Validators.required],
          vehicleEngineNumber: ['', Validators.required],
          vehicleManufacturer: ['', Validators.required],
          vehicleModelNumber: ['', Validators.required],
          vehicleMfgMMYYYY: ['', Validators.required],
          vehicleIdvValue: ['', Validators.required],
        }),
        nomineeName: ['', Validators.required],
        nomineeDate: ['', Validators.required],
        nomineeRelation: ['', Validators.required],
        nomineeIdtype: ['', Validators.required],
        nomineeIdnumber: ['', Validators.required],
        nomineePhonenumber: ['', Validators.required]
      }
    );
    this.years = [
      { tenure: 1, tenureYears: "1 Year" },
      { tenure: 2, tenureYears: "2 Year" },
      { tenure: 3, tenureYears: "3 Year" }
    ]

    this.buyPolicyService.getProducts()
      .subscribe(data => { this.products = data; })

  }

  errorDetails: string = "";
  onSubmit() {

    console.log(this.addForm.value);
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.buyPolicyService.createPolicy(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(["home"]);
      },
        err => {
          console.log(err);
          this.errorDetails = err;
        });


  }


}
