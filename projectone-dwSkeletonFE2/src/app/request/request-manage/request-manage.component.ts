import { Component, OnInit } from '@angular/core';
import { RequestService } from '../request.service';
import { Request } from '../request.model';

@Component({
  selector: 'app-request-manage',
  templateUrl: './request-manage.component.html',
  styleUrls: ['./request-manage.component.css']
})
export class RequestManageComponent implements OnInit {

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.getAllPending();
    this.getAllResolved();
    this.getAll();
  }

  errorMsg="";
  pendingFlag=false;
  resolvedFlag=false;
  allFlag = false;

  allPending: Request[] = [];
  allResolved: Request[] = [];
  allRequests: Request[] = [];
  filterKey = 0;


  editTemp: Request = {
    id: 0,
    userId: 0,
    date: "",
    amount: 0,
    status:""
  }

  getAll() {
    this.requestService.getAllRequests().subscribe( 
      (response) => {
        this.allRequests = response;
        console.log(response);
      }, 
      (error) => {
        console.log(error);
        this.errorMsg = "ERROR! GetAllPending";
        console.log(this.errorMsg);
      }
    );

  }

  getAllPending() {
    this.requestService.getAllPending().subscribe( 
      (response) => {
        this.allPending = response;
        console.log(response);
      }, 
      (error) => {
        console.log(error);
        this.errorMsg = "ERROR! GetAllPending";
        console.log(this.errorMsg);
      }
    );
  }

  getAllResolved() {
    this.requestService.getAllResolved().subscribe(
      (response) => {
        this.allResolved = response;
        console.log(response);
      },
      (error) => {
          console.log(error);
      }
      )
    
  }

  setPendingFlag() {
    if(this.pendingFlag) this.pendingFlag=false;
    else this.pendingFlag=true;
  }

  setResolvedFlag() {
    if(this.resolvedFlag) this.resolvedFlag=false;
    else this.resolvedFlag=true;
  }

  setAllFlag() {
    if(this.allFlag) this.allFlag = false;
    else this.allFlag = true;
  }

  approveRequest(req: Request) {
    this.editTemp = req;
    this.editTemp.status = "approved";
    this.requestService.updateRequestService(this.editTemp).subscribe(
      (response) => {
        this.getAllResolved();
        this.getAllPending();
        this.getAll();
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  rejectRequest(req: Request) {
    this.editTemp = req;
    this.editTemp.status = "rejected";
    this.requestService.updateRequestService(this.editTemp).subscribe(
      (response) => {
        this.getAllResolved();
        this.getAllPending();
        this.getAll();
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }



  filterPending(id: number) {
    this.requestService.getAllPendingForUser(id).subscribe(
      (response) => {
        this.allPending = response;
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  filterApproved(id: number) {
    this.requestService.getAllResolvedForUser(id).subscribe(
      (response) => {
        this.allResolved = response;
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  filterAll(id: number) {
    this.requestService.getuserRequestService(id).subscribe(
      (response) => {
        this.allRequests = response;
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  filter() {
    this.filterPending(this.filterKey);
    this.filterApproved(this.filterKey);
    this.filterAll(this.filterKey);
  }

  resetFilter() {
    this.getAllPending();
    this.getAll();
    this.getAllResolved();
  }


}
