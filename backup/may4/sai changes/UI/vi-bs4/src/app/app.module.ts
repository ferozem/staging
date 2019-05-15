import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AdminComponent } from './components/admin/admin.component';
import { StaffComponent } from './components/staff/staff.component';
import { NewCustomerComponent } from './components/new-customer/new-customer.component';
import { ExistingCustomerComponent } from './components/existing-customer/existing-customer.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { ServicesComponent } from './components/services/services.component';
import { AboutComponent } from './components/about/about.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerProfileComponent } from './components/customer-profile/customer-profile.component';
import { CustomerMyPoliciesComponent } from './components/customer-my-policies/customer-my-policies.component';
import { CustomerBuyPolicyComponent } from './components/customer-buy-policy/customer-buy-policy.component';
import { CustomerRenewPolicyComponent } from './components/customer-renew-policy/customer-renew-policy.component';
import { CustomerClaimInsuranceComponent } from './components/customer-claim-insurance/customer-claim-insurance.component';
import { CreateTicketComponent } from './components/create-ticket/create-ticket.component';
import { CustomerService } from './service/customer.service';
import { EditCustomerComponent } from './components/edit-customer/edit-customer.component';
import { ViewPolicyDetailsComponent } from './components/view-policy-details/view-policy-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AdminComponent,
    StaffComponent,
    NewCustomerComponent,
    ExistingCustomerComponent,
    RegisterComponent,
    LoginComponent,
    ServicesComponent,
    AboutComponent,
    ContactUsComponent,
    CustomerProfileComponent,
    CustomerMyPoliciesComponent,
    CustomerBuyPolicyComponent,
    CustomerRenewPolicyComponent,
    CustomerClaimInsuranceComponent,
    CreateTicketComponent,
    EditCustomerComponent,
    ViewPolicyDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot(),
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
