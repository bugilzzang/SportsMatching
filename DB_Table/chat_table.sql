use sportsmatching;
create table chat (
	_no int primary key auto_increment,
    _owner varchar(20),
    _room int,
    _message varchar(100),
    foreign key (_room) references matching(_no) on delete cascade
)