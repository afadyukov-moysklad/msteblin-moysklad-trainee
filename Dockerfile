FROM eclipse-temurin:25-jdk AS builder
WORKDIR /build
COPY gradlew .
COPY gradle/ ./gradle
COPY settings.gradle.kts gradle.properties .
COPY buildSrc/ ./buildSrc
COPY . .
RUN --mount=type=cache,target=/root/.gradle ./gradlew :app:installDist --build-cache --no-daemon

FROM eclipse-temurin:25-jre AS runner
WORKDIR /app
COPY --from=builder /build/app/build/install/app .
ENTRYPOINT ["/app/bin/app"]

