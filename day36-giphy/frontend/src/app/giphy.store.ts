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

  readonly getSavedSearchesByQ = (qText: string) =>
    this.select<SearchResult | undefined>(
      (currStore: SearchResultSlice) =>
        currStore.results.find(s => s.q == qText)
    )

  readonly f = (x: number) =>
    (n: number) => {
      console.info(`n: ${n}, x: ${x}`)
    }

  readonly getFullSavedSearches = this.select<SearchResult[]>(
    (currStore: SearchResultSlice) => currStore.results
  )

  readonly getCachedResultCount = this.select<number>(
    // SQL
    (currStore: SearchResultSlice) => currStore.results.length
  )

}
