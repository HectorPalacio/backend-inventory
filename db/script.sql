create table proveedores
(
    nombre               varchar(50)          not null,
    direccion            varchar(50)          not null,
    telefono             varchar(20)          not null,
    email                varchar(255),
    lugar_origen         integer              not null,
    estado               boolean default true not null,
    fecha_vinculacion    date,
    fecha_desvinculacion date,
    proveedor_id         bigserial
);