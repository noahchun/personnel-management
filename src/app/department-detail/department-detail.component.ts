import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../models/department';
import { Employee } from '../models/employee';
import { HttpService } from '../services/http.service';
import { HttpResponse } from '@angular/common/http'; // Import HttpResponse
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-department-detail',
  standalone: true,
  templateUrl: './department-detail.component.html',
  styleUrls: ['./department-detail.component.css'],
  imports: [
    CommonModule,
    FormsModule 
  ]
})
export class DepartmentDetailComponent {
  dept: Department = new Department(0, '', []);
  updatedDepartment: Department = new Department(0, '', []);
  newEmployee: Employee = {
    employeeId: 0,
    employeeFirstname: '',
    employeeLastname: '',
    department: new Department(0, '', []),
    employeeAge: 0,
    detail: { detailId: 0, detailText: '' },
    certifications: []
  };
  removeEmployeeId: number = 0;

  constructor(private route: ActivatedRoute, private httpService: HttpService, private router: Router) {
    this.route.params.subscribe(() => {
      this.getDepartmentById();
    });
  }

  getDepartmentById() {
    const id = this.route.snapshot.params['id'];
    this.httpService.getDepartmentById(id)
      .subscribe((response: HttpResponse<any>) => {
        if (response.body) {
          this.dept = response.body as Department; 
          this.updatedDepartment = { ...this.dept }; 
        }
      });
  }

  updateDepartment() {
    this.httpService.updateDepartment(this.updatedDepartment, this.dept.departmentId)
      .subscribe(
        () => this.router.navigate(['department/' + this.updatedDepartment.departmentId])
        //this.getDepartmentById(); // Refresh department details after update
      );
  }

  addEmployee() {
    let employee = this.newEmployee;
    employee.department = { departmentId: 0, departmentName: this.dept.departmentName, employees: [] };
    employee.department.departmentId = this.dept.departmentId;
    if (!employee.detail) {
      employee.detail = { detailId: 0, detailText: "Default detail text" }; 
    } else if (!employee.detail.detailText) {
      employee.detail.detailText = "Default detail text";
    }
    
    this.httpService.createEmployee(employee)
      .subscribe((response: HttpResponse<any>) => {
        if (response.body) {
          const newEmployee = response.body as Employee;
          this.dept.employees.push(newEmployee); 
          this.resetNewEmployee(); 
        }
      });
  }

  removeEmployee(employeeId: number) {
    this.httpService.removeEmployee(employeeId)
      .subscribe(() => {
        this.dept.employees = this.dept.employees.filter(emp => emp.employeeId !== employeeId);
        this.removeEmployeeId = 0; 
      }, error => {
        console.error('Failed to remove employee:', error);
      });
  }
  
  
  

  resetNewEmployee() {
    this.newEmployee = {
      employeeId: 0,
      employeeFirstname: '',
      employeeLastname: '',
      department: new Department(0, '', []),
      employeeAge: 0,
      detail: { detailId: 0, detailText: '' },
      certifications: []
    };
  }
}

