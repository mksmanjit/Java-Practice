package javaapplication7;

// Main of the JDO Person sample.
import java.util.*;
import javax.jdo.*;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// Obtain a database connection:
			Properties properties = new Properties();
			properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
					"com.objectdb.jdo.PMF");
			properties.setProperty("javax.jdo.option.ConnectionURL",
					"persons.odb");
			PersistenceManagerFactory pmf = JDOHelper
					.getPersistenceManagerFactory(properties);
			PersistenceManager pm = pmf.getPersistenceManager();
			try {
				// Begin the transaction:
				pm.currentTransaction().begin();
				System.out
						.println("Enter the number of records to be inserted :");
				int count = sc.nextInt();
				// Accpet the data to be inserted
				int i = 0;
				for (i = 0; i < count; i++) {
					System.out.println("Enter first name :");
					String fn = sc.next();
					System.out.println("Enter last name :");
					String ln = sc.next();
					System.out.println("Enter age :");
					int age = sc.nextInt();
					// Create and store a new Person instance:
					Person person = new Person(fn, ln, age);
					pm.makePersistent(person);
				}
				pm.currentTransaction().commit();
				pm.currentTransaction().begin();
				// Print all the Persons in the database:
				System.out
						.println("Printing all the records in the database :");
				Extent extent = pm.getExtent(Person.class, false);
				Iterator itr = extent.iterator();
				while (itr.hasNext())
					System.out.println(itr.next());
				extent.closeAll();
				// Print all the Persons in the database having age > 18:
				System.out
						.println("Printing all the records in the database having age > 22 :");
				Query query = pm.newQuery(Person.class, "this.age >= 22");
				Collection result = (Collection) query.execute();
				itr = result.iterator();
				while (itr.hasNext())
					System.out.println(itr.next());
				// Update the Persons where first name = fn
				System.out.println("Updating the records :");
				// 1.Accpet fn
				System.out.println("Enter first name :");
				String fn = sc.next();
				// 2. Build a query to look up product by the id
				query = pm.newQuery(Person.class, "firstName == '" + fn + "'");
				// 3. execute query
				result = (Collection) query.execute();
				Person toBeEdited = (Person) result.iterator().next();
				if (toBeEdited == null) {
					System.out.println("did not find a matching instance...");
					pm.currentTransaction().rollback();
					return;
				}
				// 4. edit the existing entry
				System.out
						.println("Enter the new data that is to be inserted :");
				System.out.println("Enter first name :");
				fn = sc.next();
				System.out.println("Enter last name :");
				String ln = sc.next();
				System.out.println("Enter age :");
				int age = sc.nextInt();
				toBeEdited.set(fn, ln, age);
				pm.currentTransaction().commit();
				pm.currentTransaction().begin();
				// Print all the Persons in the database order by age
				System.out
						.println("Printing all the Persons in the database order by age :");
				query = pm.newQuery(Person.class);
				query.setOrdering("this.age ascending");
				result = (Collection) query.execute();
				itr = result.iterator();
				while (itr.hasNext())
					System.out.println(itr.next());
				pm.currentTransaction().commit();
				pm.currentTransaction().begin();
				// Deleting a record from database
				System.out.println("Deleting a record from database :");
				// 1.Accept the age of person to be deleted
				System.out.println("Enter the age of person to be deleted :");
				age = sc.nextInt();
				// 2. Build a query to look up person by the age
				query = pm.newQuery(Person.class, "age == " + age);
				// 3. execute query
				result = (Collection) query.execute();
				// 4. if no matching product was found, print a message
				if (result.isEmpty()) {
					System.out
							.println("did not find a Product with age=" + age);
					pm.currentTransaction().rollback();
					pm.close();
					return;
				}
				// 5. if a matching product was found, delete it
				else {
					Person toBeDeleted = (Person) result.iterator().next();
					pm.deletePersistent(toBeDeleted);
				}
				pm.currentTransaction().commit();
				pm.currentTransaction().begin();
				// Print all the Persons in the database order by first name
				System.out
						.println("Printing all the Persons in the database order by first name :");
				query = pm.newQuery(Person.class);
				query.setOrdering("this.firstName ascending");
				result = (Collection) query.execute();
				itr = result.iterator();
				while (itr.hasNext())
					System.out.println(itr.next());
				// Commit the transaction:
				pm.currentTransaction().commit();
			} finally {
				// Close the database and active transaction:
				// if (pm.currentTransaction().isActive())
				// pm.currentTransaction().rollback();
				if (!pm.isClosed())
					pm.close();
			}
		}
		// Handle both JDOException and NumberFormatException:
		catch (RuntimeException x) {
			System.err.println("Error: " + x.getMessage());
		}
		sc.close();
	}
}