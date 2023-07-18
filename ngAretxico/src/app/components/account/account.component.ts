import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Borough } from 'src/app/models/borough';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { BoroughService } from 'src/app/services/borough.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent {
  loggedInUser = new User();
  boroughs: Borough[] = [];
  currBoroId: number = 0;
  showUpdateForm: boolean = false;
  selected: null | User = null;


  constructor(private router: Router, private auth: AuthService, private boroServ:BoroughService, private route: ActivatedRoute, private userService: UserService) {}

  ngOnInit(): void {
    let username = this.route.snapshot.paramMap.get('username');
    // idString is getting the username we pass in
    if (username) {
      //if the is found, we assign it to the var username
      if (typeof username !== undefined) {
        // if there is a username value
        this.userService.show(username).subscribe({
          next: (user) => {
            this.selected = user;
            // we will call the show method and assign method to user
          },
          error: (ugh) => {
            console.error(ugh);
            this.router.navigateByUrl('UserNotFound');
          },
        });
      } else {
        this.router.navigateByUrl('invalidUserId');
      }
    }
    this.loadUser();
    this.loadBoroughs();
  }

  loadUser(){
    this.auth.getLoggedInUser().subscribe({
      next: (data) => {
        this.loggedInUser = data;
        this.currBoroId = this.loggedInUser.borough.id;

      },
      error: (ugh) => {
        console.log(
          'NavbarCompenent.loadUser: Error getting user'
        );
        console.log(ugh);
      }
    });
  }

  update(user: User, username: string): void {
    this.userService.update(user, username).subscribe({
      next: (result) => {
        this.selected = user;
        this.loadUser();
        this.showUpdateForm = false;
      },
      error: (ugh) => {
        console.error('UserListComponent.updateUser(): error updating User: ');
        console.error(ugh);
      },
    });
  }

  loadBoroughs(){
    this.boroServ.indexNoCred().subscribe({
      next: (data) => {
        this.boroughs = data;
      },
      error: (err) => {
        console.log(
          'RegisterComponent.loadBoroughs: Error loading boroughs ' + err
        );
      },
    });
  }


}
