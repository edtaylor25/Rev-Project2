import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-employee',
  templateUrl: './home-employee.component.html',
  styleUrls: ['./home-employee.component.css']
})
export class HomeEmployeeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  getUserInfo(){
    this.router.navigate(['user-details']);
  }
  getUserRequest(){
    this.router.navigate(['request-pending']);
  }


}
