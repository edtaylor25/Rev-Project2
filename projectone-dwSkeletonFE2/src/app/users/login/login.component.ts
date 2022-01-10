import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { user } from '../user.model';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email = "";
  password = "";
  errorMsg="";

  testPerm = "";



  currentUser: user = {
    id:0,
    screenName:"",
    userType: "",
    homeState: "",
    homeTown: "",
    address: "",
    email: "",
    password: ""
  }
  constructor(private userService: UserService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  performLogin() {
    this.userService.getLoggedIn(this.email, this.password).subscribe(
      
      (response) => {
        console.log(response);
        sessionStorage.setItem('userId', ""+response.id);
        sessionStorage.setItem('userLevel', response.userType);
        this.authService.isLoggedIn = true;
        
        if(response.userType = "manager"){
          this.router.navigate(['']);
        }else if(response.userType = "employee") {
          this.router.navigate([''])
        }
      },
      (error) => {
          console.log(error);
          this.errorMsg= "ERROR!";
          console.log(this.errorMsg);
      }
    );
    

  }

}
