### Dummy app - Roster service ###

#### How to (build) and run ####

Port 8080

##### Docker: Docker Hub #####

```docker run -d --rm --name=roster --hostname=roster -p 8080:8080 aashipov/roster```

##### Docker: on-premise #####

```bash build-and-run.bash```

##### On-premise #####

Requirements ```openjdk 11```, ```maven``` in ```PATH```

```mvn clean install```

```java -jar backend/target/roster.jar```

#### License ####

Perl "Artistic License"
