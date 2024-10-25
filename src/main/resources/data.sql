insert into "user" values (0, 0, 'red');
insert into "user" values (1, 0, 'blue');
insert into "user" values (2, 0, 'green');

insert into post (id, title, content, author_id) values (0, 'Red First Post', 'Red First Post Content', 0);
insert into post (id, title, content, author_id) values (1, 'Blue First Post', 'Blue First Post Content', 1);
insert into post (id, title, content, author_id) values (2, 'Green First Post', 'Green First Post Content', 2);

insert into comment(id, content, author_id) values (0, 'Red Comment', 0);
insert into comment(id, content, author_id) values (1, 'Blue Comment', 1);
insert into comment(id, content, author_id) values (2, 'Green Comment', 2);
