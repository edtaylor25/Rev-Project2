import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { user } from './user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:4040/api/user";

  constructor(private http: HttpClient) { }


  getLoggedIn(email: string, password: string): Observable<user>{
      return this.http.get<user>(this.baseUrl+"/login/"+email+"/"+password);
  }

  getUserInfo(userId: number): Observable<user> {
    return this.http.get<user>(this.baseUrl+"/"+userId);
  }

  getAllUsers(): Observable<user[]> {
    return this.http.get<user[]>(this.baseUrl);
  }

  updateUser(currUser: user): Observable<user> {
    return this.http.put<user>(this.baseUrl, currUser);
  }
  getAllManagers(): Observable<user[]> {
    return this.http.get<user[]>(this.baseUrl+"/permission/manager");
  }
  getAllEmployees(): Observable<user[]> {
    return this.http.get<user[]>(this.baseUrl+"/permission/employee");
  }


}
