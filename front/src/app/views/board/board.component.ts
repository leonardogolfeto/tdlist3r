import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { OperationSuccessfullSnakBar } from '../../component/template/card/card.component'
import { from } from 'rxjs';


@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.sass']
})
export class BoardComponent implements OnInit {

  boardName: string
  apiURL: string

  constructor(public dialog: MatDialog, private http : HttpClient, private route: ActivatedRoute, private snackbar: MatSnackBar) { 

    this.route.params.subscribe(params => this.boardName = params['boardName']);

  }
 
  cards: any


  ngOnInit(): void {
    this.apiURL = 'http://localhost:8080/todo/api/v1/todo/';
    this.http.get(this.apiURL + this.boardName).subscribe(result => { this.cards = result;
      if(this.cards.length == 0) {
        this.http.post("http://localhost:8080/todo/api/v1/todo/", {
          'boardName' : this.boardName,
          'description' : "Your board is empty, click to edit or create a new activity"}).subscribe(data => this.cards.push(data))
      }})
  }

  openInsertOrEdit(cardToEdit: any): void {

    if(cardToEdit == null) {
      
        this.dialog.open(InsertCardComponent).afterClosed().subscribe(result => {
          
          if(result) {
          result.boardName = this.boardName;
          this.http.post("http://localhost:8080/todo/api/v1/todo/", result).subscribe(data => {this.cards.push(data); this.snackbar.openFromComponent(OperationSuccessfullSnakBar, {
            duration: 2 * 1000
          })})
          console.log(result)
        }
        });

    } else {
        this.dialog.open(InsertCardComponent, {data: cardToEdit}).afterClosed().subscribe(result => {
          
          if(result) {
          let newObject = cardToEdit
          newObject.description = result.description;
          newObject.completionDate = result.completionDate;
          newObject.hoursSpent = result.hoursSpent
          newObject = this.http.post("http://localhost:8080/todo/api/v1/todo/" + cardToEdit.id, newObject).subscribe(data => 
          this.snackbar.openFromComponent(OperationSuccessfullSnakBar, {
            duration: 2 * 1000,
          }))
        }
        });
        
    }    
}
}


@Component({
  selector: 'app-insert',
  templateUrl: './insert-card.component.html',
  styleUrls: ['./insert-card.component.sass']
})
export class InsertCardComponent implements OnInit {

  ngOnInit(): void {
    if(this.card == null)
      this.card = {}
  }

  constructor(@Inject(MAT_DIALOG_DATA)public card: any) {}

}