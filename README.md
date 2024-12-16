# Nimap Java Machine Test

## Overview
A Spring Boot application demonstrating CRUD operations on an Oracle database using Hibernate, JPA, and Spring Data JPA.

## Features
- CRUD operations for Categories and Products.
- Follows RESTful API principles.
- Database interaction using Spring Data JPA.
- Configurable Oracle database connectivity.

## Technologies Used
- **Backend:** Spring Boot 3.3.6, Hibernate, JPA
- **Database:** Oracle Database 21c
- **Tools:** Maven, Postman (API testing)

## Requirements
- **Java:** JDK 17 or higher
- **Database:** Oracle 21c (configured locally)
- **Build Tool:** Maven 3.8 or higher
- **IDE:** IntelliJ IDEA, Eclipse, or Spring Tool Suite

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
2. Configure the Database
Create the database:

sql
Copy code
CREATE DATABASE machine_test;
Update application.properties with your Oracle database details:

properties
Copy code
spring.application.name=NimapJavaMachineTest

# Oracle Database Configuration
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=c##hr
spring.datasource.password=hr
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# Hibernate JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect

# Server Configuration
server.port=8080
3. Build the Application
In your terminal, run:

bash
Copy code
mvn clean install
4. Run the Application
Start the Spring Boot application:

bash
Copy code
mvn spring-boot:run
The application will be accessible at http://localhost:8080.

Database Initialization
Run the following SQL queries to populate initial records:

Categories
sql
Copy code
INSERT INTO category (id, category_name) VALUES
(1, 'Electronic Devices'),
(2, 'Sports'),
(3, 'Clothing'),
(4, 'Home Appliances'),
(5, 'Footwear'),
(6, 'Jewelry'),
(7, 'Educational'),
(8, 'Devotional'),
(9, 'Toys'),
(10, 'Accessories'),
(11, 'Automobile');
Products
sql
Copy code
INSERT INTO product (id, price, product_name, category_id) VALUES
(1, 800, 'T-Shirt', 3),
(2, 1200, 'Shirt', 3),
(3, 2100, 'Pant', 3),
(4, 3500, 'Kurta', 3),
(5, 1400, 'Oversized T-Shirt', 3),
(6, 3000, 'Jeans', 3),
(7, 45000, 'Refrigerator', 4),
(8, 30000, 'Washing Machine', 4),
(9, 60000, 'Air Conditioner', 4),
(10, 20000, 'Cooler', 4);
API Endpoints
Category CRUD Operations
GET All Categories
GET http://localhost:8080/api/categories?page=0

Create a New Category
POST http://localhost:8080/api/categories
Body (JSON):

json
Copy code
{ "categoryName": "Utilities" }
GET Category by ID
GET http://localhost:8080/api/categories/{id}

Update Category by ID
PUT http://localhost:8080/api/categories/{id}
Body (JSON):

json
Copy code
{ "categoryName": "Most Sold" }
Delete Category by ID
DELETE http://localhost:8080/api/categories/{id}

Product CRUD Operations
GET All Products
GET http://localhost:8080/api/products?page=1

Create a New Product
POST http://localhost:8080/api/products
Body (JSON):

json
Copy code
{
  "productName": "Jeans",
  "price": 3000,
  "category": { "categoryId": 3 }
}
GET Product by ID
GET http://localhost:8080/api/products/{id}

Update Product by ID
PUT http://localhost:8080/api/products/{id}
Body (JSON):

json
Copy code
{
  "productName": "Fan",
  "price": 2000.0,
  "category": { "categoryId": 1, "categoryName": "Electronic Devices" }
}
Delete Product by ID
DELETE http://localhost:8080/api/products/{id}

Testing Instructions
Using Postman or REST Client
Import API endpoints and test each operation.
Add ?page={page_number} to GET requests for paginated responses.
Notes
Ensure the Oracle database is running before starting the application.
Use correct IDs for GET, PUT, and DELETE requests.
Error handling is implemented for invalid requests and database constraints.
License
This project is licensed under the MIT License.

Author
Tejas Dudhe
Email: tejasdudhe12@gmail.com
