import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Request } from './request.model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RequestService {


  baseUrl = "http://localhost:4040/api/request";


  constructor(private http: HttpClient) { }
    
  getAllRequests() : Observable<Request[]>{
    return this.http.get<Request[]>(this.baseUrl);
  }

  addRequestService(newRequest: Request): Observable<Request>{
      console.log(newRequest.userId);
      return this.http.post<Request>(this.baseUrl, newRequest); //{
        // "id": newRequest.userId,
        // "date": newRequest.date,
        // "amount": newRequest.amount,
        // "status": newRequest.status
  // });
  }

  removeRequestService(requestId: number): Observable<Request> {
      return this.http.delete<Request>(this.baseUrl + "/" +requestId );
  }

  getuserRequestService(userId: number): Observable<Request[]> {
    return this.http.get<Request[]>(this.baseUrl+"/"+userId);
  }

  updateRequestService(updateRequest: Request): Observable<Request> {
    return this.http.put<Request>(this.baseUrl+"/"+updateRequest.id+"/"+updateRequest.status, updateRequest);
  }

  getAllPending(): Observable<Request[]>{
      console.log(this.baseUrl+ "pending");
      return this.http.get<Request[]>(this.baseUrl+"pending");
  }

  getAllPendingForUser(userId: number): Observable<Request[]> {
    return this.http.get<Request[]>(this.baseUrl+"/pending/"+userId);
  }

  getAllResolved(): Observable<Request[]> {
    return this.http.get<Request[]>(this.baseUrl+"resolved");
  }

  getAllResolvedForUser(userId: number): Observable<Request[]> {
    return this.http.get<Request[]>(this.baseUrl+"/resolved/"+userId);
  }

}
