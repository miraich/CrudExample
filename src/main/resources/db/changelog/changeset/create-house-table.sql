--liquibase formatted sql

--changeset autkin:create_house_table
CREATE TABLE public.house (
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    address_id uuid NOT NULL,
    price numeric(38, 2) NOT NULL,
    CONSTRAINT house_pkey PRIMARY KEY (id),
    CONSTRAINT house_address_unique UNIQUE (address_id),
    CONSTRAINT fk_house_address FOREIGN KEY (address_id) REFERENCES public.address(id)
);
--rollback drop table public.house;

--changeset autkin:add_house_comments runOnChange:true
COMMENT ON TABLE public.house IS 'Таблица для хранения данных о домах, включая привязку к адресу.';
COMMENT ON COLUMN public.house.id IS 'Уникальный идентификатор дома.';
COMMENT ON COLUMN public.house.address_id IS 'Внешний ключ, связывающий дом с адресом (таблица address).';
COMMENT ON COLUMN public.house.price IS 'Стоимость дома в числовом формате.';
