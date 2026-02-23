DROP FUNCTION IF EXISTS can_login;

CREATE FUNCTION can_login(u users)
RETURNS BOOLEAN as $$
BEGIN
  if u.status in ('inactive') THEN
    RETURN FALSE;
  END IF;
  RETURN TRUE;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

SELECT can_login(u.*) from users as u; 
SELECT can_login(u.*), * from users as u;
SELECT can_login(u.*), email from users as u;
select email, status from users as u where can_login(u);