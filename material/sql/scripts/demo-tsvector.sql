DROP TABLE IF EXISTS stories;

CREATE TABLE stories(
   id SERIAL PRIMARY KEY,
   title TEXT NOT NULL,
   body TEXT,
   author TEXT
);


INSERT INTO stories(title, body, author) VALUES
('PostgreSQL tsvector demo', 'This is a demo of the tsvector data type in PostgreSQL. It allows you to store and search text data efficiently.', 'John Doe'),
('Another story', 'This is another story about PostgreSQL and its features.', 'Jane Smith'),
('Full-text search', 'PostgreSQL provides powerful full-text search capabilities using tsvector and tsquery.', 'Alice Johnson');

-- Create a tsvector column for the body of the stories
SELECT to_tsvector('english', body) AS body_vector FROM stories;

-- Search for stories that contain the words 'demo' and 'tsvector'
SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', 'demo & tsvector');
-- Search for stories that contain either 'demo' or 'tsvector'
SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', 'demo | tsvector');
-- Search for stories that do not contain the word 'tsvector'
SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', '!tsvector');
-- Search for stories that contain the exact phrase 'demo of the tsvector'
SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', '''demo of the tsvector''');
-- Search for stories that contain either 'PostgreSQL' or the exact phrase 'demo of the tsvector', and also contain the word 'capabilities'
SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', '(PostgreSQL | ''demo of the tsvector'') & capabilities');
-- websearch_to_tsquery allows for browser-like search syntax, so we can search for stories that contain 'demo' and 'tsvector' using web search syntax
SELECT * FROM stories WHERE to_tsvector('english', body) @@ websearch_to_tsquery('english', 'demo tsvector');

-- Create a GIN index (index type optimized for full-text search) on the body column for faster search
CREATE INDEX idx_body_vector ON stories USING GIN (to_tsvector('english',body));

SELECT * FROM stories WHERE to_tsvector('english', body) @@ to_tsquery('english', 'demo & tsvector');

-- We can alternatively create an ALWAYS GENERATED column for the tsvector of the body
ALTER TABLE stories ADD COLUMN body_vector tsvector GENERATED ALWAYS AS (to_tsvector('english', body)) STORED;

-- Now we can search using the generated column
SELECT * FROM stories WHERE body_vector @@ to_tsquery('english', 'demo & tsvector');

