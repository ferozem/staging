import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginDetails } from '../models/login-details';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
    baseUrl = "http://localhost:8082/api/login";
    username:string;
    usertype:string;

    validateLogin(loginDetails:LoginDetails){
      return this.http.post(this.baseUrl+"/usrlogin",loginDetails,{responseType:'json'});
      }

    getUserIdFromLoginService():string{
      console.log("inside getUserIdFromLoginSerivce method of LoginService")
      console.log(this.username)
      return this.username;
    }

}
