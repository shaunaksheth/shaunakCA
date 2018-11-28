import { Component, OnInit } from '@angular/core';
import { Product } from '../Model/product';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  product: Product[] = [
    {
      id: 1,
      name: 'Angular',
      price: 10000,
      isActive: true,
      photoPath: 'assets/images/angular.png'
    },
    {
      id: 2,
      name: 'Hibernet',
      price: 29000,
      isActive: true,
      photoPath: 'assets/images/hibernet.png'   
    },
    {
      id: 3,
      name: 'Enterprise Java',
      price: 30000,
      isActive: false,
      photoPath: 'assets/images/j2ee.png'
    },
    {
      id: 4,
      name: 'Oracle',
      price: 40000,
      isActive: true,
      photoPath: 'assets/images/oracle.png'
    },
    {
      id: 5,
      name: 'Spring',
      price: 50000,
      isActive: true,
      photoPath: 'assets/images/Spring.png'
    },
    {
      id: 6,
      name: 'TypeScript',
      price: 60000,
      isActive: true,
      photoPath: 'assets/images/typescript.png'
    },
  ];


  constructor() { }

  ngOnInit() {
  }

}
