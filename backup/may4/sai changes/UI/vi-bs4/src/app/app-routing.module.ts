import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AdminComponent } from './components/admin/admin.component';
import { StaffComponent } from './components/staff/staff.component';
import { NewCustomerComponent } from './components/new-customer/new-customer.component';
import { ExistingCustomerComponent } from './components/existing-customer/existing-customer.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ServicesComponent } from './components/services/services.component';
import { AboutComponent } from './components/about/about.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { CustomerBuyPolicyComponent } from './components/customer-buy-policy/customer-buy-policy.component';
import { CustomerClaimInsuranceComponent } from './components/customer-claim-insurance/customer-claim-insurance.component';
import { CustomerMyPoliciesComponent } from './components/customer-my-policies/customer-my-policies.component';
import { CustomerProfileComponent } from './components/customer-profile/customer-profile.component';
import { CustomerRenewPolicyComponent } from './components/customer-renew-policy/customer-renew-policy.component';
import { CreateTicketComponent } from './components/create-ticket/create-ticket.component';
import { EditCustomerComponent } from './components/edit-customer/edit-customer.component';
import { ViewPolicyDetailsComponent } from './components/view-policy-details/view-policy-details.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"about",component:AboutComponent },
  {path:"contact-us",component:ContactUsComponent },
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"admin",component:AdminComponent},
  {path:"staff",component:StaffComponent},
  {path:"new-customer",component:NewCustomerComponent },
  {path:"existing-customer",component:ExistingCustomerComponent },
  {path:"services",component:ServicesComponent },

  {path:"customer-buy-policy",component:CustomerBuyPolicyComponent },
  {path:"customer-claim-insurance",component:CustomerClaimInsuranceComponent },
  {path:"customer-my-policies",component:CustomerMyPoliciesComponent },
  {path:"customer-profile",component:CustomerProfileComponent },
  {path:"customer-renew-policy",component:CustomerRenewPolicyComponent },
  {path:"create-ticket",component:CreateTicketComponent },
  {path:"edit-customer", component: EditCustomerComponent},
  {path:"detailed-policy/:policyId",component:ViewPolicyDetailsComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
