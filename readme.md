### Roster service ###

Build app ```mvn clean package```

Run ```java -jar backend/target/roster.jar```

```docker build . -t org.dummy/roster```

```docker run --rm -p 8080:8080 -it org.dummy/roster /bin/bash```

```curl -i --header "Accept:application/json" -X GET http://localhost:8080/employees```

```curl -i --header "Authorization:Basic VVNFUjpVU0VS" -X DELETE http://localhost:8080/employees/delete_all```
