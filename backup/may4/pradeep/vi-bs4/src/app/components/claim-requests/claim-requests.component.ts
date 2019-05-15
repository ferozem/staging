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

  constructor(private formBuilder: FormBuilder, private router: Router,
    private claimService: ClaimService) { }

  ngOnInit() {

    this.addClaim = this.formBuilder.group(
      {
        claimId: [],
        //custId: ['', Validators.required],
        policyNumber: ['', Validators.required],
        claimAmount: ['', Validators.required],
        damageType: ['', Validators.required],
        dateOfClaim: ['', Validators.required],
        dateSettled: ['', Validators.required],
        amountPaid: ['', Validators.required],
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
     this.router.navigate(["/listclaim"]);

    }
    );


  
  }

}
