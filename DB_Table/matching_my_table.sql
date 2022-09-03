use sportsmatching;
create table matching_my (
	_no int primary key auto_increment,
    _owner varchar(20),
    _origin int,
    foreign key (_origin) references matching(_no) on delete cascade
)