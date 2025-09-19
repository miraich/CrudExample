--liquibase formatted sql

--changeset autkin:create_resident_house_table
CREATE TABLE public.resident_house (
    house_id uuid NOT NULL,
    resident_id uuid NOT NULL,
    CONSTRAINT resident_house_pkey PRIMARY KEY (house_id, resident_id),
    CONSTRAINT fk_resident_house_house FOREIGN KEY (house_id) REFERENCES public.house(id),
    CONSTRAINT fk_resident_house_resident FOREIGN KEY (resident_id) REFERENCES public.resident(id)
);
--rollback drop table public.resident_house;

--changeset autkin:add_resident_house_comments runOnChange:true
COMMENT ON TABLE public.resident_house IS 'Таблица many-to-many, хранящая связки житель-дом, т.е владельцев домов.';
COMMENT ON COLUMN public.resident_house.house_id IS 'Внешний ключ на таблицу house.';
COMMENT ON COLUMN public.resident_house.resident_id IS 'Внешний ключ на таблицу resident.';
