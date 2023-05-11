import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Borough } from '../models/borough';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BoroughService {

  url = environment.baseUrl + "api/boroughs"

  indexNoCred(): Observable<Borough[]> {
    let httpOptions = {
      headers: {
        Authorization: 'Basic ' + 'Y2xvYmVyYTp3b21iYXQx',
        'X-Requested-with': 'XMLHttpRequest',
      }
    };
    // return this.httpClient.get<Borough[]>(this.url, httpOptions).pipe(
    return this.httpClient.get<Borough[]>("http://localhost:8090/api/boroughs", httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
              'BoroughService.index(): error retrieving Boroughs: ' + err
            )
        );
      })
    );
  }

  constructor(private httpClient : HttpClient, private auth : AuthService) { }
}
