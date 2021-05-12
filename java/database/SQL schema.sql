BEGIN TRANSACTION;

CREATE TABLE user_profile
(
profile_id INT GENERATED ALWAYS AS IDENTITY   PRIMARY KEY,
user_id         int UNIQUE NOT NULL, 
first_name      varchar(128)    NOT NULL,
last_name       varchar(128)    NOT NULL,
email           varchar(128)   NOT NULL


);

CREATE TABLE stock_screener_parameters
(
market_cap_more_than      int,
beta_more_than            int,    
volume_more_than          int,
sector          varchar(128),
dividend_more_than        int
);

CREATE TABLE watchlist
(
symbol varchar(10),
company_name varchar(120)

);
