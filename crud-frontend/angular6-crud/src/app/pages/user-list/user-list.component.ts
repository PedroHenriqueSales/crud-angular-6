import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Router} from "@angular/router";
import { User } from '../../models/user.model';
import { UserService } from '../../providers/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: Observable<User[]>;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.reload();
  }

  reload() {
    this.users = this.userService.getUserList();
  }

  deleteUser(id: number){
    if(confirm("Confirmar exclusão?"))
    this.userService.deleteUser(id).subscribe(
      data => {
        this.reload();
      },
      error => console.log(error));
  }

  editUser(user: User){
    localStorage.removeItem("editUserId");
    localStorage.setItem("editUserId", user.id.toString());
    this.router.navigate(['edit']);
  }

}
