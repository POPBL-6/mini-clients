# mini-clients [![Build Status](https://travis-ci.org/POPBL-6/mini-clients.svg?branch=devel)](https://travis-ci.org/POPBL-6/mini-clients) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/5881c2a2858c493b9b86069c286e45a1)](https://www.codacy.com/app/POPBL6/mini-clients?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=POPBL-6/mini-clients&amp;utm_campaign=Badge_Grade)
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
 

