import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CanActivate } from "@angular/router";


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) { }
  canActivate() {
    let username = localStorage.getItem("username");
    let userType = localStorage.getItem("usertype");
    let isValidLogin = localStorage.getItem("isValidLogin");
    if ((username !== null && userType !== null && isValidLogin ==="true")&& (userType === "Customer" || userType ==="Employee")) {
      console.log("login sucessfull")
      return true;
    }
    else {
      return false;
    }


  }

  isCustomer() {
    let username = localStorage.getItem("username");
    let userType = localStorage.getItem("usertype");
    let isValidLogin = localStorage.getItem("isValidLogin");
    if ((username !== null && userType !== null && isValidLogin ==="true")&& userType === "Customer" ){
      return true;
    }
    else {
      return false;
    }
  }

  isEmployee(){
    let username = localStorage.getItem("username");
    let userType = localStorage.getItem("usertype");
    let isValidLogin = localStorage.getItem("isValidLogin");
    if ((username !== null && userType !== null && isValidLogin ==="true")&& userType === "Employee" ){
      return true;
    }
    else {
      return false;
    }
  }

}
