create database if not exists airline_model;
use airline_model;

drop table if exists flights,
					flight_routes,
					flight_fare;

create table flights (
	id int not null auto_increment,
    airline varchar(16),
    flight_no varchar(16),
    primary key(id) 
);

create table flight_fare (
	id int not null auto_increment,
    class varchar(255) not null,
    fare int not null,
    is_refundable boolean not null,
    primary key(id)
);

create table flight_routes (
	id int not null auto_increment,
    departure_location varchar(255) not null,
    arrival_location varchar(255) not null,
    departs_on varchar(255) not null,
    arrive_on varchar(255) not null,
    flight_id int default null,
    fare_id int default null,
	constraint primary key(id),
    foreign key(flight_id) references flights(id),
    foreign key(fare_id) references flight_fare(id)
);