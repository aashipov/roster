FROM aashipov/roster:builder AS builder
USER root
WORKDIR /dummy/build/
COPY --chown=dummy:dummy backend ./backend/
COPY --chown=dummy:dummy frontend ./frontend/
COPY pom.xml .
USER dummy
WORKDIR /dummy/build/
RUN mvn clean install

FROM aashipov/roster:base
USER root
COPY --chown=dummy:dummy --from=builder /dummy/build/backend/target/roster.jar /dummy/
WORKDIR /dummy/
EXPOSE 8080
USER dummy
CMD java -jar roster.jar
HEALTHCHECK CMD curl -f http://localhost:8080/actuator/health || exit 1
