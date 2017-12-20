package javaapplication7;

// The Person persistent class
public class Person {
	// Persistent Fields:
	private String firstName;
	private String lastName;
	private int age;

	// Constructors:
	public Person() {
	}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// String Representation:
	public String toString() {
		return firstName + " " + lastName + " (" + age + ")";
	}

	public void set(String fn, String ln, int age) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = age;
	}
}