import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyPolicy } from '../models/buyPolicy';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class BuyPolicyService {
  constructor(private http:HttpClient) { }

  //baseUrl = "http://localhost:8082/api/policy";
  //productsUrl = "http://localhost:8082/api/products";
  baseUrl = "http://chandraspringbootdev.ap-south-1.elasticbeanstalk.com/api/policy";
  productsUrl = "http://chandraspringbootdev.ap-south-1.elasticbeanstalk.com/api/products";

  createPolicy(buyPolicy:BuyPolicy){
    console.log(buyPolicy);
    return this.http.post(this.baseUrl+"/buyPolicy/",buyPolicy,{responseType:'json'});
}
  

  getProducts(){
    return this.http.get<Product[]>(this.productsUrl);
  }

}