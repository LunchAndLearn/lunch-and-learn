unit-test:
	./mvnw clean test -DargLine="-Dspring.profiles.active=dev"

integration-test:
	./mvnw clean verify -DargLine="-Dspring.profiles.active=dev"
