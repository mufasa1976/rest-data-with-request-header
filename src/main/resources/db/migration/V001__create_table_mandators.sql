CREATE TABLE mandators (
  version          INT                      NOT NULL DEFAULT 0
 ,reference        UUID                     NOT NULL DEFAULT UUID()
 ,last_modified_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP()
 ,mandator         VARCHAR(255)             NOT NULL
 ,PRIMARY KEY (mandator)
 ,UNIQUE (reference)
);