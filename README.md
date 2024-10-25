# Project Overview

This project is a partial implementation of this JPA Buddy Guide, with some modifications. This version actually uses Lombok's equals and hashcode, againts the JPA Buddy recommendations, but is very specific with the fields that are being used. It uses the natural id if there is one, or implements a UUID in the cases where there is not one, and the UUID becomes the natural id. Then the Lombok fields for equals and hashcode are configured to only use the fields from the natural id. Right now the tests pass, but it is possible there are issues that haven't yet been thought of.

https://jpa-buddy.com/guides/best-practices-and-common-pitfalls-of-using-lombok-with-jpa/

It has 3 entities, Comment, Post, and User, and associated repositories. The entities have Lombok annotations that follow the JPA Buddy best practices.

To build the project:

1. you'll need to spin up the Postgres Docker config

    $ docker-compose up -d

2. Then you'll need to manually run the src/main/resources/schema.sql file to build the database schema.

3. Manually run the src/main/resource/data.sql to add the test data.

4. At that point you should be ready to run the tests.

5. The dropall.sql file will clear the 3 tables if you want to rebuild the database.

# Practices Implemented

Here are the practices this project tries to implement:

## Equals and Hashcode

1. The BaseEntity includes the Id and Version fields. There are default equals and hashcode implementations in the base entity class, as a fallback in case there is no natural id. These implementations are Hibernate aware.
2. The child entities, by default, inherit the base class equals and hashcode. In cases where there is a Natural ID (User's username, for example), we can override the base class equals and hashcodes. They should include calls to super.equals and super.hashcode to ensure that the Hibernate proxies are handled correctly.
3. In cases where there is not a Natural ID, we can consider implementing a UUID as a key if the fallback implementation is not good enough.

## toString

1. We can in general use the toString annotation. 
2. However, any sets or lists that are mapped should be omitted with the @ToString.Exclude annotation. See the User class comments and posts fields for an example.

## Builders

1. Use @SuperBuilder for both parent and child classes in a hierarchy.
2. Include both @NoArgsConstructor and @AllArgsConstructor if you are using @SuperBuilder, per the JPA Buddy recommendations.
3. Includes @Builder.Default on mapped sets with empty sets. See the posts and comments mappings inside User.

## Setters an Getters

1. Use both @Setter and @Getter Lombok annotations on both the base entity class and child entity classes.

## MappedSuperclass

1. Use the Jakarta MappedSuperclass annotation on the base entity class so that JPA understands that this is an inheritance hierarchy.

# Reference

1. https://www.artima.com/articles/how-to-write-an-equality-method-in-java
2. Equals Verifier, used in unit testing. https://jqno.nl/equalsverifier/
3. https://projectlombok.org/features/EqualsAndHashCode
4. https://thorben-janssen.com/ultimate-guide-to-implementing-equals-and-hashcode-with-hibernate/
5. By the JPA Buddy folks - https://dzone.com/articles/lombok-and-jpa-what-may-go-wrong
