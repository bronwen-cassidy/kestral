DROP TABLE IF EXISTS days_months;

create table days_months (
  id int not null PRIMARY KEY,
  day_date int not null,
  month_date varchar(512) not null
)
