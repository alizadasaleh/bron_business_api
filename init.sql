DO $$
    BEGIN
        -- Create the database if it doesn't exist
        IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'bron_business_local') THEN
            CREATE DATABASE bron_business_local;
        END IF;

        -- Create the user if it doesn't exist
        IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'bron_user') THEN
            CREATE USER bron_user WITH ENCRYPTED PASSWORD 'bron_password';
        END IF;

        -- Grant privileges
        GRANT ALL PRIVILEGES ON DATABASE bron_business_local TO bron_user;
    END $$;
