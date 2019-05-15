import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

  baseUrl = "http://localhost:8082/api/customers";
  
  createCustomer(customer:Customer){
    return this.http.post(this.baseUrl+"/save",customer,{responseType:'text'});
  
  }
}
