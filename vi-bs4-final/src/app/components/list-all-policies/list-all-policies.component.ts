import { Component, OnInit } from '@angular/core';
import { Policy } from 'src/app/models/policy';
import { PolicyService } from 'src/app/service/policy.service';
import { Router } from '@angular/router';
import { FullPolicy } from 'src/app/models/full-policy';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-list-all-policies',
  templateUrl: './list-all-policies.component.html',
  styleUrls: ['./list-all-policies.component.css']
})
export class ListAllPoliciesComponent implements OnInit {

   policies:Policy[];
   //policyList:FullPolicy[];
   username = this.loginService.username;
 
   constructor(private router:Router,private policyService:PolicyService,private loginService:LoginService) { }
 
   ngOnInit() {
     // this.policyService.getPolicies().subscribe(data=> 
     //   {this.policies=data;});
     console.log("inside list policy component")
     console.log(this.username)
       this.policyService.getPolicies()
       .subscribe(data => 
         { this.policies = data; 
           console.log(data);
         });
 
      
   }
   back():void{
     this.router.navigate(["admin"]);
   }
   // editPolicy(policy:Policy):void{
     
   //   localStorage.removeItem("editPolicyId");
     
   //   localStorage.setItem("editPolicyId",policy.policyNumber.toString());
   //   this.router.navigate(["editpolicy"]);
   
   // }

}
