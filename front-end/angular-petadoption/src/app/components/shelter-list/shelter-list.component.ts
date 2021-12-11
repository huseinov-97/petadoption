import {Component, OnInit} from '@angular/core';
import {Shelter} from "../../common/shelter";
import {ShelterService} from "../../services/shelter.service";

@Component({
  selector: 'app-shelter-list',
  templateUrl: './shelter-list.component.html',
  styleUrls: ['./shelter-list.component.css']
})
export class ShelterListComponent implements OnInit {

  shelters: Shelter[];

  constructor(private service: ShelterService) {
  }

  ngOnInit(): void {
    this.listShelters();
  }

  listShelters() {
    this.service.getShelterList().subscribe(
      data => {
        //alert(JSON.stringify(data));
        this.shelters = data;
      }
    )
  }
}

