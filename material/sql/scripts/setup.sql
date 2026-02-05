DROP FUNCTION IF EXISTS can_login;
DROP TABLE IF EXISTS users;
DROP TYPE IF EXISTS user_status;

CREATE TYPE user_status AS ENUM (
  'not_validated',
  'validated',
  'inactive'
);

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  email VARCHAR(255),
  internal_name TEXT UNIQUE,
  PASSWORD VARCHAR(100),
  status user_status,
  details JSONB
);

INSERT INTO users (email, internal_name, password, status, details) VALUES (
  'hello@email.com',
  'hello',
  'secret',
  'validated', '{
  "conferences": ["devoxx", "DevLille"],
  "lastTalk": {
    "title": "blazor Doom",
    "keywords": ["wasm", "dotnet", "JavaScript"]
  }
}');
INSERT INTO users (email, internal_name, password, status, details) VALUES (
  'toto@email.com',
  'toto',
  'secret',
  'inactive',
  '{
  "lastTalk": {
    "title": "WebAI",
    "keywords": ["Web", "AI", "JavaScript"]
  }
}');

select * from users;