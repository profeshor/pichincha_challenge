CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    person_type VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    gender VARCHAR(50),
    age INTEGER,
    id_number VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    customer_id VARCHAR(255),
    password VARCHAR(255),
    status INTEGER
);

CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES people(id),
    account_number VARCHAR(255),
    account_type VARCHAR(255),
    initial_amount NUMERIC(15,2),
    status INTEGER
);

CREATE TABLE movements (
    id SERIAL PRIMARY KEY,
    account_id INTEGER REFERENCES accounts(id),
    local_date_time TIMESTAMP,
    movement_type VARCHAR(255),
    movement_amount NUMERIC(15,2),
    account_amount NUMERIC(15,2)
);
