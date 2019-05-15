import { Component, OnInit } from '@angular/core';
import { PolicyService } from 'src/app/service/policy.service';
import { Router } from '@angular/router';
import { FullPolicy } from 'src/app/models/full-policy';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-list-policy',
  templateUrl: './list-policy.component.html',
  styleUrls: ['./list-policy.component.css']
})
export class ListPolicyComponent implements OnInit {
  // policies:Policy[];
  policyList:FullPolicy[];
  username = this.loginService.username;

  constructor(private router:Router,private policyService:PolicyService,private loginService:LoginService) { }

  ngOnInit() {
    // this.policyService.getPolicies().subscribe(data=> 
    //   {this.policies=data;});
    console.log("inside list policy component")
    console.log(this.username)
      this.policyService.getPolicyList(this.username)
      .subscribe(data => 
        { this.policyList = data; 
          console.log(data);
        });

     
  }
  back():void{
    this.router.navigate(["existing-customer"]);
  }
  // editPolicy(policy:Policy):void{
    
  //   localStorage.removeItem("editPolicyId");
    
  //   localStorage.setItem("editPolicyId",policy.policyNumber.toString());
  //   this.router.navigate(["editpolicy"]);
  
  // }
}
