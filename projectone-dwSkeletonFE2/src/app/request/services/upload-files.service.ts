import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UploadFilesService {

  //Might have to come back and change the url
  private baseUrl = 'http://localhost:4040';

  constructor(private http: HttpClient) { }

  upload(file: File, rbid: number): Observable<any> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    return this.http.post(`${this.baseUrl}/api/image/upload/${rbid}`, formData, {
        reportProgress: true, responseType: 'json'
       });
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/api/image/files`);
  }
  
}
