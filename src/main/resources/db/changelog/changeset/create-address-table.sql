--liquibase formatted sql

--changeset autkin:create_address_table
CREATE TABLE public.address (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	country varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	street varchar(255) NOT NULL,
	house varchar(255) NOT NULL,
	CONSTRAINT address_pkey PRIMARY KEY (id)
);
--rollback drop table public.address;

--changeset autkin:add_address_comments runOnChange:true
COMMENT ON TABLE public.address IS 'Таблица для хранения адрессов домов и прописок жителей.';
COMMENT ON COLUMN public.address.id IS 'Уникальный идентификатор адрес.';
COMMENT ON COLUMN public.address.country IS 'Название страны.';
COMMENT ON COLUMN public.address.city IS 'Название города.';
COMMENT ON COLUMN public.address.street IS 'Название улицы.';
COMMENT ON COLUMN public.address.house IS 'Номер дома.';
