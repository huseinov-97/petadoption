import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PetsListComponent} from "./components/pets-list/pets-list.component";
import {ShelterListComponent} from "./components/shelter-list/shelter-list.component";
import {UserListComponent} from "./components/user-list/user-list.component";
import {PetDetailsComponent} from "./components/pet-details/pet-details.component";
import {ShelterDetailsComponent} from "./components/shelter-details/shelter-details.component";

const routes: Routes = [
  {
    path: 'pets',
    component: PetsListComponent
  },
  {
    path: 'pets/:id',
    component: PetDetailsComponent
  },
  {
    path: 'shelters',
    component: ShelterListComponent
  },
  {
    path: 'shelters/:id',
    component: ShelterDetailsComponent
  },
  {
    path: 'users',
    component: UserListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
