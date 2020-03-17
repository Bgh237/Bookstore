package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			Category fant = new Category("Fantasy");
			Category rom = new Category("Romance");
			Category fict = new Category("Fiction");
			Category nonf = new Category("Non-Fiction");
			
			crepository.save(fant);
			crepository.save(rom);
			crepository.save(fict);
			crepository.save(nonf);
			
			Book af = new Book("Animal Farm", "George Orwell", "aaaaaaaaa", 10.50, 1945, fict);
			Book hp = new Book("Harry Potter", "J.K Rowling", "bbbbbbbbb", 15.50, 1997, fant);
			Book lotr = new Book("Lord of the Rings", "J.R.R Tolkien", "ccccccccc", 18.50, 1954, fant);
			
			repository.save(af);
			repository.save(hp);
			repository.save(lotr);
			
			User user1 = new User("user", "$2y$12$hHUEg5CXqmKX7ou7i.N7se6IXUhzXPuzcPAc4vvjxJpHLGFnnmwne", "USER", "user1@user.com");
			User user2 = new User("admin", "$2y$12$iLjEg.5BMIq8s4HCBTNto.1PJ0ydw/DI31x3rMUo9K5jzTF2/wId6", "ADMIN", "admin1@admin.com");
			User user3 = new User("SimonB", "$2y$12$Cj/NLmI7ZK6hhOPeMB2a8uIuwTMIwAxh18AcJF6d4SBQBBs6ojdiW", "ADMIN", "simonB@user.com");
			
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			//DISABLE/EXCLUDE H2 CONSOLE
		};
	}
}
