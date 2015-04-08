DROP TABLE IF EXISTS days_months;

create table days_months (
  id int not null PRIMARY KEY,
  day int not null,
  month varchar(512) not null,
  month_number int not null
);

create table treatments (
  id BIGINT not null AUTO_INCREMENT PRIMARY KEY
)

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
  activity_id VARCHAR(200) not null,
  user_id int not null REFERENCES clients(id)
);

-- table to store all treatments obtained by a user
create table user_treatments (
  id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
  user_id int not null REFERENCES clients(id),
  treatment_id int not null REFERENCES treatments(id),
  treatment_date VARCHAR(100) NOT NULL,
  paid_for VARCHAR(1) DEFAULT 'F',
  paid_date VARCHAR(100) NOT NULL
);
