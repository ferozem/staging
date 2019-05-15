import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginDetails } from '../models/login-details';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  //baseUrl = "http://localhost:8082/api/login";
  baseUrl = "http://chandraspringbootdev.ap-south-1.elasticbeanstalk.com/api/login";
  username:string;
  usertype:string;

  validateLogin(loginDetails:LoginDetails){
    console.log("inside validate login of login service")
    console.log("user type is")
    console.log(localStorage.getItem("usertype"));
    if(localStorage.getItem("usertype")==='Customer'){
      console.log("if condition true")
        return this.http.post(this.baseUrl+"/usrlogin",loginDetails,{responseType:'json'});
    }else{
      console.log("if condition is false")
      return this.http.post(this.baseUrl+"/emplogin",loginDetails,{responseType:'json'});
    }
  }

  validateUserLogin(loginDetails:LoginDetails){
    console.log("inside validate User Login of loginService")
    return this.http.post(this.baseUrl+"/usrlogin",loginDetails,{responseType:'json'});
  }

  validateEmpLogin(loginDetails:LoginDetails){
    console.log("inside validate Employee Login of loginService")
    return this.http.post(this.baseUrl+"/emplogin",loginDetails,{responseType:'json'});
  }
    

  getUserIdFromLoginService():string{
    console.log("inside getUserIdFromLoginSerivce method of LoginService")
    this.username = localStorage.getItem("username");
    return this.username;
  }

  getUserTypeFromLoginService():string{
    console.log("inside getUserTypeFromLoginSerivce method of LoginService")
    this.usertype = localStorage.getItem("usertype");
    return this.usertype;
  }
}
