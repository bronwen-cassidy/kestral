create table clients (
  id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
  first_name varchar(1000),
  second_name VARCHAR(1000),
  address varchar(2000),
  email_address VARCHAR(1000),
  telephone VARCHAR(400),
  contact_telephone VARCHAR(400),
  date_of_birth VARCHAR(10)
);

create table appointments (
  id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
  label VARCHAR(2000),
  description VARCHAR(2000),
  user_id int not null REFERENCES clients(id)
);
