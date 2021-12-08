import { Component, OnInit } from '@angular/core';
import {Shelter} from "../../common/shelter";
import {ShelterService} from "../../services/shelter.service";
import {User} from "../../common/user";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.listUsers();
  }

  listUsers() {
    this.service.getUserList().subscribe(
      data=> {
        this.users = data;
      }
    )
  }
}
