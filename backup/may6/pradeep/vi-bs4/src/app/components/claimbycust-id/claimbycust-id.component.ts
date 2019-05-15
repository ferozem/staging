import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimService } from 'src/app/service/claim.service';
import { Claim } from 'src/app/models/claim';

import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-claimbycust-id',
  templateUrl: './claimbycust-id.component.html',
  styleUrls: ['./claimbycust-id.component.css']
})
export class ClaimbycustIdComponent implements OnInit {
  claims:Claim;

custId : number=100;
addForm: FormGroup;
  submitted: boolean = false;
// custId =this.addForm.controls.custId.value;
  constructor(private formBuilder: FormBuilder, private router: Router, private claimService: ClaimService) { }

  ngOnInit() {
    this.claimService.getClaimByCustId(this.custId).subscribe(
      data=> {this.claims=data;});
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
