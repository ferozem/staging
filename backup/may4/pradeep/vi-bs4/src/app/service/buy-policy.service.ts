import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from '../models/vehicle';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class BuyPolicyService {
  constructor(private http:HttpClient) { }

  baseUrl = "http://localhost:8082/api/vehicles";
  productsUrl = "http://localhost:8082/api/products";
  
  createVehicle(vehicle:Vehicle){
    return this.http.post(this.baseUrl+"/save",vehicle,{responseType:'text'});
}

  getProducts(){
    return this.http.get<Product[]>(this.productsUrl);
  }

}