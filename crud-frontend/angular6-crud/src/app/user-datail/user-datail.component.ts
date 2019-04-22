import { Component, OnInit, Input } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-user-datail',
  templateUrl: './user-datail.component.html',
  styleUrls: ['./user-datail.component.css']
})
export class UserDatailComponent implements OnInit {

  @Input() user: User;

  constructor(private userService: UserService, private userDetailComponent: UserDatailComponent) { }

  ngOnInit() {
  }

}
