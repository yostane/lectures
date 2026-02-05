CREATE USER hello;
CREATE USER toto;

alter table users enable row level security;

create policy "Individuals can view their own details."
on users for select
using ( current_user = internal_name );