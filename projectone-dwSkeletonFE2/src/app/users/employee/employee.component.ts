import { Component, OnInit } from '@angular/core';

import { user } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  editUser: user = {
    id: 0,
    screenName: "",
    userType: "",
    homeState: "",
    homeTown: "",
    email: "",
    password: "",
    address: "",
  }

  allUsers: user[] = [];
  user: user ={
    id: 0,
    screenName: "",
    userType: "",
    homeState: "",
    homeTown: "",
    email: "",
    password: "",
    address: ""
  };

  allFlag = false;
  employeeFlag = false;
  managerFlag = false;
  errorMsg = "";

  constructor(private userService: UserService) { }
  

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      (response) => {
        this.allUsers = response;
        console.log(response);
      },
      (error) => {
        error = this.errorMsg;
        console.log(this.errorMsg);
        console.log(console.error()); 
      }
    );
  }

  // setManagerFlag() {
  //   this.loadPendingRequests();
  //   if (this.managerFlag==true) this.managerFlag=false;
  //   else this.managerFlag=true;
  // }


  // setEmployeeFlag() {
  //   this.loadResolvedRequests();
  //   if (this.employeeFlag==true) this.employeeFlag=false;
  //   else this.employeeFlag=true;
  // }
  editUserInfo() {
    this.userService.updateUser(this.editUser).subscribe(
      (response) => {
        console.log(response);
        this.getAllUsers();
      
      },
      (error) => {
        console.log(error);
      }
    );

  }


}
