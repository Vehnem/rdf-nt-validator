all: compile

compile:
	mvn clean compile scala:compile package spring-boot:repackage

