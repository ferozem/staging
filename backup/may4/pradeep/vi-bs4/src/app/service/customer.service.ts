import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { 

  }

  baseUrl = "http://localhost:8082/api/customers";

  getCustomers(){
    return this.http.get<Customer[]>(this.baseUrl);
  }

  createCustomer(customer:Customer){
    return this.http.post(this.baseUrl+"/save",customer,{responseType:'text'});
  }
  updateCustomer(customer:Customer){
    return this.http.put(this.baseUrl+"/"+customer.custId,customer);
   }
   deleteCustomer(id:number){
    return this.http.delete(this.baseUrl+"/"+id);
  }
  getCustomerById(id:number){
    return this.http.get<Customer>(this.baseUrl+"/"+id);
  }

  
}
