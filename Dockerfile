FROM alpine:edge

COPY . /app
WORKDIR /app

RUN apk add --no-cache sbt --repository="http://dl-cdn.alpinelinux.org/alpine/edge/testing/"

RUN sbt reload
RUN sbt compile

EXPOSE 8080

ENTRYPOINT ["sbt", "~Jetty/start"]