FROM ubuntu:latest
LABEL authors="low"

ENTRYPOINT ["top", "-b"]