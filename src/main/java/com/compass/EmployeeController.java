package com.compass;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)

	public String create(@RequestBody Employee employee) {
		try {
			employeeRepository.save(employee);
			// return employeeRepository.findAll();
			return "employee added successfully";
		} catch (DataIntegrityViolationException e) {

			String role = employee.getRole();
			String employeename = employee.getUsername();
			return "employee named " + employeename + " already exists and his role is " + role;
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable long id) {
		try {
			employeeRepository.delete(id);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	
	@RequestMapping(value="/find/id/{id}" , method = RequestMethod.GET)
	public String findEmployeeById(@PathVariable long id)
	{
	
		List<Employee> em = employeeRepository.findById(id);
		String name = em.get(0).getUsername();
		String role=em.get(0).getRole();
		
		
		return "Employee name is " + name +" and role is " + role ;
		
	}
	
	
	@RequestMapping(value="/find/username/{username}" , method = RequestMethod.GET)
	public String findEmployeeByUserName(@PathVariable String username)
	{
	
		List<Employee> em = employeeRepository.findByUsername(username);
		long id = em.get(0).getId();
		String role=em.get(0).getRole();
		
		
		return "Employee ID is " + id +" and role is " + role ;
		
	}
	
	@RequestMapping(value="/find/role/{role}" , method = RequestMethod.GET)
	public List<Employee> findEmployeeByRole(@PathVariable String role)
	{
	
		List<Employee> em = employeeRepository.findByRole(role);
		
		
		
		
		return em;
		
	}

}
