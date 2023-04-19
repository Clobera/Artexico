import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  username: string = '';
  password: string = '';
  loggedInUser = new User();

  constructor(private router: Router, private auth: AuthService) {}

  login(username: string, password: string) {
    this.auth.login(username, password).subscribe({
      next: (data) => {
        this.router.navigateByUrl('home');
        console.log(data);
      },
      error: (err) => {
        console.log('Error LoginCompenent.login(): error logging in');
      },
    });
  }

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

  loggedInMethod() {
    return this.auth.checkLogin();
  }

  onLogout() {
    this.auth.logout();
    this.router.navigate(['/home']);
  }
}
