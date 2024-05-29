import { Injectable } from "@angular/core";
import Dexie from "dexie";
import { Project } from "./models";
import { Subject } from "rxjs";

@Injectable()
export class ProjectRepository extends Dexie {

  project!: Dexie.Table<Project, string>

  onCount = new Subject<number>()

  constructor() {
    super('project.db')

    this.version(1).stores({
      project: 'id'
    })
    this.project = this.table('project')
  }

  projectCount(): Promise<number> {
    return this.project.toArray()
        .then(projects => {
          this.onCount.next(projects.length)
          return projects.length
        })
  }

}
