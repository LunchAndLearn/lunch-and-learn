# Lunch and Learn API

The propose of this project is to provide an easy way to inovate and creates applications in a context of Lunch and Learn.
Some ideas of future capabilities of this API are:
- Schedule a L&L
- See what are the next L&L available
- Select your food
- Give up of your food
- Give feedback to the presenters

# Requirements


- Java 8
- Docker

# Tech stack

- Java 8
- Maven
- Spring Boot
- Mongodb
- Travis CI

# Commands

To run only unit-tests:
```
make unit-test
```

To run unit-tests and integration tests:
```
make test
```

To run the application locally:
```
make start
```

Any of these commands could be run using another profile (per default is `dev`) like:
```
make start PROFILE=prod
```