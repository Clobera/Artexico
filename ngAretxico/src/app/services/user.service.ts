import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // url = environment.baseUrl + "api/users";
  private url = 'http://localhost:8090/';
  constructor(private http : HttpClient, private auth : AuthService) { }

  show(username: string): Observable<User> {
    return this.http.get<User>(`${this.url}/${username}`, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('UserService.show(): error retrieving user: ' + err)
        );
      })
    );
  }

  update(user: User, username: string): Observable<User> {
    return this.http.put<User>(`${this.url}/${username}`, user, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('UserService.update(): error updating user: ' + err)
        );
      })
    );
  }

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }
}
