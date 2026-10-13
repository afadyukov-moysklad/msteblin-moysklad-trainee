FROM eclipse-temurin:25-jdk AS builder
WORKDIR /build
COPY gradlew .
COPY gradle/ ./gradle
COPY settings.gradle.kts gradle.properties .
COPY buildSrc/ ./buildSrc
RUN ./gradlew build || return 0
COPY . .
RUN ./gradlew :app:installDist

FROM eclipse-temurin:25-jre AS runner
WORKDIR /app
COPY --from=builder /build/app/build/install/app /app
ENTRYPOINT ["/app/bin/app"]

