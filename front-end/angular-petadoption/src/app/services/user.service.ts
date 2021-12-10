import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {User} from "../common/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/user/users'

  constructor(private httpClient: HttpClient) {
  }

  getUserList(): Observable<User[]> {
    return this.httpClient.get<GetResponse>(this.userUrl).pipe(
      map(response => response._embedded.users)
    );
  }
}

interface GetResponse {
  _embedded: {
    users: User[];
  }
}
