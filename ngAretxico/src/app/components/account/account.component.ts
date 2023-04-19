import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent {
  loggedInUser = new User();

  constructor(private router: Router, private auth: AuthService) {}

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser(){
    this.auth.getLoggedInUser().subscribe({
      next: (data) => {
        this.loggedInUser = data;
      },
      error: (err) => {
        console.log(
          'NavbarCompenent.loadUser: Error getting user'
        );
        console.log(err);
      }
    });
  }

}
