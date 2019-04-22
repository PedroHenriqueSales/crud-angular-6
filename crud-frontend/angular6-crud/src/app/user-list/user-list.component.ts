import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: Observable<User[]>;

  constructor(private userService: UserService) { }

  ngOnInit() {
  this.reload();
  }

  reload() {
    this.users = this.userService.getUserList();
  }

  deleteUser(id: number){
    this.userService.deleteUser(id).subscribe(
      data => {
        this.reload();
      },
      error => console.log(error));
  }

}
