
import {Component} from '@angular/core';
import { AuthService} from '../../_service/auth-service';
import {Router, RouterLink} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './login-component.html',
  styleUrls: ['./login-component.scss']
})
export class LoginComponent {
  username = '';
  password = '';

  loading = false;
  errorMessage = '';

  constructor(protected auth: AuthService, private router: Router) {}

  onSubmit() {
    this.loading = true;
    this.errorMessage = '';

    this.auth.login(this.username, this.password).subscribe({
      next: () => {
        this.loading = false;
        this.router.navigate(['/']);
      },
      error: (err: HttpErrorResponse) => {
        this.loading = false;
        if (err.status === 401) {
          this.errorMessage = 'Hibás felhasználónév vagy jelszó!';
        } else {

          this.errorMessage = 'Hiba történt a bejelentkezés során.';
        }
      }
    });
  }
}
