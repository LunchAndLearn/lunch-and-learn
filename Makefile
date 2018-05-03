PROFILE=dev

stop-mongo-integration:
	-docker stop lunch-and-learn-mongo-integration
	-docker rm lunch-and-learn-mongo-integration

start-mongo-integration: stop-mongo-integration
	docker run -d -p 27018:27017 --name lunch-and-learn-mongo-integration mongo

test: start-mongo-integration
	./mvnw clean verify -DargLine="-Dspring.profiles.active=integration"

unit-test:
	./mvnw clean test -DargLine="-Dspring.profiles.active=$(PROFILE)"

start-mongo:
	docker run -d -p 27017:27017 --name lunch-and-learn-mongo-${PROFILE} mongo

start: start-mongo
	./mvnw spring-boot:run -Drun.arguments="--spring.profiles.active=$(PROFILE)"
