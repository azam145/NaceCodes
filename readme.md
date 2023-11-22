create table if not exists nace(
`order` int primary key,
level varchar(255),
code varchar(255),
`parent` varchar(255),
`description` varchar(255),
`includes` varchar(255),
`alsoIncl` varchar(255),    
`rulings` varchar(255),
`excludes` varchar(255),
`reference` varchar(255)
);