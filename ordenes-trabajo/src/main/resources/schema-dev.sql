CREATE TABLE vehicle (
    id SERIAL PRIMARY KEY,
    plate VARCHAR(20) UNIQUE NOT NULL,
    brand VARCHAR(100),
    model VARCHAR(100),
    year INTEGER
);

CREATE TABLE work_order (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50),
    description TEXT,
    status VARCHAR(20),
    order_date DATE,
    vehicle_id BIGINT REFERENCES vehicle(id)
);
