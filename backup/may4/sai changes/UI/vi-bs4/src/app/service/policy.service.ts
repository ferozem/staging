import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Fullpolicy } from '../models/fullpolicy';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  constructor(private http:HttpClient) { }

  baseUrl = "http://localhost:8082/api/login/";
  baseUrl2="http://localhost:8082/api/policy/"

  getPolicyList(username:string){
    return this.http.get<Fullpolicy[]>(this.baseUrl+"getPoliciesByUserId/"+username);
  }

  getFullPolicy(id:string){
    console.log(id)
    return this.http.get<Fullpolicy>(this.baseUrl2+"getPolicy/"+id);
    }
}
