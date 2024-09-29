```markdown
# Spring MVC Blog

A simple blog application built using Spring MVC, Thymeleaf, and a basic in-memory repository for managing posts and users.

## Features

- Create, edit, and delete blog posts.
- List and view individual posts.
- Form validation for creating and editing posts.
- Pagination support for listing posts.
- Simple user management.

## Technologies

- **Spring Boot**
- **Spring MVC**
- **Thymeleaf** for templating
- **Jakarta Validation** for form validation
- **Lombok** for reducing boilerplate code

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/usermlc/spring-mvc-blog.git
   ```

2. Navigate to the project directory:
   ```bash
   cd spring-mvc-blog
   ```

3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at:
   ```
   http://localhost:8080/posts
   ```

## Usage

- Add a new blog post: `/posts/add`
- Edit a blog post: `/posts/edit/{id}`
- Delete a blog post: `/posts/delete/{id}`

## License

This project is licensed under the MIT License.
