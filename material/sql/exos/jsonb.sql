DROP TABLE IF EXISTS houses;

CREATE TABLE houses (
  id SERIAL PRIMARY KEY,
  address TEXT UNIQUE,
  rooms JSONB
);

INSERT INTO houses(address, rooms) VALUES (
  '123 Elm St',
  '[
    {
      "name": ""  
    }
  ]'
)