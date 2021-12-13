import { Component, OnInit } from '@angular/core';
import {ShelterService} from "../../services/shelter.service";
import {ActivatedRoute} from "@angular/router";
import {Shelter} from "../../common/shelter";

@Component({
  selector: 'app-shelter-details',
  templateUrl: './shelter-details.component.html',
  styleUrls: ['./shelter-details.component.css']
})
export class ShelterDetailsComponent implements OnInit {

  shelter: Shelter;

  constructor(private service: ShelterService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleShelterDetails();
    })
  }

  private handleShelterDetails() {
    // @ts-ignore
    const shelterId: number =+ this.route.snapshot.paramMap.get('id');

    this.service.getShelter(shelterId).subscribe(
      data =>{
        this.shelter = data;
      }
    )
  }
}
