import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Department } from '../models/department';
import { Employee } from '../models/employee';
import { DataPassService } from '../services/data-pass.service';
import { HttpService } from '../services/http.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-department-card',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './department-card.component.html',
  styleUrls: ['./department-card.component.css']
})
export class DepartmentCardComponent {

  constructor(
    private dataPassService: DataPassService,
    private httpService: HttpService,
    private router: Router) {}

  @Input() department: Department = new Department(0, 'asdf', [{ employeeFirstname: 'Joe' }]);
  showEmployeeForm: boolean = false;

  @Output() deleteDepartmentEvent = new EventEmitter<number>();

  deleteThisDepartment() {
    this.deleteDepartmentEvent.emit(this.department.departmentId);
  }

  sendFavoriteDepartment() {
    this.dataPassService.updateFavoriteDepartment(this.department);
  }

  onEmployeeCreated() {
    this.showEmployeeForm = false;
  }

  editDepartment() {
    this.router.navigate(['department/' + this.department.departmentId]);
  }


}

