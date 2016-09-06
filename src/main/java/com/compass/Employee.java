package com.compass;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id", nullable = false)
	private Long id;

	@Column(unique = true)

	private String username;

	@Column(name = "role", nullable = false)
	private String role;

	public Employee() {
	}

	public Employee(String username, String role) {

		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}
}
