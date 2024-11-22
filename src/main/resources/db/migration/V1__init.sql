CREATE TABLE IF NOT EXISTS guest (
    id SERIAL PRIMARY KEY,
    nui VARCHAR (10) UNIQUE NOT NULL,
    full_name VARCHAR (100) NOT NULL,
    address VARCHAR (100),
    email VARCHAR (100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS gift (
    id SERIAL PRIMARY KEY,
    description VARCHAR (100) NOT NULL,
    expiration_date DATE,
    guest_id INT,
    FOREIGN KEY (guest_id) REFERENCES guest(id)
    )