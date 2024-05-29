import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Project } from "./models";
import { firstValueFrom } from "rxjs";

@Injectable()
export class ProjectService {

  private readonly http = inject(HttpClient)

  save(projects: Project[]): Promise<any> {
    console.error('http: ', this.http)
    return firstValueFrom(
      this.http.post<any>('/api/projects', projects)
    )
  }
}
