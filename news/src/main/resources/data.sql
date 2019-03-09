-- Subscribers
insert into subscriber 	(id, full_name, subscription_Date, active, email, password)
	values (10001, 'James Bond', '2012-09-17 18:47:52.69', true, 'james.bond@gmail.com', 'abc');

insert into subscriber 	(id, full_name, subscription_Date, active, email, password)
	values (10011, 'james Bond', '2012-09-17 18:47:52.69', true, 'James.bond@gmail.com', 'abc');
	
insert into subscriber (id, full_name, subscription_Date, active, email, password, gender)
	values (10006, 'Yan li', '2014-09-17 18:47:52.69', false, 'Yan.li@gmail.com', 'abc', 'M');
	
insert into subscriber 	(id, full_name, subscription_Date, active, email, password, gender)
	values (10007, 'Belal Jako', '2013-01-17 18:47:52.69', true, 'Belal.Jako@gmail.com', 'abc', 'M');	

/**
--insert into country (id, name) values (30001, 'Egypt');
--insert into country (id, name) values (30002, 'USA');

insert into subscriber_additional_details(id, main_data, phone, address, city, birth_date, country_id)
	values (20001, 10001, '010666111888', 'NY City', 'NY', '1990-09-17 18:47:52.69', 30001);	
 
insert into subscriber_additional_details(id, main_data, phone, address, city, birth_date, country_id)
	values (20011, 10011, '010111111111', 'NY City 2', 'NY 2', '1980-09-17 18:47:52.69', 30002);		
**/

insert into subscriber_additional_details(id, main_data, phone, address, city, birth_date, country)
	values (20001, 10001, '010666111888', 'NY City', 'NY', '1990-09-17 18:47:52.69', 30001);	
 
insert into subscriber_additional_details(id, main_data, phone, address, city, birth_date, country)
	values (20011, 10011, '010111111111', 'NY City 2', 'NY 2', '1980-09-17 18:47:52.69', 30002);		


insert into author (id, rate_per1000word) values (10001, 100);	
insert into author (id, rate_per1000word) values (10006, 100);	


insert into fan (id) values (10011);
insert into fan (id) values (10007);

insert into author_fans(authors_id, fans_id) values (10001, 10007);
--insert into author_fans(authors_id, fans_id) values (10006, 10011);


insert into article(approved , id, author_id,publish_date, title)
values (true, 20001,10001,'2014-09-17 18:47:52.69' ,' test title'); 

insert into article_content (article_id, content) 
values (20001, 'Learn how to map Embeddable types in Hibernate using JPA''s ... that we built in this article on my jpa-hibernate-tutorials github repository.')
;
insert into article_tags values (20001, 'Story');
insert into article_tags values (20001, 'Action');
insert into article_tags values (20001, 'Suspense');
 











