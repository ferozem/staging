import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PolicyService } from 'src/app/service/policy.service';
import { Fullpolicy } from 'src/app/models/fullpolicy';


@Component({
  selector: 'app-view-policy-details',
  templateUrl: './view-policy-details.component.html',
  styleUrls: ['./view-policy-details.component.css']
})
export class ViewPolicyDetailsComponent implements OnInit {
  fullPolicy:Fullpolicy;

  constructor(private activatedRoute:ActivatedRoute,private router:Router,private policyService: PolicyService) { }

  ngOnInit() {
    let id= this.activatedRoute.snapshot.paramMap.get('policyId');
    console.log(id);
    this.policyService.getFullPolicy(id).subscribe(data=>{
      console.log(data);
      this.fullPolicy=data;})
  }

}
