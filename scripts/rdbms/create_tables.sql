-- Create address table
CREATE TABLE address (
                         address_id SERIAL PRIMARY KEY,
                         organization_id INT NOT NULL,
                         street VARCHAR(255) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         state VARCHAR(100),
                         postal_code VARCHAR(20),
                         country VARCHAR(100) NOT NULL,
                         created_by VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                         updated_by VARCHAR(50),
                         updated_at TIMESTAMP,
                         CONSTRAINT fk_organization
                             FOREIGN KEY(organization_id)
                                 REFERENCES organization(organization_id)
);

-- Create business_owner table
CREATE TABLE business_owner (
                                owner_id SERIAL PRIMARY KEY,
                                user_id INT NOT NULL,
                                organization_id INT NOT NULL,
                                role VARCHAR(100),
                                created_by VARCHAR(50) NOT NULL,
                                created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                                updated_by VARCHAR(50),
                                updated_at TIMESTAMP,
                                CONSTRAINT fk_user
                                    FOREIGN KEY(user_id)
                                        REFERENCES users(user_id),
                                CONSTRAINT fk_organization
                                    FOREIGN KEY(organization_id)
                                        REFERENCES organization(organization_id)
);

-- Create contact table
CREATE TABLE contact (
                         contact_id SERIAL PRIMARY KEY,
                         organization_id INT NOT NULL,
                         phone_number VARCHAR(20),
                         email VARCHAR(100),
                         website VARCHAR(100),
                         created_by VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                         updated_by VARCHAR(50),
                         updated_at TIMESTAMP,
                         CONSTRAINT fk_organization
                             FOREIGN KEY(organization_id)
                                 REFERENCES organization(organization_id)
);

-- Create operating_hour table
CREATE TABLE operating_hour (
                                operating_hour_id SERIAL PRIMARY KEY,
                                organization_id INT NOT NULL,
                                day_of_week VARCHAR(10) NOT NULL,
                                open_time TIME NOT NULL,
                                close_time TIME NOT NULL,
                                created_by VARCHAR(50) NOT NULL,
                                created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                                updated_by VARCHAR(50),
                                updated_at TIMESTAMP,
                                CONSTRAINT fk_organization
                                    FOREIGN KEY(organization_id)
                                        REFERENCES organization(organization_id)
);

-- Create organization table
CREATE TABLE organization (
                              organization_id SERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              description TEXT,
                              created_by VARCHAR(50) NOT NULL,
                              created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                              updated_by VARCHAR(50),
                              updated_at TIMESTAMP
);

-- Create provided_service table
CREATE TABLE provided_service (
                                  service_id SERIAL PRIMARY KEY,
                                  organization_id INT NOT NULL,
                                  service_name VARCHAR(255) NOT NULL,
                                  description TEXT,
                                  price NUMERIC(10, 2),
                                  created_by VARCHAR(50) NOT NULL,
                                  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                                  updated_by VARCHAR(50),
                                  updated_at TIMESTAMP,
                                  CONSTRAINT fk_organization
                                      FOREIGN KEY(organization_id)
                                          REFERENCES organization(organization_id)
);
