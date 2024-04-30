# Spring Boot Project

This Spring Boot project implements a service to retrieve labels of ranges and includes endpoints for testing.

## How to Run

To run the application, you need to use the following command:
mvnw spring-boot:run

This command will build and start the Spring Boot application.

## JUnit Testing

The project includes JUnit test cases to ensure the correctness and performance of the service that retrieves labels of ranges.

## Endpoints

The application exposes an endpoint to get the label for a given item. You can access it using the following URL:

Certainly! Here's the content for the README.md file:

css
Copy code
# Spring Boot Project

This Spring Boot project implements a service to retrieve labels of ranges and includes endpoints for testing.

## How to Run

To run the application, you need to use the following command:

mvnw spring-boot:run

bash
Copy code

This command will build and start the Spring Boot application.

## JUnit Testing

The project includes JUnit test cases to ensure the correctness and performance of the service that retrieves labels of ranges.

## Endpoints

The application exposes an endpoint to get the label for a given item. You can access it using the following URL:

http://localhost:8080/matchingLabels?item=6

This endpoint returns the label for the specified item based on the predefined ranges.

## Example

Consider the following ranges:

- Range A: [0, 6)
- Range B: [5, 7)

If we input an item such as 6, the endpoint will return the label 'B' since it falls within Range B.

## Error Handling

If an invalid or erroneous item is provided, the application will throw a custom exception, and an HTTP status code of 400 (Bad Request) will be returned.
