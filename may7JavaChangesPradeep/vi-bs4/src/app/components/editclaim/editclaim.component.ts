import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClaimService } from 'src/app/service/claim.service';

@Component({
  selector: 'app-editclaim',
  templateUrl: './editclaim.component.html',
  styleUrls: ['./editclaim.component.css']
})
export class EditclaimComponent implements OnInit {
  editClaim: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private claimService:ClaimService) { }

  ngOnInit() {
    let claimId = localStorage.getItem("editClaimId");
      if (!claimId) {
        alert("Invalid Action!");
        this.router.navigate(["admin"]);
        return;
      }

    this.editClaim = this.formBuilder.group(
      {
        claimId: [],
        custId: ['', Validators.required],
        policyNumber: ['', Validators.required],
       claimAmount: ['', Validators.required],
        damageType: ['', Validators.required],
       dateOfClaim: ['', Validators.required],
        dateSettled: ['', Validators.required],
       amountPaid: ['', Validators.required],
       claimStatus: ['', Validators.required]
      }
    );
    this.claimService.getClaimById(+claimId).subscribe(data => {
      //assign the data to editform
      this.editClaim.setValue(data);
    });
  }
  onSubmit() {
    this.submitted = true;
    if (this.editClaim.invalid) {
      return;
    }
    this.claimService.updateClaim(this.editClaim.value).subscribe(

      data => {
        this.router.navigate(['admin']);
      },
      error => {
        alert(error);
      }
    );
  }
}
