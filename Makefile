PROFILE=dev

stop-mongo:
	-docker stop lunch-and-learn-mongo
	-docker rm lunch-and-learn-mongo

start-mongo: stop-mongo
	docker run -d -p 27017:27017 --name lunch-and-learn-mongo mongo

unit-test:
	./mvnw clean test -DargLine="-Dspring.profiles.active=$(PROFILE)"

test: start-mongo
	./mvnw clean verify -DargLine="-Dspring.profiles.active=$(PROFILE)"

start:
	./mvnw spring-boot:run -Drun.arguments="--spring.profiles.active=$(PROFILE)"
