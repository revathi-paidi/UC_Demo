-- liquibase formatted sql

-- changeset revathi:claims:1
CREATE TABLE IF NOT EXISTS claims (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
claimant_name VARCHAR(255) NOT NULL,
claimant_ssn VARCHAR(11) NOT NULL,
claim_date DATE NOT NULL,
employer_name VARCHAR(255) NOT NULL,
status VARCHAR(50) NOT NULL CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'))
);

-- changeset revathi:claims:2
ALTER TABLE claims
MODIFY COLUMN status VARCHAR(50) NOT NULL DEFAULT 'PENDING';

-- changeset revathi:claims:3
ALTER TABLE claims
ADD COLUMN created_date timestamp DEFAULT now(),
ADD COLUMN last_modified_date timestamp;