### Roster service ###

```mvn clean package```

```docker build . -t org.dummy/roster```

```docker run --rm -p 8080:8080 -it org.dummy/roster /bin/bash```
