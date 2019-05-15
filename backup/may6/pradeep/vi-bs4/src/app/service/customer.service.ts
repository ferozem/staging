import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient, private loginService:LoginService) { 

  }

  baseUrl = "http://localhost:8082/api/customers";
  baseUrl2="http://localhost:8082/api/login/";
  id=this.loginService.getUserIdFromLoginService();
  
  getCustomers(){
    return this.http.get<Customer[]>(this.baseUrl);
  }

  createCustomer(customer:Customer){
    return this.http.post(this.baseUrl+"/save",customer,{responseType:'json'});
  }
  updateCustomer(customer:Customer){
    return this.http.put(this.baseUrl+"/"+customer.custId,customer);
   }
   deleteCustomer(id:number){
    return this.http.delete(this.baseUrl+"/"+id);
  }
  getCustomerById(id:string){
    return this.http.get<Customer>(this.baseUrl+"/"+id);
  }
  getCustomerIdFromUserId() {
    console.log("inside getCustomerIdFromUserId method of customerService");
    return this.http.get<string>(this.baseUrl2+"getCustomerIdByUserId/"+this.id);
    
  }

}
