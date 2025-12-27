/*drop database school;*/
create database school;
use school;

CREATE TABLE empresa (
    id_empresa BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre_comercial VARCHAR(350) NOT NULL,
    nit VARCHAR(15) NOT NULL,
    razon_social VARCHAR(350) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(250) NOT NULL,
    logo LONGBLOB NOT NULL
);

/*1. MATRICUALD@ 2. RETIRAD@ 3. REPROBAD@*/
CREATE TABLE estado_estudiante (
    id_estado_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_estudiante VARCHAR(20) NOT NULL
);

/*1. aprobada 2. reprobada*/
CREATE TABLE estado_asignatura (
    id_estado_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_asignatura VARCHAR(50) NOT NULL
);

/*1. Director 2. Director Financiero 3. Coordinador Academico 4. Coordinador Disciplinario 5. Secretario(a) 6. Docente*/
CREATE TABLE cargo (
    id_cargo BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cargo VARCHAR(20) NOT NULL
);

CREATE TABLE condicion_fisica (
    id_condicion_fisica BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    condicion_fisica VARCHAR(50) NOT NULL,
    cod_condicion VARCHAR(10) NOT NULL
);


CREATE TABLE condicion_psicologica (
    id_condicion_psicologica BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    condicion_psicologica VARCHAR(50) NOT NULL,
    cod_condicion VARCHAR(10)
);

CREATE TABLE tipo_sangre (
    id_tipo_sangre BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_sangre VARCHAR(3) NOT NULL
);

CREATE TABLE tipo_documento (
    id_tipo_documento BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_documento VARCHAR(50) NOT NULL,
    cod_tipo_documento VARCHAR(10) NOT NULL
);

/*1. Empleado 2. Estudiante 3. Acudiente*/
CREATE TABLE rol (
    id_rol BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE grado (
    id_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    grado VARCHAR(15) NOT NULL,
    cod_grado VARCHAR(9) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE persona (
    id_persona BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_empresa BIGINT,
    id_tipo_documento BIGINT,
    numero_documento VARCHAR(50) NOT NULL,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    telefono_1 VARCHAR(12) NOT NULL,
    id_rol BIGINT,
    CONSTRAINT FOREIGN KEY (id_tipo_documento)
        REFERENCES school.tipo_documento (id_tipo_documento),
    CONSTRAINT FOREIGN KEY (id_rol)
        REFERENCES school.rol (id_rol),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
CREATE TABLE estudiante (
    id_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_empresa BIGINT,
    fecha_nacimiento DATE,
    id_tipo_sangre BIGINT,
    id_tipo_condicion_fisica BIGINT,
    id_tipo_condicion_psicologica BIGINT,
    id_estado_estudiante BIGINT,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_tipo_sangre)
        REFERENCES school.tipo_sangre (id_tipo_sangre),
    CONSTRAINT FOREIGN KEY (id_tipo_condicion_fisica)
        REFERENCES school.condicion_fisica (id_condicion_fisica),
    CONSTRAINT FOREIGN KEY (id_tipo_condicion_psicologica)
        REFERENCES school.condicion_psicologica (id_condicion_psicologica),
    CONSTRAINT FOREIGN KEY (id_estado_estudiante)
        REFERENCES school.estado_estudiante (id_estado_estudiante),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE empleado (
    id_empleado BIGINT PRIMARY KEY,
    id_empresa BIGINT,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10 , 2 ),
    id_cargo BIGINT,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_empleado)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_cargo)
        REFERENCES school.cargo (id_cargo),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE estudiante_x_grado (
    id_estudiante_x_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_grado BIGINT,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_grado)
        REFERENCES school.grado (id_grado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asignatura (
    id_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre_asignatura VARCHAR(20) NOT NULL,
    cod_asignatura VARCHAR(12) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE empleado_x_asignatura (
    id_empleado_x_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_asignatura BIGINT,
    id_empleado BIGINT,
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_empleado)
        REFERENCES school.empleado (id_empleado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asignatura_x_grado (
    id_asignatura_x_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_asignatura BIGINT,
    id_grado BIGINT,
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_grado)
        REFERENCES school.grado (id_grado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE estudiante_x_acudiente (
    id_estudiante_x_acudiente BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_acudiente BIGINT,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_acudiente)
        REFERENCES school.persona (id_persona),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
/*CONFIGURACION DE PERIODO Y PESO DE LAS ACTIVIDADES
1. PERIODO ACADEMICO (PERIODO 1,2,3,4)
2. TIPO ACTIVIDAD (TALLER, QUIZ, EVALUACION)
3. ACTIVIDAD EVALUATIVA (COMO TAL LA ACTIVIDAD A REALIZAR)
4. NOTA ESTUDIANTE (NOTA QUE SACO EL ESTUDIANTE EN X ACTIVIDAD)
5. NOTA DEFINITIVA (NOTA CALCULADA AUTOMATICAMENTE AL FINAL DEL PERIODO)
*/
CREATE TABLE periodo_academico (
    id_periodo BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT FALSE,
    fecha_inicio DATETIME,
    fecha_fin DATETIME,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE tipo_actividad (
    id_tipo_actividad BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_actividad VARCHAR(100) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE actividad_evaluativa (
    id_actividad BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    porcentaje DOUBLE NOT NULL,
    id_periodo BIGINT NOT NULL,
    id_asignatura BIGINT NOT NULL,
    id_tipo_actividad BIGINT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa),
    CONSTRAINT FOREIGN KEY (id_periodo)
        REFERENCES school.periodo_academico (id_periodo),
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_tipo_actividad)
        REFERENCES tipo_actividad (id_tipo_actividad)
);
CREATE TABLE nota_estudiante (
    id_nota_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_actividad BIGINT,
    nota decimal(10,2),
    observacion VARCHAR(500),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_actividad)
        REFERENCES school.actividad_evaluativa (id_actividad),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
CREATE TABLE nota_definitiva_periodo (
    id_definitiva BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_asignatura BIGINT,
    id_periodo BIGINT,
    promedio_final DOUBLE,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_periodo)
        REFERENCES school.periodo_academico (id_periodo),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE credencial (
    id_credencial BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username_ VARCHAR(50) NOT NULL,
    password_ VARCHAR(255) NOT NULL,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE contrato (
    id_contrato BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_inicio_periodo DATE NOT NULL,
    fecha_fin_periodo DATE NOT NULL,
    id_empleado BIGINT,
    contrato_pdf LONGBLOB,
    ruta_contrato VARCHAR(255),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE metodo_pago (
    id_metodo_pago BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    metodo_pago VARCHAR(50) NOT NULL
);

CREATE TABLE cuentas_contables (
    id_cuenta BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    codigo_puc BIGINT NOT NULL,
    nombre_cuenta VARCHAR(150) NOT NULL,
    tipo_cuenta VARCHAR(150) NOT NULL,
    naturaleza VARCHAR(150) NOT NULL
);

CREATE TABLE tipo_comprobante (
    id_tipo_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_comprobante VARCHAR(150) NOT NULL
);

CREATE TABLE estado_comprobante (
    id_estado_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(250) NOT NULL
);

CREATE TABLE comprobante (
    id_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_tipo_comprobante BIGINT,
    fecha_registro DATETIME NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    consecutivo VARCHAR(1000) NOT NULL,
    id_estado_comprobante BIGINT,
    CONSTRAINT FOREIGN KEY (id_tipo_comprobante)
        REFERENCES school.tipo_comprobante (id_tipo_comprobante),
    CONSTRAINT FOREIGN KEY (id_estado_comprobante)
        REFERENCES school.estado_comprobante (id_estado_comprobante),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asiento_contable (
    id_asiento_contable BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_comprobante BIGINT,
    id_cuenta BIGINT,
    tipo_movimiento VARCHAR(50) NOT NULL,
    valor_monto FLOAT NOT NULL,
    descripcion VARCHAR(5000),
    CONSTRAINT FOREIGN KEY (id_comprobante)
        REFERENCES school.comprobante (id_comprobante),
    CONSTRAINT FOREIGN KEY (id_cuenta)
        REFERENCES school.cuentas_contables (id_cuenta),
        /*drop database school;*/
create database school;
use school;

CREATE TABLE empresa (
    id_empresa BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre_comercial VARCHAR(350) NOT NULL,
    nit VARCHAR(15) NOT NULL,
    razon_social VARCHAR(350) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(250) NOT NULL,
    logo LONGBLOB NOT NULL
);

/*1. MATRICUALD@ 2. RETIRAD@ 3. REPROBAD@*/
CREATE TABLE estado_estudiante (
    id_estado_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_estudiante VARCHAR(20) NOT NULL
);

/*1. aprobada 2. reprobada*/
CREATE TABLE estado_asignatura (
    id_estado_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_asignatura VARCHAR(50) NOT NULL
);

/*1. Director 2. Director Financiero 3. Coordinador Academico 4. Coordinador Disciplinario 5. Secretario(a) 6. Docente*/
CREATE TABLE cargo (
    id_cargo BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cargo VARCHAR(20) NOT NULL
);

CREATE TABLE condicion_fisica (
    id_condicion_fisica BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    condicion_fisica VARCHAR(50) NOT NULL,
    cod_condicion VARCHAR(10) NOT NULL
);


CREATE TABLE condicion_psicologica (
    id_condicion_psicologica BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    condicion_psicologica VARCHAR(50) NOT NULL,
    cod_condicion VARCHAR(10)
);

CREATE TABLE tipo_sangre (
    id_tipo_sangre BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_sangre VARCHAR(3) NOT NULL
);

CREATE TABLE tipo_documento (
    id_tipo_documento BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_documento VARCHAR(50) NOT NULL,
    cod_tipo_documento VARCHAR(10) NOT NULL
);

/*1. Empleado 2. Estudiante 3. Acudiente*/
CREATE TABLE rol (
    id_rol BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE grado (
    id_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    grado VARCHAR(15) NOT NULL,
    cod_grado VARCHAR(9) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE persona (
    id_persona BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_empresa BIGINT,
    id_tipo_documento BIGINT,
    numero_documento VARCHAR(50) NOT NULL,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    telefono_1 VARCHAR(12) NOT NULL,
    id_rol BIGINT,
    CONSTRAINT FOREIGN KEY (id_tipo_documento)
        REFERENCES school.tipo_documento (id_tipo_documento),
    CONSTRAINT FOREIGN KEY (id_rol)
        REFERENCES school.rol (id_rol),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
CREATE TABLE estudiante (
    id_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_empresa BIGINT,
    fecha_nacimiento DATE,
    id_tipo_sangre BIGINT,
    id_tipo_condicion_fisica BIGINT,
    id_tipo_condicion_psicologica BIGINT,
    id_estado_estudiante BIGINT,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_tipo_sangre)
        REFERENCES school.tipo_sangre (id_tipo_sangre),
    CONSTRAINT FOREIGN KEY (id_tipo_condicion_fisica)
        REFERENCES school.condicion_fisica (id_condicion_fisica),
    CONSTRAINT FOREIGN KEY (id_tipo_condicion_psicologica)
        REFERENCES school.condicion_psicologica (id_condicion_psicologica),
    CONSTRAINT FOREIGN KEY (id_estado_estudiante)
        REFERENCES school.estado_estudiante (id_estado_estudiante),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE empleado (
    id_empleado BIGINT PRIMARY KEY,
    id_empresa BIGINT,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10 , 2 ),
    id_cargo BIGINT,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_empleado)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (id_cargo)
        REFERENCES school.cargo (id_cargo),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE estudiante_x_grado (
    id_estudiante_x_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_grado BIGINT,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_grado)
        REFERENCES school.grado (id_grado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asignatura (
    id_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre_asignatura VARCHAR(20) NOT NULL,
    cod_asignatura VARCHAR(12) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE empleado_x_asignatura (
    id_empleado_x_asignatura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_asignatura BIGINT,
    id_empleado BIGINT,
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_empleado)
        REFERENCES school.empleado (id_empleado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asignatura_x_grado (
    id_asignatura_x_grado BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_asignatura BIGINT,
    id_grado BIGINT,
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_grado)
        REFERENCES school.grado (id_grado),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE estudiante_x_acudiente (
    id_estudiante_x_acudiente BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_acudiente BIGINT,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_acudiente)
        REFERENCES school.persona (id_persona),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
/*CONFIGURACION DE PERIODO Y PESO DE LAS ACTIVIDADES
1. PERIODO ACADEMICO (PERIODO 1,2,3,4)
2. TIPO ACTIVIDAD (TALLER, QUIZ, EVALUACION)
3. ACTIVIDAD EVALUATIVA (COMO TAL LA ACTIVIDAD A REALIZAR)
4. NOTA ESTUDIANTE (NOTA QUE SACO EL ESTUDIANTE EN X ACTIVIDAD)
5. NOTA DEFINITIVA (NOTA CALCULADA AUTOMATICAMENTE AL FINAL DEL PERIODO)
*/
CREATE TABLE periodo_academico (
    id_periodo BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT FALSE,
    fecha_inicio DATETIME,
    fecha_fin DATETIME,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE tipo_actividad (
    id_tipo_actividad BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_actividad VARCHAR(100) NOT NULL,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE actividad_evaluativa (
    id_actividad BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    porcentaje DOUBLE NOT NULL,
    id_periodo BIGINT NOT NULL,
    id_asignatura BIGINT NOT NULL,
    id_tipo_actividad BIGINT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa),
    CONSTRAINT FOREIGN KEY (id_periodo)
        REFERENCES school.periodo_academico (id_periodo),
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_tipo_actividad)
        REFERENCES tipo_actividad (id_tipo_actividad)
);
CREATE TABLE nota_estudiante (
    id_nota_estudiante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_actividad BIGINT,
    nota decimal(10,2),
    observacion VARCHAR(500),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_actividad)
        REFERENCES school.actividad_evaluativa (id_actividad),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);
CREATE TABLE nota_definitiva_periodo (
    id_definitiva BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_estudiante BIGINT,
    id_asignatura BIGINT,
    id_periodo BIGINT,
    promedio_final DOUBLE,
    CONSTRAINT FOREIGN KEY (id_estudiante)
        REFERENCES school.estudiante (id_estudiante),
    CONSTRAINT FOREIGN KEY (id_asignatura)
        REFERENCES school.asignatura (id_asignatura),
    CONSTRAINT FOREIGN KEY (id_periodo)
        REFERENCES school.periodo_academico (id_periodo),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE credencial (
    id_credencial BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username_ VARCHAR(50) NOT NULL,
    password_ VARCHAR(255) NOT NULL,
    id_persona BIGINT,
    CONSTRAINT FOREIGN KEY (id_persona)
        REFERENCES school.persona (id_persona),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE contrato (
    id_contrato BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_inicio_periodo DATE NOT NULL,
    fecha_fin_periodo DATE NOT NULL,
    id_empleado BIGINT,
    contrato_pdf LONGBLOB,
    ruta_contrato VARCHAR(255),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE metodo_pago (
    id_metodo_pago BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    metodo_pago VARCHAR(50) NOT NULL
);

CREATE TABLE cuentas_contables (
    id_cuenta BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    codigo_puc BIGINT NOT NULL,
    nombre_cuenta VARCHAR(150) NOT NULL,
    tipo_cuenta VARCHAR(150) NOT NULL,
    naturaleza VARCHAR(150) NOT NULL
);

CREATE TABLE tipo_comprobante (
    id_tipo_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_comprobante VARCHAR(150) NOT NULL
);

CREATE TABLE estado_comprobante (
    id_estado_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(250) NOT NULL
);

CREATE TABLE comprobante (
    id_comprobante BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_tipo_comprobante BIGINT,
    fecha_registro DATETIME NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    consecutivo VARCHAR(1000) NOT NULL,
    id_estado_comprobante BIGINT,
    CONSTRAINT FOREIGN KEY (id_tipo_comprobante)
        REFERENCES school.tipo_comprobante (id_tipo_comprobante),
    CONSTRAINT FOREIGN KEY (id_estado_comprobante)
        REFERENCES school.estado_comprobante (id_estado_comprobante),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE asiento_contable (
    id_asiento_contable BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_comprobante BIGINT,
    id_cuenta BIGINT,
    tipo_movimiento VARCHAR(50) NOT NULL,
    valor_monto FLOAT NOT NULL,
    descripcion VARCHAR(5000),
    CONSTRAINT FOREIGN KEY (id_comprobante)
        REFERENCES school.comprobante (id_comprobante),
    CONSTRAINT FOREIGN KEY (id_cuenta)
        REFERENCES school.cuentas_contables (id_cuenta)
);

CREATE TABLE estado_factura (
    id_estado_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_factura VARCHAR(50) NOT NULL
);

CREATE TABLE impuesto (
    id_impuesto BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    valor_porcentaje FLOAT NOT NULL,
    impuesto VARCHAR(15) NOT NULL
);

CREATE TABLE producto_servicio (
    id_producto_servicio BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_producto_servicio VARCHAR(15) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    precio_unitario FLOAT NOT NULL,
    codigo_dian VARCHAR(15) NOT NULL,
    impuestos_aplicables BIGINT,
    CONSTRAINT FOREIGN KEY (impuestos_aplicables)
        REFERENCES school.impuesto (id_impuesto),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE factura (
    id_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_venta DATETIME NOT NULL,
    fecha_vencimiento DATETIME NOT NULL,
    descripcion_venta VARCHAR(150),
    estado_factura BIGINT,
    id_empresa BIGINT,
    id_cliente BIGINT,
    metodo_pago BIGINT,
    CONSTRAINT FOREIGN KEY (estado_factura)
        REFERENCES school.estado_factura (id_estado_factura),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa),
    CONSTRAINT FOREIGN KEY (id_cliente)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (metodo_pago)
        REFERENCES school.metodo_pago (id_metodo_pago),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE detalle_factura (
    id_detalle_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_factura BIGINT,
    id_producto BIGINT,
    cantidad BIGINT,
    precio_unitario FLOAT,
    CONSTRAINT FOREIGN KEY (id_factura)
        REFERENCES school.factura (id_factura),
    CONSTRAINT FOREIGN KEY (id_producto)
        REFERENCES school.producto_servicio (id_producto_servicio),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE estado_factura (
    id_estado_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_factura VARCHAR(50) NOT NULL
);

CREATE TABLE impuesto (
    id_impuesto BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    valor_porcentaje FLOAT NOT NULL,
    impuesto VARCHAR(15) NOT NULL
);

CREATE TABLE producto_servicio (
    id_producto_servicio BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_producto_servicio VARCHAR(15) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    precio_unitario FLOAT NOT NULL,
    codigo_dian VARCHAR(15) NOT NULL,
    impuestos_aplicables BIGINT,
    CONSTRAINT FOREIGN KEY (impuestos_aplicables)
        REFERENCES school.impuesto (id_impuesto),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE factura (
    id_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_venta DATETIME NOT NULL,
    fecha_vencimiento DATETIME NOT NULL,
    descripcion_venta VARCHAR(150),
    estado_factura BIGINT,
    id_empresa BIGINT,
    id_cliente BIGINT,
    metodo_pago BIGINT,
    CONSTRAINT FOREIGN KEY (estado_factura)
        REFERENCES school.estado_factura (id_estado_factura),
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa),
    CONSTRAINT FOREIGN KEY (id_cliente)
        REFERENCES school.persona (id_persona),
    CONSTRAINT FOREIGN KEY (metodo_pago)
        REFERENCES school.metodo_pago (id_metodo_pago),
        id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);

CREATE TABLE detalle_factura (
    id_detalle_factura BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_factura BIGINT,
    id_producto BIGINT,
    cantidad BIGINT,
    precio_unitario FLOAT,
    CONSTRAINT FOREIGN KEY (id_factura)
        REFERENCES school.factura (id_factura),
    CONSTRAINT FOREIGN KEY (id_producto)
        REFERENCES school.producto_servicio (id_producto_servicio),
    id_empresa BIGINT,
    CONSTRAINT FOREIGN KEY (id_empresa)
        REFERENCES school.empresa (id_empresa)
);