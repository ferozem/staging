import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Policy } from '../models/policy';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http:HttpClient) { }
  baseUrl = "http://localhost:8082/api/policy";

  getPolicies(){
    return this.http.get<Policy[]>(this.baseUrl+"/list");
  }

  getPoliciesByCustId(custId:number){
    return this.http.get<Policy[]>(this.baseUrl+"/getPolicy/byCustId/"+custId);
  }
}
