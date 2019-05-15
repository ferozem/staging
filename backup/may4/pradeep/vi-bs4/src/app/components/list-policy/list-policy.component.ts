import { Component, OnInit } from '@angular/core';
import { Policy } from 'src/app/models/policy';
import { PolicyService } from 'src/app/service/policy.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-policy',
  templateUrl: './list-policy.component.html',
  styleUrls: ['./list-policy.component.css']
})
export class ListPolicyComponent implements OnInit {
  policies:Policy[];
  constructor(private router:Router,private policyService:PolicyService) { }

  ngOnInit() {
    this.policyService.getPolicies().subscribe(data=> 
      {this.policies=data;});
  }

  editPolicy(policy:Policy):void{
    
    localStorage.removeItem("editPolicyId");
    
    localStorage.setItem("editPolicyId",policy.policyNumber.toString());
    this.router.navigate(["editpolicy"]);
  
  }
}
