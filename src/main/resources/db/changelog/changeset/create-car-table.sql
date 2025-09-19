--liquibase formatted sql

--changeset autkin:create_car_table
CREATE TABLE public.car (
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    resident_id uuid NULL,
    brand varchar(255) NOT NULL,
    color varchar(255) NOT NULL,
    price numeric(38, 2) NOT NULL,
    CONSTRAINT car_pkey PRIMARY KEY (id),
    CONSTRAINT fk_car_resident FOREIGN KEY (resident_id) REFERENCES public.resident(id)
);
--rollback drop table public.car;

--changeset autkin:add_car_comments runOnChange:true
COMMENT ON TABLE public.car IS 'Таблица для хранения машин.';
COMMENT ON COLUMN public.car.id IS 'Уникальный идентификатор машины.';
COMMENT ON COLUMN public.car.resident_id IS 'Внешний ключ, связывающий автомобиль с владельцем (таблица resident). Может быть NULL, если автомобиль не принадлежит никому.';
COMMENT ON COLUMN public.car.brand IS 'Марка автомобиля.';
COMMENT ON COLUMN public.car.color IS 'Цвет автомобиля.';
COMMENT ON COLUMN public.car.price IS 'Стоимость автомобиля в числовом формате.';
