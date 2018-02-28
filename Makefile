PROFILE=dev

start-local-mongo:
	-docker stop lunch-and-learn-mongo
	-docker rm lunch-and-learn-mongo
	docker run -d -p 27017:27017 --name lunch-and-learn-mongo mongo

unit-test:
	./mvnw clean test -DargLine="-Dspring.profiles.active=$(PROFILE)"

test: start-local-mongo
	./mvnw clean verify -DargLine="-Dspring.profiles.active=$(PROFILE)"

start:
	./mvnw spring-boot:run -DargLine="-Dspring.profiles.active=$(PROFILE)"
