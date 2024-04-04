import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatGridListModule} from '@angular/material/grid-list';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
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
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {

  loginUrl = "http://localhost:8080/api/auth/login";
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
      params: {"username": this.username, "password": this.password},
    }

    let response = this.http.post(this.loginUrl, this.data, options);
    
    response.subscribe({
      next: (data: any) => {
        this.loginValid = true;
        console.log(data);
        localStorage.setItem("username", this.username);
        localStorage.setItem("userId", data.body.userId);
        this.router.navigateByUrl('/specification-files');
      },
      error: (error: HttpErrorResponse) => {
        this.loginValid = false;
        console.log("error: ", error);
        alert(error.message);
      }
    }); 
  }
}
