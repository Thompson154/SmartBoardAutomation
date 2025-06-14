FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y wget unzip zip git openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$PATH:$JAVA_HOME/bin

RUN mkdir -p /opt/android-sdk/cmdline-tools && \
    cd /opt/android-sdk/cmdline-tools && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-10406996_latest.zip && \
    unzip commandlinetools-linux-10406996_latest.zip && \
    mv cmdline-tools latest && \
    rm commandlinetools-linux-10406996_latest.zip

ENV ANDROID_HOME=/opt/android-sdk
ENV PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools

RUN chown -R jenkins:jenkins /opt/android-sdk

USER jenkins