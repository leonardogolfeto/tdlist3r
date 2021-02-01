import { Component, OnInit, Input } from '@angular/core';
import { BoardComponent } from '../../../views/board/board.component';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';



@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.sass']
})
export class CardComponent implements OnInit {

  constructor(public dialog: MatDialog, private http : HttpClient, private route: ActivatedRoute, private snackbar: MatSnackBar ) { }

  @Input() card : any
  
  myCompOneObj : BoardComponent

  ngOnInit(): void {

    this.myCompOneObj = new BoardComponent(this.dialog, this.http, this.route, this.snackbar);


  }

  edit(card: any): void {
    console.log(card)
    this.myCompOneObj.openInsertOrEdit(card);
  }

  markCompleted(card: any): void {
    
    card.completed = true;
    this.http.post("http://localhost:8080/todo/api/v1/todo/" + card.id, card).subscribe
    this.snackbar.openFromComponent(OperationSuccessfullSnakBar, {
      duration: 2 * 1000
    });
  }

  delete(card: any): void {
    this.http.delete("http://localhost:8080/todo/api/v1/todo/" + card.id).subscribe(data => {
      this.snackbar.openFromComponent(OperationSuccessfullSnakBar, 
      {duration: 2 * 1000}).afterDismissed().subscribe(o => window.location.reload())
    });
  }



}

@Component({
  selector: 'app-snackbar',
  templateUrl: 'snack-bar.html',
  styles: ['./snack-bar.component.sass'],
})
export class OperationSuccessfullSnakBar {}
