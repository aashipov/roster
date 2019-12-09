### Roster service ###

```mvn clean package```

```docker build . -t org.dummy/roster```

```docker run --rm -p 8080:8080 -it org.dummy/roster /bin/bash```

```curl -i --header "Accept:application/json" -X GET http://localhost:8080/employees```

```curl -i -X DELETE -d username=USER -d password=USER http://localhost:8080/employees/delete_all```
