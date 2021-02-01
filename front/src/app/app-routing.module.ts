import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SearchComponent } from './component/template/search/search.component'
import { BoardComponent } from './views/board/board.component'

const routes: Routes = [
  {
    path: "",
    component: SearchComponent
  },
  {
    path: ":boardName",
    component: BoardComponent
  },
  {
    path: "**",
    component: SearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
