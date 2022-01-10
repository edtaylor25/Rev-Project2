import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-manager',
  templateUrl: './home-manager.component.html',
  styleUrls: ['./home-manager.component.css']
})
export class HomeManagerComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  getUserInfo(){
    this.router.navigate(['user-details']);
  }
  getManagerRequest(){
    this.router.navigate(['request-manage']);
  
}

}
