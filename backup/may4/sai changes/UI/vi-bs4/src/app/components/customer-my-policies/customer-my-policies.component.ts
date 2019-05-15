import { Component, OnInit } from '@angular/core';
import { PolicyService } from 'src/app/service/policy.service';
import { Router } from '@angular/router';
import { Fullpolicy } from 'src/app/models/fullpolicy';
import { LoginService } from 'src/app/service/login.service';


@Component({
  selector: 'app-customer-my-policies',
  templateUrl: './customer-my-policies.component.html',
  styleUrls: ['./customer-my-policies.component.css']
})
export class CustomerMyPoliciesComponent implements OnInit {
  policyList:Fullpolicy[];
  username = this.loginService.username;

  constructor(private router: Router, private policyService: PolicyService,private loginService:LoginService) { }

  ngOnInit() {
    console.log(this.username);
    this.policyService.getPolicyList(this.username)
      .subscribe(data => 
        { this.policyList = data; })
        
  }

  getConsolidatedPolicy(policyId:string){
    this.router.navigate(["detailed-policy/"+policyId]);
  }

}

