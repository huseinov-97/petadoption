import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Shelter} from "../common/shelter";

@Injectable({
  providedIn: 'root'
})
export class ShelterService {

  private shelterUrl = 'http://localhost:8080/shelter/shelters'

  constructor(private httpClient: HttpClient) {
  }

  getShelterList(): Observable<Shelter[]> {
    return this.httpClient.get<GetResponse>(this.shelterUrl).pipe(
      map(response => response._embedded.shelters)
    );
  }
}

interface GetResponse {
  _embedded: {
    shelters: Shelter[];
  }
}
