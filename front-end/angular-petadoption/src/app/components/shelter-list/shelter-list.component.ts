import { Component, OnInit } from '@angular/core';
import {Pets} from "../../common/pets";
import {PetsService} from "../../services/pets.service";
import {Shelter} from "../../common/shelter";
import {ShelterService} from "../../services/shelter.service";

@Component({
  selector: 'app-shelter-list',
  templateUrl: './shelter-list.component.html',
  styleUrls: ['./shelter-list.component.css']
})
export class ShelterListComponent implements OnInit {

  shelters: Shelter[];

  constructor(private service: ShelterService) { }

  ngOnInit(): void {
    this.listPets();
  }

  listPets() {
    this.service.getShelterList().subscribe(
      data=> {
        this.shelters = data;
      }
    )
  }
}

