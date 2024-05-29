import { Injectable } from "@angular/core";
import { ComponentStore } from "@ngrx/component-store";
import { SearchResult, SearchResultSlice } from "./models";

const INIT_VALUE: SearchResultSlice = {
  results: []
}

@Injectable()
export class GiphyStore extends ComponentStore<SearchResultSlice> {

  constructor() { super(INIT_VALUE) }

  // updater / reducer
  readonly saveResult = this.updater<SearchResult>(
    (currStore: SearchResultSlice, result: SearchResult) => {
      // create a new copy of the store
      const newStore: SearchResultSlice = { ...currStore }
      newStore.results.push(result)
      return newStore
    }
  )

  // query / selector
  readonly getSavedSearches = this.select<string[]>(
    (currStore: SearchResultSlice) => {
      return currStore.results.map(result => result.q)
    }
  )

}
