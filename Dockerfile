FROM apachepulsar/pulsar:3.1.0
FROM openjdk:17-jdk-slim
COPY --from=0 /pulsar /pulsar
