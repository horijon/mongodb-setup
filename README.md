# Getting Started

### Reference Documentation

## MongoDB
## Setup
### as mongodb is now licensed, and the open source has been removed from homebrew, we need to use community version
### need to uninstall legacy mongodb if already installed
* brew services stop mongodb
* brew uninstall homebrew/core/mongodb

### installation guide:
* brew tap mongodb/brew
* brew install mongodb-community
* brew services start mongodb-community
* [MongoDB tutorial](https://docs.mongodb.com/manual/tutorial/query-documents/)


For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-mongodb)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

