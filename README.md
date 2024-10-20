This project is a simple implementation of this JPA Buddy Guide, with a couple of shortcuts:

https://jpa-buddy.com/guides/best-practices-and-common-pitfalls-of-using-lombok-with-jpa/

It has 3 entities, Comment, Post, and User, and associated repositories. The entities have Lombok annotations that follow the JPA Buddy best practices.

To build the project:

1. you'll need to spin up the Postgres Docker config

    $ docker-compose up -d

2. Then you'll need to manually run the src/main/resources/schema.sql file to build the database schema.

3. At that point you should be ready to run the tests.


To Review:

https://stackoverflow.com/questions/48784923/is-using-id-field-in-allargsconstructor-while-using-spring-jpa-correct