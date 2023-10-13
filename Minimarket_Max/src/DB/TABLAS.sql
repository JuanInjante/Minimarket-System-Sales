CREATE DATABASE dbMinimarket
GO

USE dbMinimarket
GO

CREATE TABLE proveedor
(
  codProveedor INT PRIMARY KEY IDENTITY (1,1),
  nombreEmpresa VARCHAR(20) NOT NULL,
  nombre_contacto VARCHAR(20) NOT NULL,
  telefono CHAR(9) NULL,
  estado BIT DEFAULT 1
);
GO

CREATE TABLE categoria
(
  codCategoria INT PRIMARY KEY IDENTITY (1,1),
  nombre VARCHAR(20) NOT NULL,
  estado BIT DEFAULT 1
);
GO

CREATE TABLE cliente
(
  codCliente INT PRIMARY KEY IDENTITY (1,1),
  nombre VARCHAR(20) NOT NULL,
  ap_pat VARCHAR(20) NOT NULL,
  ap_mat VARCHAR(20) NOT NULL,
  dni CHAR (8) UNIQUE,
  telefono CHAR(9) NULL,
  direccion VARCHAR(30) NOT NULL,
  correo_electronico VARCHAR(150) NOT NULL,
  genero CHAR(1) NOT NULL,
  estado BIT DEFAULT 1
);
GO

CREATE TABLE persona
(
  codPersona INT PRIMARY KEY IDENTITY (1,1),
  codigo VARCHAR (10) UNIQUE,
  nombre VARCHAR(20) NOT NULL,
  ap_pat VARCHAR(20) NOT NULL,
  ap_mat VARCHAR(20) NOT NULL,
  dni CHAR (8) UNIQUE,	
  fechaContrato DATE NOT NULL,
  salario INT NOT NULL,
  usuario VARCHAR(20) NOT NULL,
  contrasena VARCHAR(MAX) NOT NULL,
  salt VARBINARY(128),
  cargo VARCHAR(20) NOT NULL,
  estado BIT DEFAULT 1
);
GO

CREATE TABLE producto
(
  codProducto INT PRIMARY KEY IDENTITY (1,1),
  codProveedor INT NOT NULL,
  codCategoria INT NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  descripcion VARCHAR (500) NOT NULL,
  fecha_vencimiento DATE,
  fecha_creacion DATETIME DEFAULT GETDATE(),
  fecha_modificacion DATETIME,
  unidadMedida VARCHAR(10) NOT NULL,
  estado BIT DEFAULT 1
  FOREIGN KEY (codProveedor) REFERENCES proveedor(codProveedor),
  FOREIGN KEY (codCategoria) REFERENCES categoria(codCategoria)
);
GO

CREATE TABLE venta
(
  codVenta INT PRIMARY KEY IDENTITY (1,1),
  codCliente INT NOT NULL,
  codigo_empleado VARCHAR (10) NOT NULL,
  fecha_hora_venta DATETIME DEFAULT GETDATE(),
  tipoComprobante VARCHAR (20) NOT NULL,
  total MONEY,
  igv MONEY NOT NULL,
  estado BIT DEFAULT 1,
  FOREIGN KEY (codCliente) REFERENCES cliente(codCliente)
);
GO

CREATE TABLE detalleventa
(
  codDetalle INT PRIMARY KEY IDENTITY (1,1),
  codVenta INT NOT NULL,
  codProdcutos INT NOT NULL,
  cantidad INT NOT NULL,
  precioUnitario MONEY,
  subTotal MONEY
  FOREIGN KEY (codVenta) REFERENCES venta(codVenta),
  FOREIGN KEY (codProdcutos) REFERENCES producto(codProducto)
);
GO

CREATE TABLE inventario
(
  codIventario INT PRIMARY KEY IDENTITY (1,1),
  codProducto INT NOT NULL,
  codPersona INT NOT NULL,
  stock INT NOT NULL,
  fecha_hora_entrada DATETIME DEFAULT GETDATE(),
  precioCompra MONEY,
  estado BIT DEFAULT 1
  FOREIGN KEY (codProducto) REFERENCES producto(codProducto),
  FOREIGN KEY (codPersona) REFERENCES persona(codPersona)
);
GO
