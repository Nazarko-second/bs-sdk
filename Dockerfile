FROM jenkins/jenkins:2.485-jdk21

ARG maven_version=3.9.9

ENV MAVEN_HOME=/opt/maven
ENV M2_HOME=/opt/maven
ENV PATH=/opt/java/openjdk/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:${M2_HOME}/bin

USER root

RUN apt-get update && apt-get install wget -y && apt-get clean

# Install latest Maven
RUN wget https://dlcdn.apache.org/maven/maven-3/"$maven_version"/binaries/apache-maven-"$maven_version"-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-"$maven_version"-bin.tar.gz -C /opt
RUN ln -s /opt/apache-maven-"$maven_version" /opt/maven

USER jenkins

# docker build --no-cache -t jenkins_image .
# docker-compose up -d / docker-compose down jenkins_ci
