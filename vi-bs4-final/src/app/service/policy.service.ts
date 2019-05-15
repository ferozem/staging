import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Policy } from '../models/policy';
import { FullPolicy } from '../models/full-policy';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http:HttpClient) { }
  //baseUrl = "http://localhost:8082/api/policy";
  //baseUrl1 = "http://localhost:8082/api/login/";
  baseUrl = "http://chandraspringbootdev.ap-south-1.elasticbeanstalk.com/api/policy";
  baseUrl1 = "http://chandraspringbootdev.ap-south-1.elasticbeanstalk.com/api/login/";

  getPolicies(){
    return this.http.get<Policy[]>(this.baseUrl+"/list");
  }

  getPoliciesByCustId(custId:number){
    return this.http.get<Policy[]>(this.baseUrl+"/getPolicy/byCustId/"+custId);
  }

  getPolicyList(username:string){
    return this.http.get<FullPolicy[]>(this.baseUrl1+"getPoliciesByUserId/"+username);
  }

  getFullPolicy(id:string){
    console.log(id)
    return this.http.get<FullPolicy>(this.baseUrl+"getPolicy/"+id);
    }

}
