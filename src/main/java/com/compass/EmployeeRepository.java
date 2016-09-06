package com.compass;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findById(long id);
	List<Employee> findByRole(String role);
	List<Employee> findByUsername(String username);

}
