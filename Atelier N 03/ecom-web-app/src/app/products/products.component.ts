import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  product :any;
  constructor(private http:HttpClient) {}
  ngOnInit():void{
    this.http.get("http://localhost:8888/PRODUCT-SERVICE/products?projection=fullProduct").subscribe({
      next : (data)=>{
        console.table(data)
        this.product=data;
      },
      error:(err)=>{

      }
    })
  }
}
