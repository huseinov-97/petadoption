import {Component, OnInit} from '@angular/core';
import {PetsService} from "../../services/pets.service";
import {Pets} from "../../common/pets";

@Component({
  selector: 'app-pets-list',
  templateUrl: './pets-list-table.component.html',
  styleUrls: ['./pets-list.component.css']
})
export class PetsListComponent implements OnInit {

  pets: Pets[];

  constructor(private service: PetsService) {
  }

  ngOnInit(): void {
    this.listPets();
  }

  listPets() {
    this.service.getPetList().subscribe(
      data => {
        //alert(JSON.stringify(data));
        this.pets = data;
      }
    )
  }
}
