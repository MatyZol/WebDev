import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService} from '../../_service/auth-service';
import {Router, RouterLink} from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './register-component.html',
  styleUrls: ['./register-component.scss']
})
export class RegisterComponent {

  username = '';
  password = '';
  errorMessage = '';
  loading = false;

  constructor(private auth: AuthService, private router: Router) {}

  onSubmit() {
    this.loading = true;
    this.errorMessage = '';

    this.auth.register(this.username, this.password).subscribe({
      next: () => {
        this.loading = false;


        this.router.navigate(['/login']);
      },
      error: (err: HttpErrorResponse) => {
        this.loading = false;
        if (err.status === 409) {
          this.errorMessage = 'A felhasználónév már foglalt!';
        } else {

          this.errorMessage = 'Hiba történt a regisztráció során.';
        }
      }
    });
  }
}
