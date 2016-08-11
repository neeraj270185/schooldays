package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp1 {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person(2, "ram", "IN", 2.5));
		persons.add(new Person(3, "sofia", "SE", 125.01));
		persons.add(new Person(4, "john", "US", 12.5));
		persons.add(new Person(5, "krish", "IN", .5));
		persons.add(new Person(1, "Peter", "US", 12.5));

		List<Person> usPersons = new ArrayList<>();
		persons.stream().filter(person -> person.getCountry().equals("US"))
				.forEach(person -> usPersons.add(person));
		
		usPersons.stream().forEach(person -> System.out.println(person));
		
		System.out.println("-------------------------------------------------------------");
		persons.stream().filter(person -> (person.getSalary()> 100)).forEach(person -> System.out.println(person));
		System.out.println("-------------------------------------------------------------");
		persons.stream()
				.filter(person -> person.getName().toUpperCase().startsWith("P"))
				.forEach(System.out::println);
				
		
		//A_persons.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
		
	}

}
