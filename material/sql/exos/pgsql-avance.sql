DROP TABLE IF EXISTS houses;

CREATE TABLE houses (
  id SERIAL PRIMARY KEY,
  address TEXT UNIQUE,
  owner VARCHAR(255)
  rooms JSONB
);

INSERT INTO houses(address, owner, rooms) VALUES (
  '123 Elm St',
  'Alice',
  '[
    {
      "name": ""  
    }
  ]'
);

INSERT INTO houses(address, owner, rooms) VALUES (
  '123 Elm St',
  'Bob',
  '[
    {
      "name": ""  
    }
  ]'
)