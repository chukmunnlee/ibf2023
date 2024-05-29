import { Component, OnInit, inject } from '@angular/core';
import { ProjectRepository } from '../project.repository';
import { ProjectInfo } from '../models';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit {

  private readonly projectRepo = inject(ProjectRepository)
  private readonly projectSvc = inject(ProjectService)

  projectInfo: ProjectInfo[] = []
  projectInfo$!: Promise<ProjectInfo[]>

  ngOnInit(): void {
    // this.projectRepo.project.toArray()
    //   .then(projects => {
    //     this.projectInfo = projects.map(p => {
    //       return {
    //         id: p.id,
    //         projectName: p.projectName,
    //         taskCount: p.tasks.length
    //       } as ProjectInfo
    //     })
    //   })
    this.projectInfo$ = this.getProjects()
    this.projectRepo.projectCount()
  }

  persist() {
    this.projectRepo.project.toArray()
      //.then(this.projectSvc.save.bind(this))
      .then(projects => this.projectSvc.save(projects))
      .then(result => {
        console.info('>>>> result: ', result)
      })
      .catch(error => {
        console.error('>>>> error: ', error)
      })

  }

  deleteProject(projId: string) {
    this.projectInfo$ = this.projectRepo.project.delete(projId)
      .then(result => {
        console.info('>>>> deleted: ', result)
        this.projectRepo.projectCount()
        return this.getProjects()
      })
  }

  private getProjects(): Promise<ProjectInfo[]> {
    return this.projectRepo.project.toArray()
      .then(projects => {
        return projects.map(p => {
          return {
            id: p.id,
            projectName: p.projectName,
            taskCount: p.tasks.length
          } as ProjectInfo
        })
      })
  }

}
