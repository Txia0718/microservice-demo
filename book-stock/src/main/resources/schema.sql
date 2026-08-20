DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    version INT DEFAULT 1   -- 默认版本号为 1
);

INSERT INTO book (id, name, stock, version) VALUES (1, '微服务架构实战', 10, 1);