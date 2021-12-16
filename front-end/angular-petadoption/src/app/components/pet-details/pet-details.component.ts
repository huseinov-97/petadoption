import { Component, OnInit } from '@angular/core';
import {Pets} from "../../common/pets";
import {PetsService} from "../../services/pets.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-pet-details',
  templateUrl: './pet-details.component.html',
  styleUrls: ['./pet-details.component.css']
})
export class PetDetailsComponent implements OnInit {

  pet: Pets;

  constructor(private service: PetsService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handlePetDetails();
    })
  }

  private handlePetDetails() {
    // @ts-ignore
    const thePetId: number =+ this.route.snapshot.paramMap.get('id');
    this.service.getPet(thePetId).subscribe(
      data => {
        this.pet = data;
      }
    )
  }
}
