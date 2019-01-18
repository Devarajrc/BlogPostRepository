CREATE TABLE BlogPost (
    Bid int NOT NULL PRIMARY KEY,
    title varchar,
    description varchar,
    Uid int,
    Uid int FOREIGN KEY REFERENCES User(Uid)
);