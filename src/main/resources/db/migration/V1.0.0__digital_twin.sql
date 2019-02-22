ALTER SCHEMA ${SCHEMA} OWNER TO ${GROUP};

CREATE TABLE IF NOT EXISTS adv_hello_world.hello_world (
  id bigserial NOT NULL,
  msg varchar(255) NOT NULL
)
WITH(OIDS=FALSE);



