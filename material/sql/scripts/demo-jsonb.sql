DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  email VARCHAR(255),
  PASSWORD VARCHAR(100),
  details JSONB
);

INSERT INTO users (email, password, details) VALUES ('hello@email.com', 'secret', '{
  "conferences": ["devoxx", "DevLille"],
  "lastTalk": {
    "title": "blazor Doom",
    "keywords": ["wasm", "dotnet", "JavaScript"]
  }
}');
INSERT INTO users (email, password, details) VALUES ('toto@email.com', 'secret', '{
  "lastTalk": {
    "title": "WebAI",
    "keywords": ["Web", "AI", "JavaScript"]
  }
}');

select * from users;
select email, details->>'lastTalk' as lastTalk from users;
-- Préciser un chemin
select email, details->'lastTalk'->>'title' as lastTitle from users;
select email, details#>>'{lastTalk, title}' as lastTitle from users;
-- Accès par index
select email, details->'conferences'->>0 as firstconf from users;
select email, details#>>'{conferences, 0}' as firstconf from users;