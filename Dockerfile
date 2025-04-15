FROM gradle:8.13-jdk17 AS build
WORKDIR /app

# 의존성을 먼저 복사해서 캐싱 활용
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
# 선택적: 의존성만 먼저 다운로드
RUN gradle dependencies --no-daemon

# 소스 복사 및 빌드
COPY src ./src
RUN gradle build --no-daemon -x test

# 실행 스테이지
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드 스테이지에서 생성된 JAR 파일을 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]