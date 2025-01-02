CREATE DATABASE bron_business_local;
CREATE USER bron_user WITH ENCRYPTED PASSWORD 'bron_password';
GRANT ALL PRIVILEGES ON DATABASE bron_business_local TO bron_user;
