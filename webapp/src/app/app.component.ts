import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient  } from  '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, FormsModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webaapp';
  index:number = 0;
  output?:string;

  constructor(private http: HttpClient) { }

  execute() {
    this.http.get('http://localhost:9000/labseq/' + this.index).subscribe(
      (response:any) => {
console.log(response);
        this.output = String(response)
      },
	    (error) => { console.log('error ', error); }
);
  }
}

