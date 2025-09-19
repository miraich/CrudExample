--liquibase formatted sql

--changeset autkin:create_passport_table
CREATE TABLE public.passport (
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    address_id uuid NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    gender varchar(255) NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT passport_pkey PRIMARY KEY (id),
    CONSTRAINT passport_address_unique UNIQUE (address_id),
    CONSTRAINT fk_passport_address FOREIGN KEY (address_id) REFERENCES public.address(id)
);
--rollback drop table public.passport;

--changeset autkin:add_passport_comments runOnChange:true
COMMENT ON TABLE public.passport IS 'Таблица для хранения паспортов жителей.';
COMMENT ON COLUMN public.passport.id IS 'Уникальный идентификатор паспорта.';
COMMENT ON COLUMN public.passport.address_id IS 'Внешний ключ, связывающий с адресом регистрации из таблицы address.';
COMMENT ON COLUMN public.passport.first_name IS 'Имя владельца паспорта';
COMMENT ON COLUMN public.passport.last_name IS 'Фамилия владельца паспорта';
COMMENT ON COLUMN public.passport.gender IS 'Пол владельца паспорта';
COMMENT ON COLUMN public.passport.birth_date IS 'Дата рождения владельца паспорта';
