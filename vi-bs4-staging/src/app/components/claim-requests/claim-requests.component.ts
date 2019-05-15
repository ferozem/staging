import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClaimService } from 'src/app/service/claim.service';

@Component({
  selector: 'app-claim-requests',
  templateUrl: './claim-requests.component.html',
  styleUrls: ['./claim-requests.component.css']
})
export class ClaimRequestsComponent implements OnInit {
  addClaim: FormGroup;
  submitted: boolean = false;

  unamePattern = "^[a-z0-9_-]{8,15}$";
  pwdPattern = "^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$";
  mobnumPattern = "^((\\+91-?)|0)?[0-9]{10}$"; 
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";

  constructor(private formBuilder: FormBuilder, private router: Router,
    private claimService: ClaimService) { }

  ngOnInit() {

    this.addClaim = this.formBuilder.group(
      {
        claimId: [],
        custId: [localStorage.getItem("customerid"), [Validators.required, Validators.minLength(2)]],
        policyNumber: ['',[Validators.required]],
       claimAmount: ['', [Validators.required]],
        damageType: ['', [Validators.required]],
        dateOfClaim: ['yyyy-mm-dd', [Validators.required]],
       // dateSettled: ['', Validators.required],
       // amountPaid: ['', Validators.required],
        //claimStatus: ['', Validators.required],
      }
    );
  }

  onSubmit() {

    this.submitted = true;
    if (this.addClaim.invalid) {
      return;
    }

  

    this.claimService.createClaim(this.addClaim.value).subscribe(data => {
      console.log(data);
     this.router.navigate(["existing-customer"]);

    }
    );


  
  }

}
