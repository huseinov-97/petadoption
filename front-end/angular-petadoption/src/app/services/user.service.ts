import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../common/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/user/users'

  constructor(private httpClient: HttpClient) {
  }

  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.userUrl);
  }
}

