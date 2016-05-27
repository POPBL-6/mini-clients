# mini-clients [![Build Status](https://travis-ci.org/POPBL-6/mini-clients.svg?branch=devel)](https://travis-ci.org/POPBL-6/mini-clients)
Application using middleware to test publish/suscribe methods in a real application.

## How to run it?
### If you have Gradle installed
Just run the following command in the repository folder
```sh
$ gradle run
```
The application needs to have a 'config.dat' file with the configuration and a 'topic.dat' file with the topic will publish on.

### If you don't have gradle installed
We have included a gradle wrapper also, just execute the next command to run it
```sh
$ ./gradlew run
```
 

