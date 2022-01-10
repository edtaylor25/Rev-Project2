import { HttpClient } from "@angular/common/http";
import { Injectable, OnInit } from "@angular/core";    
import { Request } from "./request.model";
import { Component} from '@angular/core';
@Injectable ({
    providedIn: 'root'
})

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})

export class RequestComponent implements OnInit{

    constructor(private http: HttpClient) { }
    ngOnInit(): void {
    }
  
    newFlag = false;
  
  newPending: Request = {
    id:0,
    date:"",
    amount:0,
    status:"pending",
    userId:0,
  }


  edPending: Request ={
    id:0,
    date:"",
    amount:0,
    status:"pending",
    userId:0,
  }

  allPending: Request[] = [

    {
      id:0,
      date:"",
      amount:0,
      status:"pending",
      userId:0,
    }
    
  ]
   

  removeRequest(id: number) {
    this.allPending.forEach((value, index) => {
      if(this.allPending[index].id == id) {
        this.allPending.splice(index, 1);
      }
    });
  }

  editRequest(id: number) {
    this.allPending.forEach((value, index) => {
      if(this.allPending[index].id == id) {
        this.allPending[index].date = this.edPending.date,
        this.allPending[index].amount=this.edPending.amount
      }
    });
  }

  addRequest() {
    var newRequest = {
      userId: 0,
      id: this.allPending[this.allPending.length-1].id + 1 ,
      date: this.newPending.date,
      amount: this.newPending.amount,
      edFlag:false,
      status:"pending",
    }
    this.allPending.push(newRequest);
  }


  setNewFlag() {
    if (this.newFlag == true) this.newFlag=false;
    else this.newFlag = true;
  }




  

}
