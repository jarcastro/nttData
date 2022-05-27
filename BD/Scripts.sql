CREATE TABLE IF NOT EXISTS afiliado
(
    id integer NOT NULL default nextval('afiliado_id_seq'),
    nombres character varying(200)  NOT NULL,
    apellidos character varying(200)  NOT NULL,
    edad integer  NOT NULL,
    CONSTRAINT pk_afiliado PRIMARY KEY (id)
);


create sequence caso_id_seq
minvalue 1
maxvalue 99999999999
increment by 1;


CREATE TABLE IF NOT EXISTS caso
(
    id integer NOT NULL default nextval('caso_id_seq'),
    nombre character varying(200)  NOT NULL,
    id_afiliado integer  NOT NULL,
    descripcion character varying(200)  NOT NULL,
    CONSTRAINT pk_caso PRIMARY KEY (id),
CONSTRAINT fk_afiliado
      FOREIGN KEY(id) 
	  REFERENCES afiliado(_id)
);