FROM opensuse/leap:15.2 AS base
RUN groupadd dummy ; useradd -d /dummy/ -m -g dummy dummy ; \
#echo 'dummy ALL=NOPASSWD: ALL' >> /etc/sudoers ; \
zypper --non-interactive --ignore-unknown --no-cd install --auto-agree-with-licenses --allow-unsigned-rpm \
java-11-openjdk-headless sudo curl ; \
zypper --non-interactive clean -a ; zypper --non-interactive purge-kernels

FROM base AS builder
USER root
RUN zypper --non-interactive --ignore-unknown --no-cd install --auto-agree-with-licenses --allow-unsigned-rpm \
maven ; \
zypper --non-interactive clean -a ; zypper --non-interactive purge-kernels; \
mkdir -p /dummy/build/ ; chown -R dummy:dummy /dummy/build/
WORKDIR /dummy/build/
COPY --chown=dummy:dummy backend ./backend/
COPY --chown=dummy:dummy frontend ./frontend/
COPY pom.xml .
USER dummy
WORKDIR /dummy/build/
RUN mvn clean install

FROM base
USER root
COPY --chown=dummy:dummy --from=builder /dummy/build/backend/target/roster.jar /dummy/
WORKDIR /dummy/
EXPOSE 8080
USER dummy
CMD java -jar roster.jar
