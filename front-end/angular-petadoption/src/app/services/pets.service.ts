import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  private petUrl = 'http://pet-service:8080'

  constructor(private httpClient: HttpClient) { }

  // getPetList(): Observable<Pets[]>{
  //   return this.httpClient.get(this.petUrl).pipe(
  //     map(response => response._embedded.pets)
  //   )
  //
  // }
}
