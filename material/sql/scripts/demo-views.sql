DROP VIEW IF EXISTS last_talk_titles;

CREATE VIEW last_talk_titles 
AS SELECT email, details#>>'{"lastTalk", "title"}' AS talk FROM users;

SELECT * FROM last_talk_titles;