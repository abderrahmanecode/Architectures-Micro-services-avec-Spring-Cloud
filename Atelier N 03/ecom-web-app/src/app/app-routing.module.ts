import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./guards/security.guard";
import {OrdersComponent} from "./orders/orders.component";
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";

const routes: Routes = [
  {
    path : "products", component : ProductsComponent
  },
  {
    path : "customers", component : CustomersComponent
  },
  {
    path:"orders/:customerID", component : OrdersComponent, canActivate: [AuthGuard], data : { roles : ['USER','ADMIN']}
  },
  {
    path:"order-details/:orderID", component : OrderDetailsComponent, canActivate: [AuthGuard], data : { roles : ['USER','ADMIN']}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
