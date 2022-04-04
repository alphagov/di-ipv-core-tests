FROM eclipse-temurin:17-focal

RUN apt update && apt upgrade -y && \
    apt-get install libglib2.0-0 libnss3 libxcb1 wget -y

RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install -y ./google-chrome-stable_current_amd64.deb

WORKDIR /di-ipv-core-tests

ADD ./ /di-ipv-core-tests/

RUN ./gradlew init
