import { Employee } from './employee';
import { Department } from './department';

describe('Employee', () => {
  it('should create an instance', () => {
    expect(new Employee(1, '', '', new Department(1, 'HR', []), 30, null, [])).toBeTruthy();
  });

  
});
