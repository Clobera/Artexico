import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  user: User = new User();


  constructor(private auth: AuthService, private router : Router){}
  ngOnInit(){}

  // METHOD TO REGISTER USER
  register(user: User) {
    this.auth.register(user).subscribe({
      next: (data) => {
        console.log(this.user)
        // this.login(this.user);
      },
      error: (err) => {
        console.log("ERROR RegisterComponent.register(): Error registering new user");
      }
    })
  }

}
