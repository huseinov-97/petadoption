import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Pets} from "../common/pets";

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  private petUrl = 'http://localhost:8080/swagger-ui/index.html?urls.primaryName=pet#/pet-controller'

  constructor(private httpClient: HttpClient) { }

  getPetList(): Observable<Pets[]>{
    return this.httpClient.get<GetResponse>(this.petUrl).pipe(
      map(response=> response._embedded.pets)
    );
  }
}

interface GetResponse{
  _embedded: {
    pets: Pets[];
  }
}
