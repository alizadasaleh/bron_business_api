-- Create address table
CREATE TABLE address (
     address_id BIGSERIAL PRIMARY KEY,
     street VARCHAR(255) NOT NULL,
     city VARCHAR(100) NOT NULL,
     state VARCHAR(100),
     postal_code VARCHAR(20),
     longitude DOUBLE PRECISION,
     latitude DOUBLE PRECISION,
     created_by VARCHAR(50),
     created TIMESTAMP with time zone DEFAULT CURRENT_TIMESTAMP,
     modified_by VARCHAR(50),
     modified TIMESTAMP
);

-- Create contact table
CREATE TABLE contact (
     contact_id BIGSERIAL PRIMARY KEY,
     address_id INT NOT NULL,
     phone_number VARCHAR(20),
     email VARCHAR(100),
     website VARCHAR(100),
     schedule JSONB,
     created_by VARCHAR(50),
     created TIMESTAMP with time zone DEFAULT CURRENT_TIMESTAMP,
     modified_by VARCHAR(50),
     modified TIMESTAMP,
     CONSTRAINT fk_address
         FOREIGN KEY(address_id)
             REFERENCES address(address_id)
);


-- CREATE TABLE company_type(
--     company_type_id INT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     created_by VARCHAR(50),
--     created TIMESTAMP NOT NULL DEFAULT NOW(),
--     modified_by VARCHAR(50),
--     modified TIMESTAMP
--
-- );
-- Create company table
CREATE TABLE company (
      company_id BIGSERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      description TEXT,
      created_by VARCHAR(50),
      created TIMESTAMP with time zone DEFAULT CURRENT_TIMESTAMP,
      modified_by VARCHAR(50),
      modified TIMESTAMP

);

CREATE TABLE service_type
(
    service_type_id INT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    created_by VARCHAR(50),
    created TIMESTAMP with time zone DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(50),
    modified TIMESTAMP
);

-- Create provided_service table
CREATE TABLE service (
      service_id BIGSERIAL PRIMARY KEY,
      company_id INT NOT NULL,
      service_name VARCHAR(255) NOT NULL,
      service_type_id INT,
      description TEXT,
      price NUMERIC(10, 2),
      created_by VARCHAR(50),
      created TIMESTAMP with time zone DEFAULT CURRENT_TIMESTAMP,
      modified_by VARCHAR(50),
      modified TIMESTAMP,
      CONSTRAINT fk_company
          FOREIGN KEY(company_id)
              REFERENCES company(company_id),
      CONSTRAINT fk_service_type
              FOREIGN KEY(service_type_id)
              REFERENCES service_type(service_type_id)
);
