import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/users/auth.service';
import { Request } from '../../request.model';
import { RequestService } from '../../request.service';
import { UploadFilesService } from '../../services/upload-files.service';
@Component({
  selector: 'app-request-list-pending',
  templateUrl: './request-list-pending.component.html',
  styleUrls: ['./request-list-pending.component.css']
})
export class RequestListPendingComponent implements OnInit {
 
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';
  fileInfos?: Observable<any>;

  constructor( private requestService: RequestService, private uploadService: UploadFilesService, private authService: AuthService) { 

  }
    ngOnInit(): void {
    }
    allPending: Request[]= [];
    allResolved: Request[]=[];
    
    newFlag = false;
    errorMsg: string='';
    pendingFlag = false;
    resolvedFlag = false;

    newPending= {
      userId:0,
      id:0,
      date:"",
      amount:0,
      status:"pending"
      
    }

   loadPendingRequests() {
     this.requestService.getAllPendingForUser(Number(sessionStorage.getItem("userId"))).subscribe(
       (response) => {
          console.log(response);
          this.allPending=response;
       },
       (error) => {
          console.log(error);
          this.errorMsg = 'Error!!';
          console.log(this.errorMsg);
       }
       
     );
   }

   loadResolvedRequests() {
    this.requestService.getAllResolvedForUser(Number(sessionStorage.getItem("userId"))).subscribe(
      (response) => {
         console.log(response);
         this.allResolved=response;
      },
      (error) => {
         console.log(error);
         this.errorMsg = 'Error!!';
         console.log(this.errorMsg);
      }
    );
   }

  removeRequest(id: number) {
    this.requestService.removeRequestService(id).subscribe(
      (response) => {
        console.log(response);
        this.loadPendingRequests();
      },
      (error) => {
        console.log(error);
        this.errorMsg='error!!';
        console.log(this.errorMsg);
      }
    );
  }

  addRequest() {
  // this.newPending.userId=this.authService.retrieveUser().user.id;
   this.newPending.userId = 1;
    this.requestService.addRequestService(this.newPending).subscribe(
      (response) => {
        console.log(response);
        this.upload(response.id);
        this.loadPendingRequests();
      },
      (error) => {
        console.log(error);
      }
    )
  }

  setNewFlag() {
    if (this.newFlag == true) this.newFlag=false;
    else this.newFlag = true;
    this.newPending.userId = (Number(sessionStorage.getItem("userId")));
  }

  setPendingFlag() {
    this.loadPendingRequests();
    if (this.pendingFlag==true) this.pendingFlag=false;
    else this.pendingFlag=true;
  }

  setResolvedFlag() {
    this.loadResolvedRequests();
    if (this.resolvedFlag==true) this.resolvedFlag=false;
    else this.resolvedFlag=true;
  }

  upload(rbid: number): void {
    this.progress = 0;
    this.message= '';

    if(this.selectedFiles){
      const file: File | null = this.selectedFiles.item(0);

      if(file){
        this.currentFile = file;
        this.uploadService.upload(this.currentFile, rbid).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              this.fileInfos = this.uploadService.getFiles();
            }
            this.loadPendingRequests();
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
            this.currentFile = undefined;
          });
      }
      this.selectedFiles = undefined;
    }
  }

  onFileChanged(event:any): void {
    this.selectedFiles = event.target.files;
  }
}


