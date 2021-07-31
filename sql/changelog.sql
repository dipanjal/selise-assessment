-- Creation

create table account
(
    id             bigint auto_increment
        primary key,
    name           varchar(255)     null,
    address        varchar(500)     null,
    account_number varchar(255)     null,
    balance        double default 0 not null,
    status         int    default 1 null,
    version        bigint           not null
);

create table transaction
(
    id                         bigint auto_increment
        primary key,
    request_id                 varchar(255)     not null,
    requester                  varchar(255)     null,
    transaction_type           varchar(50)      null,
    source_account_number      varchar(255)     null,
    amount                     double default 0 null,
    destination_account_number varchar(255)     null,
    note                       varchar(300)     null,
    constraint transaction_requestId_uindex
        unique (request_id)
);


-- Insertion

INSERT INTO `selise-db`.account (name, address, account_number, balance, status) VALUES ('Jhon Doe', 'Dallas, Texas TX', '001241009211439', 5000, DEFAULT);
INSERT INTO `selise-db`.account (name, address, account_number, balance, status) VALUES ('Amanda Jenny', '1678 Perry Street', '32341200923487', 5000, DEFAULT);
INSERT INTO `selise-db`.account (name, address, account_number, balance, status) VALUES ('Ruby Rose', '4133 Mahlon Street', '123456789123456', 5000, DEFAULT);

