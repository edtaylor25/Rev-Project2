import { Component, OnInit } from '@angular/core';
import { user } from '../../user.model';
import { UserService } from '../../user.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  
  allManagers: user[] = [];

  errorMsg: string = '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllManagers();
  }

  getAllManagers() {
    this.userService.getAllManagers().subscribe(
      (response) => {
        this.allManagers = response;
        console.log(response);
      },
      (error) => {
        console.log(error);
        this.errorMsg = 'There was some internal error! Try again later! Please and thank you.';
        console.log(this.errorMsg); 
      }
    );
  }
}
