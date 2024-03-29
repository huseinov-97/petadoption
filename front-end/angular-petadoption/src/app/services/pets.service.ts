import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pets} from "../common/pets";

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  private petsUrl = 'http://localhost:8080/pet/pets'

  constructor(private httpClient: HttpClient) {
  }

  getPetList(): Observable<Pets[]> {
    return this.httpClient.get<Pets[]>(this.petsUrl);
  }

  getPet(thePetid: number): Observable<Pets>{
    const petUrl = `${this.petsUrl}/${thePetid}`;

    return this.httpClient.get<Pets>(petUrl);
  }
}
