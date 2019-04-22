import { Component, OnInit } from '@angular/core';
import { User } from '../user.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { Phone } from '../phone.model';
import { Address } from '../address.model';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user: User = new User();
  address: Address = new Address();
  phone: Phone = new Phone();
  constructor(private router: Router, private userService: UserService) { 
    this.user.address = this.address;
    this.user.phone = this.phone;
  }

  ngOnInit() {
    let userId = localStorage.getItem("editUserId");
    if(!userId) {
      alert("Invalid action.")
      this.router.navigate(['users']);
      return;
    }
   
    this.userService.getUser(+userId)
      .subscribe( data => {
        this.user = data;
      });
  }

  onSubmit() {
    this.userService.updateUser(this.user.id, this.user)
      .subscribe(
        data => {
          this.router.navigate(['users']);
        },
        error => {
          alert(error);
        });
  }


}
