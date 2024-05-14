FROM bellsoft/liberica-openjdk-alpine:17.0.11
# Install curl, JQ
RUN apk add curl jq
#Create a workspace
WORKDIR /home/selenium-docker
# copy required files to above working directory
ADD target/docker-resources /home/selenium-docker
# Add runner.sh file under home directory
ADD runner.sh   /home/selenium-docker/runner.sh
# Start the runner.sh
ENTRYPOINT sh runner.sh