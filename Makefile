all: compile

compile:
	mvn clean compile scala:compile spring-boot:repackage

