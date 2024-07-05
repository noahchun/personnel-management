import { Department } from './department';

export class Employee {
  employeeId: number;
  employeeFirstname: string;
  employeeLastname: string;
  department: Department;
  employeeAge: number;
  detail: { detailId: number, detailText: string } | null;
  certifications: { certificationId: number, certificationName: string }[];

  constructor(
    employeeId: number,
    employeeFirstname: string,
    employeeLastname: string,
    department: Department,
    employeeAge: number,
    detail: { detailId: number, detailText: string } | null,
    certifications: { certificationId: number, certificationName: string }[]
  ) {
    this.employeeId = employeeId;
    this.employeeFirstname = employeeFirstname;
    this.employeeLastname = employeeLastname;
    this.department = department;
    this.employeeAge = employeeAge;
    this.detail = detail;
    this.certifications = certifications;
  }
}
