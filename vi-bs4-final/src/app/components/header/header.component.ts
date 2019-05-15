import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGuard } from 'src/app/guards/auth.guard';
import { ResourceLoader } from '@angular/compiler';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router,public auth:AuthGuard) { }
  username: string = "";

  ngOnInit() {
  }
  logOut(){
    localStorage.removeItem("isValidLogin");
    localStorage.removeItem("editClaimId");
    localStorage.removeItem("editTicketNumber");
    localStorage.removeItem("username");
    localStorage.removeItem("usertype");
    localStorage.removeItem("customerid");
    localStorage.removeItem("editCustomerId");
    this.router.navigate(['/login']);
    
    
  }


}
