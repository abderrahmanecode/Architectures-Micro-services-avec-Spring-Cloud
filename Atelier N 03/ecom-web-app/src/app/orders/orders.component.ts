import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent {
  orders :any;
  customerId!: number;
  constructor(private http:HttpClient, private router:Router, private route:ActivatedRoute) {
    this.customerId=route.snapshot.params['customerID']
  }
  ngOnInit():void{
    this.http.get("http://localhost:8888/BILLING-SERVICE/bills/search/byCustomerId?projection=fullOrder&customerId="+this.customerId).subscribe({
      next : (data)=>{
        this.orders=data;
      },
      error:(err)=>{

      }
    })
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id);
  }
}
