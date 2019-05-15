import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Claim } from '../models/claim';


@Injectable({
  providedIn: 'root'
})
export class ClaimService {

  constructor(private http:HttpClient) { }

  baseUrl = "http://localhost:8082/api/claims";

  getClaims(){
    return this.http.get<Claim[]>(this.baseUrl);
  }

  createClaim(claim:Claim){
    return this.http.post(this.baseUrl+"/save",claim,{responseType:'text'});
  }
  updateClaim(claim:Claim){
    return this.http.put(this.baseUrl+"/"+claim.claimId,claim);
   }
   deleteClaim(id:number){
    return this.http.delete(this.baseUrl+"/"+id);
  }
  getClaimById(id:number){

    return this.http.get<Claim>(this.baseUrl+"/"+id);
  }
}
