use sportsmatching;
create table matching (
	_no int primary key auto_increment,
    _owner varchar(20),
    _kind varchar(12),
    _date varchar(10),
    _time1 varchar(5),
    _time2 varchar(5),
    _mmr1 int,
    _mmr2 int,
    _many1 int,
    _many2 int,
    _our int,
    _location varchar(20)
)