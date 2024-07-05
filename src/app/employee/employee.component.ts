import { Component, EventEmitter, Output } from '@angular/core';
import { Department } from '../models/department';
import { Employee } from '../models/employee';
import { HttpService } from '../services/http.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  @Output() employeeCreated = new EventEmitter<void>();
  employee: Employee = {
    employeeId: 0,
    employeeFirstname: '',
    employeeLastname: '',
    department: {
      departmentId: 0,
      departmentName: '',
      employees: []
    },
    employeeAge: 0,
    detail: {
      detailId: 0,
      detailText: ''
    },
    certifications: []
  };

  constructor(private httpService: HttpService) {}

  createEmployee() {
    this.httpService.createEmployee(this.employee).subscribe(response => {
      console.log('Employee created:', response);
      this.employeeCreated.emit();
      this.resetForm();
    });
  }

  resetForm() {
    this.employee = {
      employeeId: 0,
      employeeFirstname: '',
      employeeLastname: '',
      department: {
        departmentId: 0,
        departmentName: '',
        employees: []
      },
      employeeAge: 0,
      detail: {
        detailId: 0,
        detailText: ''
      },
      certifications: []
    };
  }
}
