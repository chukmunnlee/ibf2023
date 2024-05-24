import { Component, OnInit, inject } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {GamesService} from '../games.service';
import {GameDetail} from '../models';

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrl: './game-details.component.css'
})
export class GameDetailsComponent implements OnInit {

  private readonly activatedRoute = inject(ActivatedRoute)
  private readonly gameSvc = inject(GamesService)

  game$!: Promise<GameDetail>
  q = ''
  gameId = 0

  ngOnInit(): void {
    this.q = this.activatedRoute.snapshot.queryParams['q']
    this.gameId = parseInt(this.activatedRoute.snapshot.params['gameId'])
    this.game$ = this.gameSvc.getGameByGameId(this.gameId)
  }

}
