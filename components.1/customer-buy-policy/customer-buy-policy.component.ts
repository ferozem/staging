import { Component, OnInit } from '@angular/core';
import { BuyPolicyService } from 'src/app/service/buy-policy.service';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../../models/product';

@Component({
  selector: 'app-customer-buy-policy',
  templateUrl: './customer-buy-policy.component.html',
  styleUrls: ['./customer-buy-policy.component.css']
})
export class CustomerBuyPolicyComponent implements OnInit {

  addForm:FormGroup;
  submitted:boolean=false;
  id:number=100;
  products: Product[];

  constructor(private formBuilder:FormBuilder, private router:Router, private buyPolicyService:BuyPolicyService) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group(
      {
        vehicleId:[],
        custId:[],
        vehicleType:['',Validators.required],
        vehicleRegNumber:['',Validators.required],
        vehicleChasisNumber:['',Validators.required],
        vehicleEngineNumber:['',Validators.required],
        vehicleManufacturer:['',Validators.required],
        vehicleModelNumber:['',Validators.required],
        vehicleMfgMMYYYY:['',Validators.required]
      }
    );

    this.buyPolicyService.getProducts()
    .subscribe(data => 
      { this.products = data; })
  }

  onSubmit(){
    this.submitted=true;
    if(this.addForm.invalid){
      return;
    }
    this.buyPolicyService.createVehicle(this.addForm.value)
      .subscribe(data=>{
        this.router.navigate(["home"]); 
      })
    
    
  }
  

}
