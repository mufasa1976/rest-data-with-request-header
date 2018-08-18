CREATE TABLE vendors (
  id               BIGINT                   NOT NULL AUTO_INCREMENT
 ,version          INT                      NOT NULL DEFAULT 0
 ,reference        UUID                     NOT NULL DEFAULT UUID()
 ,last_modified_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP()
 ,mandator         VARCHAR(255)             NOT NULL
 ,name             VARCHAR(255)             NOT NULL
 ,PRIMARY KEY (id)
 ,UNIQUE (reference)
 ,UNIQUE (mandator, name)
 ,FOREIGN KEY (mandator) REFERENCES mandators (mandator)
);
