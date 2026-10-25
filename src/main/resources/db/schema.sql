-- Simple schema example (Spring JPA can auto-create/alter with ddl-auto=update)
-- This is provided for reference only.

CREATE TABLE IF NOT EXISTS products (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR(200) NOT NULL,
  category VARCHAR(100) NOT NULL,
  price DECIMAL(19,2) NOT NULL,
  quantity INT NOT NULL,
  brand VARCHAR(100) NOT NULL,
  description VARCHAR(2000)
);

