import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { RouterLink, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatGridListModule,
    RouterLink,
    FormsModule,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  registerURL ="http://localhost:8080/api/auth/register";

  username: string = '';
  password: string = '';
  loginValid: boolean = true;
  data = null;

  constructor(private http: HttpClient, private router: Router) {
  }

  public onSubmit(){
    this.loginValid = true;

    let options: Object = {
      observe: "response",
      responseType: 'json',
      params: {"username": this.username, "password": this.password, "role":"user"},
    }

    let response = this.http.post(this.registerURL, this.data, options);
    
    response.subscribe({
      next: (data: any) => {
        this.loginValid = true;
        localStorage.setItem("username", this.username);
        localStorage.setItem("userId", data.body.userId);
        this.router.navigateByUrl('/specification-files');
      },
      error: (error: HttpErrorResponse) => {
        this.loginValid = false;
        alert(`Username already exists: ${this.username}`);
      }
    });
  }
}
