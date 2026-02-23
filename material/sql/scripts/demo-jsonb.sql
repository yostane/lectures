-- Sélection
select * from users;

select email, details->>'lastTalk' as lastTalk from users;
select details || '{"favoriteFood": "Pizza"}' from users;
-- Préciser un chemin (doubler la flèche convertir le résultat en texte)
select email, details->'lastTalk'->>'title' as lastTitle from users;
select email, details#>>'{lastTalk, title}' as lastTitle from users;
-- Accès par index
select email, details->'conferences'->>0 as firstconf from users;
select email, details#>>'{conferences, 0}' as firstconf from users;
select email, details#>>'{lastTalk, keywords, 0}' as first_keyword from users;
select email, details#>'{lastTalk, keywords}'->>0 as first_keyword from users;

-- Update

UPDATE users SET details = jsonb_set(details, '{lastTalk, duration}', '50') WHERE email = 'hello@email.com';
select email, details#>>'{lastTalk, duration}' from users;

-- WHere
SELECT email, details FROM users WHERE details->'lastTalk'@>'{"title": "WebAI"}';
SELECT email, details FROM users WHERE details->'lastTalk'->'title' ? 'WebAI';
-- Item in array
SELECT email, details FROM users WHERE details#>'{lastTalk, keywords}' ? 'wasm';