all: docker

docker:
	mvn spring-boot:build-image

