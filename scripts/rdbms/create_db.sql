-- Step 1: Create a role with login permission
CREATE ROLE bron_business_role WITH LOGIN PASSWORD 'bron_password';

-- Step 2: Create the database
CREATE DATABASE bron_business
    WITH
    OWNER = bron_business_role
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

-- Step 3: Create a user and assign them to the role
CREATE USER bron_business_user WITH PASSWORD 'bron_password';
GRANT bron_business_role TO bron_business_user;

-- Step 4: Grant privileges to the role
GRANT ALL PRIVILEGES ON DATABASE bron_business TO bron_role;

-- Step 5: Connect to the database as the role and assign privileges to the user
\c bron_db

-- Grant all privileges on all tables, sequences, and functions to the user
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA bron_business TO bron_business_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA bron_business TO bron_business_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA bron_business TO bron_business_user;

-- Optional: Set the default privileges for any future tables, sequences, and functions
ALTER DEFAULT PRIVILEGES IN SCHEMA bron_business GRANT ALL ON TABLES TO bron_business_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA bron_business GRANT ALL ON SEQUENCES TO bron_business_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA bron_business GRANT ALL ON FUNCTIONS TO bron_business_user;
