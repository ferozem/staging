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
claims:Claim[];
  constructor(private router:Router,private claimService:ClaimService) { }

  ngOnInit() {
    this.claimService.getClaims().subscribe(data=> 
      {this.claims=data;});
  }

  editClaim(claim:Claim):void{
    
    localStorage.removeItem("editClaimId");
    
    localStorage.setItem("editClaimId",claim.claimId.toString());
    this.router.navigate(["editclaim"]);
  
  }

}
