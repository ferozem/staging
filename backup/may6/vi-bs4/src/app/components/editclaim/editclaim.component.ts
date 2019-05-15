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
        this.router.navigate(["listclaim"]);
        return;
      }

    this.editClaim = this.formBuilder.group(
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
        this.router.navigate(['listclaim']);
      },
      error => {
        alert(error);
      }
    );
  }
}
