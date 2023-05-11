import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Borough } from 'src/app/models/borough';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { BoroughService } from 'src/app/services/borough.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  user: User = new User();
  boroughs: Borough[] = [];
  currBoroId: number = 0;


  constructor(private auth: AuthService, private router : Router, private boroServ:BoroughService){}
  ngOnInit(){
    this.loadBoroughs();
  }


  loadBoroughs(){
    this.boroServ.indexNoCred().subscribe({
      next: (data) => {
        this.boroughs = data;
        console.log(data);
      },
      error: (err) => {
        console.log(
          'RegisterComponent.loadBoroughs: Error loading boroughs ' + err
        );
      },
    });
  }

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
