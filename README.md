# JWT Spring App

This is a project using jwt as the security.

# Getting Started

### Techstack Used

- [Java 21](https://jdk.java.net/21/)
- [Apache Maven](https://maven.apache.org/guides/index.html)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
- [Spring Security](https://spring.io/projects/spring-security)

# How to run the app

1. Open the app in the IDE of your choice

2. Open the terminal and git clone the master branch

3. Make sure you have [docker](https://www.docker.com/) and [docker-compose](https://docs.docker.com/compose/) installed.

4. Run `docker-compose up` in the terminal. This will create a postgres database with users_db.

5. While still in the terminal , run `./mvnw spring-boot:run`

6. The server will start on `http://localhost:8080`
