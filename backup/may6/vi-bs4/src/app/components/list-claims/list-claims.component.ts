import { Component, OnInit } from '@angular/core';
import { Claim } from 'src/app/models/claim';
import { ClaimService } from 'src/app/service/claim.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-claims',
  templateUrl: './list-claims.component.html',
  styleUrls: ['./list-claims.component.css']
})
export class ListClaimsComponent implements OnInit {
  claims: Claim[];
  claim: any;
  buttonDisabled: boolean;
  buttonApproveDisabled: boolean;
  buttonRejectDisabled: boolean;
  constructor(private router: Router, private claimService: ClaimService) { }

  ngOnInit() {
    this.buttonDisabled = false;
    this.claimService.getClaims().subscribe(data => {
      this.claims = data;
      // if(this.claims[1].claimStatus === "Approved" || "Rejected" ){
      //   this.claim.isDisabled=true;
      // } 
      // for(let c of this.claims)
      // {
      //   if(this.claim.claimStatus = "Approved"){
      //     this.statusVal="Rejected"
      //   }
      //   if(this.claim.claimStatus = "Rejected"){
      //     this.statusVal="Approved"
      //   }
      // }
    });
  }
  statusVal: string;
  approveOrRejClaim(formclaim: Claim): void {
    // alert("Approved");
    this.claim = formclaim;
     this.claimService.updateClaim(this.claim).subscribe(data => { this.claim = data; });
    // for (let c of this.claims) {
    //   if (this.claim.claimStatus = "Approved") {
    //     this.statusVal = "Rejected"
    //   }
    //   if (this.claim.claimStatus = "Rejected") {
    //     this.statusVal = "Approved"
    //   }
    // }
    // localStorage.removeItem("editClaimId");

    // event.target.id
    // localStorage.setItem("editClaimId",claim.claimId.toString());
    this.router.navigate(["listclaim"]);

  }
  approveClaim(formclaim: Claim): void {
    // alert("Approved");
    this.claim = formclaim;
    this.claim.claimStatus = "Approved";
    this.claim.isDisabled=false;
    this.claimService.updateClaim(this.claim).subscribe(data => { this.claim = data; });
    for (let c of this.claims) {
      if (c.claimStatus === "Approved") {
        
      }
      if (c.claimStatus === "Rejected") {

      }
    }
    // localStorage.removeItem("editClaimId");

    // event.target.id
    // localStorage.setItem("editClaimId",claim.claimId.toString());
    this.router.navigate(["listclaim"]);

  }
  rejectClaim(formclaim: Claim): void {
    //alert("Rejected");
    this.claim = formclaim;
    this.claim.claimStatus = "Rejected";
    if(this.claim.claimStatus == "" ){
      this.claim.isDisabled=true;
    }
     this.claim.isDisabled=false;
    this.claimService.updateClaim(this.claim).subscribe(data => { this.claim = data; });
    // localStorage.removeItem("editClaimId");
    for (let c of this.claims) {
      if (c.claimStatus === "Approved") {
        this.buttonApproveDisabled = true;
        this.buttonRejectDisabled = false;
      }

    }
    // localStorage.setItem("editClaimId",claim.claimId.toString());
    this.router.navigate(["listclaim"]);

  }

  // editClaim(claim:Claim):void{

  //   localStorage.removeItem("editClaimId");

  //   localStorage.setItem("editClaimId",claim.claimId.toString());
  //   this.router.navigate(["editclaim"]);

  // }
  back():void{
    this.router.navigate(["admin"]);
  }
  

}
