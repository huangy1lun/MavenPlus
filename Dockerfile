FROM java:8-alpine
MAINTAINER huangYl
VOLUME /tmp
ADD ./target/mybatisplus-0.0.1-SNAPSHOT.jar /mp.jar
RUN sh -c 'touch /mp.jar'
CMD ["java", "-Xmx200m","-agentlib:jdwp=transport=dt_socket,address=50505,suspend=n,server=y","-Djava.security.egd=file:/dev/./urandom", "-jar", "/mp.jar"]
EXPOSE 8887 50505
