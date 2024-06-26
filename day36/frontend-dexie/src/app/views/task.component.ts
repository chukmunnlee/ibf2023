import { Component, OnInit, inject } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

import { v4 as uuidv4 } from 'uuid'

import {Project} from '../models';
import { ProjectRepository } from '../project.repository';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrl: './task.component.css'
})
export class TaskComponent implements OnInit {

  private readonly fb = inject(FormBuilder)
  private readonly router = inject(Router)
  private readonly projectRepo = inject(ProjectRepository)

  protected projectForm!: FormGroup
  protected tasksGroup!: FormArray

  ngOnInit(): void {
    this.projectForm = this.createProjecForm()
  }

  private createProjecForm(): FormGroup {
    this.tasksGroup = this.fb.array([])
    return this.fb.group({
      projectName: this.fb.control<string>('', [Validators.required]),
      tasks: this.tasksGroup
    })
  }

  save() {
    const proj: Project = {
      id: uuidv4().substring(0, 8),
      ...this.projectForm.value
    }

    console.info('>>>> proj: ', proj)
    this.projectRepo.project.add(proj)
      .then(id => {
        console.info('>>>> proj.id: ', proj.id)
        console.info('>>>> id: ', id)
        this.router.navigate(['/'])
      })
  }

  addTask() {
    this.tasksGroup.push(
      this.fb.group({
        taskName: this.fb.control<string>('', [ Validators.required ]),
        dueDate: this.fb.control<string>('', [ Validators.required ])
      })
    )
  }

  removeTask(idx: number) {
    this.tasksGroup.removeAt(idx)
  }

}
