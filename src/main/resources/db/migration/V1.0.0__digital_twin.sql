ALTER SCHEMA ${SCHEMA} OWNER TO ${GROUP};

CREATE TABLE IF NOT EXISTS s_iot_hub_test.message_entity (
  id bigserial,
  name varchar(255) NOT NULL,
  value varchar(255) NOT NULL,
  ts varchar(255) NOT NULL,
  CONSTRAINT message_entity_pkey PRIMARY KEY(id),
)
WITH(OIDS=FALSE);

ALTER TABLE s_iot_hub_test.message_entity TO ${GROUP};
GRANT ALL ON ALL TABLES IN SCHEMA ${SCHEMA} TO ${GROUP};
GRANT ALL ON ALL SEQUENCES IN SCHEMA ${SCHEMA} TO ${GROUP};