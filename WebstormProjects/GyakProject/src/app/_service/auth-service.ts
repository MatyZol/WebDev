import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8082/api/auth';

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    return this.http.post<any>(`${this.apiUrl}/login`, { username, password })
      .pipe(
        tap(res => {
          if (res.token) {
            localStorage.setItem('token', res.token);
          }
        })
      );
  }

  // register(username: string, password: string) {
  //   return this.http.post<any>(`${this.apiUrl}/register`, { username, password })
  //     .pipe(
  //       tap(res => {
  //         if (res.token) {
  //           localStorage.setItem('token', res.token);
  //         }
  //       })
  //     );
  // }
  register(username: string, password: string) {
    // A post<any> maradhat, de most már tudjuk, hogy nem token jön vissza
    return this.http.post<any>(`${this.apiUrl}/register`, { username, password })
      .pipe(
        tap(() => {
          // KIVÉVE: A token tárolása a regisztrációból!
          // if (res.token) {
          //   localStorage.setItem('token', res.token);
          // }

          // Ezen a ponton már nincs szükség kódra, a komponensre bízzuk az átirányítást
        })
      );
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
}
