import { Component, OnInit } from '@angular/core';
import { BaseChartDirective } from 'ng2-charts';
import { StatClient } from '../../_service/stat-client';
import { ChartConfiguration, ChartData, ChartType, Chart, registerables } from 'chart.js';
import { CommonModule } from '@angular/common';
import {BookClient} from '../../_service/book-client';
import {Book} from '../../_model/book';

Chart.register(...registerables);

@Component({
  selector: 'app-statistics-component',
  imports: [BaseChartDirective, CommonModule],
  templateUrl: './statistics-component.html',
  styleUrl: './statistics-component.scss'
})
export class StatisticsComponent implements OnInit {


  public genreChartType: 'pie' = 'pie';
  public genreChartData: ChartData<'pie', number[], string | string[]> = { labels: [], datasets: [] };


  public authorChartType: 'bar' = 'bar';
  public authorChartData: ChartData<'bar', number[], string | string[]> = { labels: [], datasets: [] };


  public authorChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
      y: {
        beginAtZero: true,
        ticks: {
          precision: 0
        },
        title: { display: true, text: 'Könyvek száma' }
      }
    },
    plugins: {
      legend: { display: false }
    }
  };

  public publisherChartType: 'bar' = 'bar';
  public publisherChartData: ChartData<'bar', number[], string | string[]> = { labels: [], datasets: [] };
  public publisherChartOptions: ChartConfiguration<'bar'>['options'] = {
    indexAxis: 'y',
    responsive: true,
    maintainAspectRatio: false,
    scales: {
      x: {
        beginAtZero: true,
        ticks: {
          precision: 0
        }
        ,title: { display: true, text: 'Könyvek száma' }
      },
      y: {
        title: { display: true, text: 'Kiadó' }
      }
    },
    plugins: {
      legend: { display: false }
    }
  };

  public totalBookCount: number = 0;
  public totalAuthorCount: number = 0;
  protected books!: Book[];
  public avgPrice!:number;
  public avgPage!:number;
  private temp!: number;


  constructor(private statClient: StatClient,
              private bookClient:BookClient) { }

  ngOnInit(): void {
    this.loadGenreStats();
    this.loadAuthorStats();
    this.loadPublisherStats();
    this.loadAggregateStats();
    this.bookClient.findAll().subscribe(
      {
        next: response => {
          this.books = response;
        }
      }
    )
  }

  getAvgPrice():number{
    this.temp=0;
    for (var book of this.books) {
      this.temp+=book.price;
    }
    return this.avgPrice=this.temp/this.books.length;
  }

  getAvgPage():number{
    this.temp=0;
    for (var book of this.books) {
      this.temp+=book.pageNumber;
    }
    return this.avgPage=this.temp/this.books.length;
  }


  loadAggregateStats(): void {
    this.statClient.getTotalBookCount().subscribe(count => this.totalBookCount = count);
    this.statClient.getTotalAuthorCount().subscribe(count => this.totalAuthorCount = count);


  }


  loadPublisherStats(): void {
    this.statClient.getBooksByPublisher().subscribe(data => {

      const labels = data.map(item => item[0] as string);
      const counts = data.map(item => item[1] as number);

      this.publisherChartData = {
        labels: labels,
        datasets: [{
          data: counts,
          label: 'Könyvek száma kiadó szerint',
          backgroundColor: this.generateColors(labels.length),

          borderWidth: 1
        }]
      };
    });
  }

  loadGenreStats(): void {
    this.statClient.getBooksByGenre().subscribe(data => {

      const labels = data.map(item => item[0]);
      const counts = data.map(item => item[1]);

      this.genreChartData = {
        labels: labels,
        datasets: [{
          data: counts,
          label: 'Könyvek száma műfaj szerint',
          backgroundColor: this.generateColors(labels.length)
        }]
      };
    });
  }

  loadAuthorStats(): void {
    this.statClient.getBookCountByAuthor().subscribe(data => {

      const labels = data.map(item => `${item[0]} ${item[1]}`);
      const counts = data.map(item => item[2]);

      this.authorChartData = {
        labels: labels,
        datasets: [{
          data: counts,
          label: 'Könyvek száma',
          backgroundColor: 'rgba(75, 192, 192, 0.6)',
          borderColor: 'rgba(75, 192, 192, 1)',
          borderWidth: 1
        }]
      };
    });
  }


  private generateColors(count: number): string[] {
    const colors = [];
    for (let i = 0; i < count; i++) {
      const color = `rgba(${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)}, 0.7)`;
      colors.push(color);
    }
    return colors;
  }
}
