--liquibase formatted sql

--changeset autkin:create_resident_table
CREATE TABLE public.resident (
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    passport_id uuid NULL,
    email varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    CONSTRAINT resident_pkey PRIMARY KEY (id),
    CONSTRAINT resident_passport_unique UNIQUE (passport_id),
    CONSTRAINT fk_resident_passport FOREIGN KEY (passport_id) REFERENCES public.passport(id)
);
--rollback drop table public.resident;

--changeset autkin:add_resident_comments runOnChange:true
COMMENT ON TABLE public.resident IS 'Таблица для хранения жителей.';
COMMENT ON COLUMN public.resident.id IS 'Уникальный идентификатор жителя';
COMMENT ON COLUMN public.resident.passport_id IS 'Внешний ключ на таблицу passport.';
COMMENT ON COLUMN public.resident.email IS 'Электронная почта.';
COMMENT ON COLUMN public.resident.phone IS 'Номер телефона.';
