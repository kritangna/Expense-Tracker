package com.expense.expense_tracker_app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense tracker REST API Documentation",
				description = "Expense tracker REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Kritangna",
						email = "krita0831@gmail.com",
						url = "https://www.xyz"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.xyz/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense tracker REST API Documentation for developers",
				url = "https://www.xyz/external-doc.html"
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
