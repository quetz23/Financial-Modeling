BEGIN TRANSACTION;

CREATE TABLE user_profile
(
profile_id     INT GENERATED ALWAYS AS IDENTITY   PRIMARY KEY,
user_id         int UNIQUE NOT NULL,
first_name      varchar(128)    NOT NULL,
last_name       varchar(128)    NOT NULL,
email           varchar(128)   NOT NULL,
recent_parameters_id int  ,
watchlist_id           int

);


        

CREATE TABLE recent_stock_screener_parameters
(
stock_screener_id    INT GENERATED ALWAYS AS IDENTITY   PRIMARY KEY,
user_id                   int NOT NULL,
market_cap_more_than      int,
beta_more_than            int,    
volume_more_than          int,
sector          varchar(128),
dividend_more_than        int,
CONSTRAINT fk_user_id FOREIGN KEY (user_id)
);

CREATE TABLE watchlist
(
watchlist_id INT GENERATED ALWAYS AS IDENTITY   PRIMARY KEY,
user_id int NOT NULL,
symbol varchar(10),

CONSTRAINT fk_user_id FOREIGN KEY (user_id)
);

COMMIT;

ROLLBACK;


