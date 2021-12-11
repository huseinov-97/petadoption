import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Shelter} from "../common/shelter";

@Injectable({
  providedIn: 'root'
})
export class ShelterService {

  private shelterUrl = 'http://localhost:8080/shelter/shelters'

  constructor(private httpClient: HttpClient) {
  }

  getShelterList(): Observable<Shelter[]> {
    return this.httpClient.get<Shelter[]>(this.shelterUrl);
  }
}

