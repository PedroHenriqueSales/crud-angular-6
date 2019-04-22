import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { Address } from '../../models/address.model';
import { Phone } from '../../models/phone.model';
import { UserService } from '../../providers/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user: User = new User();
  address: Address = new Address();
  phone: Phone = new Phone();
  submitted = false;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  save() {
    this.user.address = this.address;
    this.user.phone = this.phone;
    this.userService.createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
      this.user = new User();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

}
