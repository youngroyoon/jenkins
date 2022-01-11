# openjdk:8-jdk-alpine 이미지를 기본으로 사용
# 이 Dockerfile은 매우 간단하지만 Java와 JAR 파일만 있으면( just Java and a JAR file ) 
# 아무 장식 없이 Spring Boot 앱을 실행하는 데 필요한 모든 것입니다
FROM openjdk:8-jdk

# Dockerfile 내부 변수
ARG WAR_FILE=demo/target/ROOT.war

# 파일 복사
COPY ${WAR_FILE} app.war

# 호스트와 연결할 포트 번호를 설정
# EXPOSE 8888

# 컨테이너가 실행되었을 때 명령이 실행
ENTRYPOINT ["java","-jar","-Dserver.port=8888","/app.war"]
