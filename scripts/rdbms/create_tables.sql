-- Create address table
CREATE TABLE address (
                         address_id BIGINT PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         state VARCHAR(100),
                         postal_code VARCHAR(20),
                         country VARCHAR(100) NOT NULL,
                         created_by VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                         updated_by VARCHAR(50),
                         updated_at TIMESTAMP
);

-- Create contact table
CREATE TABLE contact (
                         contact_id BIGINT PRIMARY KEY,
                         address_id INT NOT NULL,
                         phone_number VARCHAR(20),
                         email VARCHAR(100),
                         website VARCHAR(100),
                         created_by VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                         updated_by VARCHAR(50),
                         updated_at TIMESTAMP,
                         CONSTRAINT fk_address
                             FOREIGN KEY(address_id)
                                 REFERENCES address(address_id)
);


CREATE TABLE company_type(
    company_type_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL

);
-- Create company table
CREATE TABLE company (
                              company_id BIGINT PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              description TEXT,
                              created_by VARCHAR(50) NOT NULL,
                              created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                              updated_by VARCHAR(50),
                              updated_at TIMESTAMP,
                              company_type_id INT,
                              CONSTRAINT fk_company_type
                                  FOREIGN KEY(company_type_id)
                                      REFERENCES COMPANY_TYPE(company_type_id)
);

CREATE TABLE service_type
(
    service_type_id INT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL
);

-- Create provided_service table
CREATE TABLE service (
                                  service_id BIGINT PRIMARY KEY,
                                  company_id INT NOT NULL,
                                  service_name VARCHAR(255) NOT NULL,
                                  description TEXT,
                                  price NUMERIC(10, 2),
                                  created_by VARCHAR(50) NOT NULL,
                                  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                                  updated_by VARCHAR(50),
                                  updated_at TIMESTAMP,
                                  CONSTRAINT fk_company
                                      FOREIGN KEY(company_id)
                                          REFERENCES company(company_id)
);
