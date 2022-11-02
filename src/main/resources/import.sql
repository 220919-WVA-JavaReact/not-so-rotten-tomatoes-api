insert into users(username, email, password, role) values('12cwarden', '12cwarden@gmail.com', 'test', 'USER');
insert into users(username, email, password, role) values('admin', 'admin@gmail.com', 'test', 'ADMIN');
insert into users(username, email, password, role) values('test', 'test@gmail.com', 'test', 'USER');

insert into recipes(author, recipe_name, instructions, category) values ('1', 'Cake', 'bake', 'Dessert');
insert into recipes(author, recipe_name, instructions, category) values ('1', 'Pizza', 'bake', 'Entree');
insert into recipes(author, recipe_name, instructions, category) values ('1', 'Chips', 'serve', 'Appetizer');

insert into reviews(author, review_text, recipe_id) values ('1', 'test value', '1');
insert into reviews(author, review_text, recipe_id) values ('2', 'test value2', '1');
insert into reviews(author, review_text, recipe_id) values ('1', 'test value3', '2');