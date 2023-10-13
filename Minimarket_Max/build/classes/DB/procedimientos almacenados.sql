USE dbMinimarket
GO

IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_proveedor]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_proveedor]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_proveedor]
(
    @nombreEmpresa VARCHAR(20),
    @nombre_contacto VARCHAR(20),
    @telefono CHAR(9) = NULL,
    @estado BIT = 1
)
AS
BEGIN TRY

    BEGIN TRAN

    INSERT INTO proveedor (nombreEmpresa, nombre_contacto, telefono)
    VALUES (@nombreEmpresa, @nombre_contacto, @telefono)

    COMMIT TRAN

    SELECT 1 AS Estado, 'Se insertó correctamente el proveedor' AS Mensaje
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC sp_insert_proveedor 'NESCAFE', 'Martinez', '923325587'
SELECT*FROM proveedor
----------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_update_proveedor]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_proveedor]
END
GO

CREATE PROCEDURE [dbo].[sp_update_proveedor]
(
    @codProveedor INT,
    @nombreEmpresa VARCHAR(20) =NULL,
    @nombre_contacto VARCHAR(20) = NULL,
    @telefono CHAR(9) = NULL,
    @estado BIT = NULL
)
AS
BEGIN TRY
	IF EXISTS (SELECT 1 FROM proveedor WHERE codProveedor = @codProveedor)
	BEGIN
		BEGIN TRAN

		UPDATE proveedor
		SET
			nombreEmpresa = ISNULL(@nombreEmpresa, nombreEmpresa),
			nombre_contacto = ISNULL(@nombre_contacto, nombre_contacto),
			telefono = ISNULL(@telefono, telefono),
			estado = ISNULL(@estado, estado)
		WHERE
			codProveedor = @codProveedor

		COMMIT TRAN

		SELECT 1 AS Estado, 'Se actualizó correctamente el proveedor' AS Mensaje
	END
	ELSE
	BEGIN
		SELECT 0 AS Estado,'El proveedor con el codProveedor especificado no existe' AS Mensaje
	END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC [dbo].[sp_update_proveedor] @codProveedor = 1, @nombreEmpresa = 'NESTLE'
select*from proveedor
---------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_proveedor]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_proveedor]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_proveedor]
(
  @codProveedor INT
)
AS
BEGIN TRY

    IF EXISTS (SELECT 1 FROM proveedor WHERE codProveedor = @codProveedor)
    BEGIN
		BEGIN TRAN

        UPDATE proveedor
        SET estado = 0 
        WHERE codProveedor = @codProveedor

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se marcó como inactivo el proveedor' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC sp_delete_proveedor @codProveedor = 1
select*from proveedor
--------------------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_proveedor]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_proveedor]
END
GO

CREATE PROCEDURE [dbo].[sp_buscar_proveedor]
(
    @nombreEmpresa VARCHAR(20) = NULL,
    @nombre_contacto VARCHAR(20) = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    SELECT *
    FROM proveedor
    WHERE 
		(@nombreEmpresa IS NULL OR nombreEmpresa LIKE '%' + @nombreEmpresa + '%')
        AND (@nombre_contacto IS NULL OR nombre_contacto LIKE '%' + @nombre_contacto + '%')
        AND (@estado IS NULL OR estado = @estado )
END
GO

EXEC sp_buscar_proveedores @ESTADO = 1
------------------------------------------------------------------------------------------


					--CATEGORIA--


IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_categoria]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_categoria]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_categoria]
(
    @nombre VARCHAR(20),
    @estado BIT = 1
)
AS
BEGIN TRY

    BEGIN TRAN

    INSERT INTO categoria (nombre)
    VALUES (@nombre)

    COMMIT TRAN

    SELECT 1 AS Estado, 'Se insertó correctamente la categoria' AS Mensaje
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

-- Ejemplo de uso del procedimiento almacenado
EXEC sp_insert_categoria 'CAFES'
select*from categoria
-------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_upadate_categoria]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_categoria]
END
GO

CREATE PROCEDURE [dbo].[sp_update_categoria]
(
	@codCategoria INT,
    @nombre VARCHAR(20) = NULL,
	@estado BIT = NULL
)
AS
BEGIN TRY
	IF EXISTS (SELECT 1 FROM categoria WHERE codCategoria = @codCategoria)
	BEGIN
		BEGIN TRAN

		UPDATE categoria
		SET
			    nombre = ISNULL(@nombre, nombre),
				estado = ISNULL(@estado, estado)
		WHERE
			codCategoria = @codCategoria

		COMMIT TRAN

		SELECT 1 AS Estado, 'Se actualizó correctamente la categoria' AS Mensaje
	END
	ELSE
	BEGIN
		SELECT 0 AS Estado,'La categoria con el codCategoria especificado no existe' AS Mensaje
	END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC sp_update_categoria @codCategoria = 5, @nombre = 'FRUTAS', @estado =  1
----------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_categoria]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_categoria]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_categoria]
(
  @codCategoria INT
)
AS
BEGIN TRY

    IF EXISTS (SELECT 1 FROM categoria WHERE codCategoria = @codCategoria)
    BEGIN
		BEGIN TRAN
			UPDATE categoria
			SET estado = 0 
			WHERE codCategoria = @codCategoria

			COMMIT TRAN

			SELECT 1 AS Estado, 'Se marcó como inactiva la categoría' AS Mensaje
		END
	END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO


EXEC sp_delete_categoria @codCategoria = 1
----------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_categoria]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_categoria]
END
GO

CREATE PROCEDURE [dbo].[sp_buscar_categoria]
(
    @nombre VARCHAR(20) = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    SELECT *
    FROM categoria
    WHERE 
		(@nombre IS NULL OR nombre LIKE '%' + @nombre + '%')
	   AND (@estado IS NULL OR estado = @estado )
END
GO

EXEC [dbo].[sp_buscar_categoria]@estado = 1

--------------------------------------------------------------------------------------------


			--CLIENTE--


IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_cliente]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_cliente]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_cliente]
(
  @nombre VARCHAR(20),
  @ap_pat VARCHAR(20),
  @ap_mat VARCHAR(20),
  @dni CHAR (8),
  @telefono CHAR(9),
  @direccion VARCHAR(30),
  @correo_electronico VARCHAR(150),
  @genero CHAR(1),
  @estado BIT = 1
)
AS
BEGIN TRY

    BEGIN TRAN

    INSERT INTO cliente (nombre, ap_pat, ap_mat, dni, telefono, direccion, correo_electronico, genero)
    VALUES (@nombre, @ap_pat, @ap_mat, @dni, @telefono, @direccion, @correo_electronico, @genero)

    COMMIT TRAN

    SELECT 1 AS Estado, 'Se insertó correctamente el cliente' AS Mensaje
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC sp_insert_cliente 'JEAN', 'CHACALCAJE', 'CANALES', '71237458', 925748963, 'PUEBLO NUEVO', 'piero@gmail.com', 'H'
SELECT*FROM cliente
-----------------------------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_update_cliente]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_cliente]
END
GO

CREATE PROCEDURE [dbo].[sp_update_cliente]
(
  @codCliente INT,
  @nombre VARCHAR(20) = NULL,
  @ap_pat VARCHAR(20) = NULL,
  @ap_mat VARCHAR(20) = NULL,
  @dni CHAR (8) = NULL,
  @telefono CHAR(9) = NULL,
  @direccion VARCHAR(30) = NULL,
  @correo_electronico VARCHAR(150) = NULL,
  @genero CHAR(1) = NULL,
  @estado BIT = NULL
)
AS
BEGIN TRY
	IF EXISTS (SELECT 1 FROM cliente WHERE codCliente = @codCliente)
	BEGIN
		BEGIN TRAN

		UPDATE cliente
		SET
			    nombre = ISNULL(@nombre, nombre),
				ap_pat = ISNULL(@ap_pat, ap_pat),
				ap_mat = ISNULL(@ap_mat, ap_mat),
				dni = ISNULL(@dni, dni),
				telefono = ISNULL(@telefono, telefono),
				direccion = ISNULL(@direccion, direccion),
				correo_electronico = ISNULL(@correo_electronico, correo_electronico),
				genero = ISNULL(@genero, genero),
				estado = ISNULL(@estado, estado) 
		WHERE
			codCliente = @codCliente

		COMMIT TRAN

		SELECT 1 AS Estado, 'Se actualizó correctamente el cliente' AS Mensaje
	END
	ELSE
	BEGIN
		SELECT 0 AS Estado,'El cliente con el codCliente especificado no existe' AS Mensaje
	END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC sp_update_cliente @codCliente = 3, @nombre = 'JOSH', @ap_pat = 'CAMPOS', 
@ap_mat = 'OLACHEA', @dni = '74741415', @telefono = '985547417', @direccion = 'CAMINO EL INCA', @correo_electronico = 'josh@gmail.com', @genero = 'F'

-------------------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_cliente]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_cliente]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_cliente]
(
  @codCliente INT
)
AS
BEGIN TRY
    
    IF EXISTS (SELECT 1 FROM cliente WHERE codCliente = @codCliente)
    BEGIN
		BEGIN TRAN

        UPDATE cliente
        SET estado = 0 
        WHERE codCliente = @codCliente

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se marcó como inactivo el cliente' AS Mensaje
		
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO


EXEC sp_delete_cliente 3
--------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_cliente]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_cliente]
END
GO

CREATE PROCEDURE [dbo].[sp_buscar_cliente]
(
    @nombre VARCHAR(20) = NULL,
	@ap_pat VARCHAR(20) = NULL,
	@ap_mat VARCHAR(20) = NULL,
	@dni CHAR(8) = NULL,
	@genero CHAR(1) = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    SELECT *
    FROM cliente
    WHERE 
		(@nombre IS NULL OR nombre LIKE '%' + @nombre + '%')
        AND (@ap_pat IS NULL OR ap_pat LIKE '%' + @ap_pat + '%')
        AND (@ap_mat IS NULL OR ap_mat LIKE '%' + @ap_mat + '%')
        AND (@dni IS NULL OR dni = @dni)
        AND (@genero IS NULL OR genero = @genero)
        AND (@estado IS NULL OR estado = @estado)
END
GO

EXEC sp_buscar_clientes @genero = 'M'
----------------------------------------------------------------------------


			--PERSONA--


IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_persona]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_persona]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_persona]
(
  @codigo VARCHAR(10),
  @nombre VARCHAR(20),
  @ap_pat VARCHAR(20),
  @ap_mat VARCHAR(20),
  @dni CHAR(8),
  @fechaContrato DATE,
  @salario INT,
  @usuario VARCHAR(20),
  @contrasena VARCHAR(MAX),
  @cargo VARCHAR(20),
  @estado BIT = 1
)
AS
BEGIN TRY
    BEGIN TRAN

    DECLARE @salt VARBINARY(128)
    SET @salt = CAST(NEWID() AS VARBINARY(128))

    SET @contrasena = HASHBYTES('SHA2_512', CONVERT(VARCHAR(MAX), @salt) + @contrasena)

    INSERT INTO persona (codigo, nombre, ap_pat, ap_mat, dni, fechaContrato, salario, usuario, contrasena, salt, cargo)
    VALUES (@codigo, @nombre, @ap_pat, @ap_mat, @dni, @fechaContrato, @salario, @usuario, @contrasena, @salt, @cargo)

    COMMIT TRAN

    SELECT 1 AS Estado, 'Se insertó correctamente la persona' AS Mensaje
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC [dbo].[sp_insert_persona]
    @codigo = '#E001',
    @nombre = 'Juan',
    @ap_pat = 'INJANTE',
    @ap_mat = 'MARMOLEJO',
    @dni = '74123658',
    @fechaContrato = '2023-10-04',
    @salario = 10000,
	@usuario = 'DiegitoG_S',
	@contrasena = '12345',
	@cargo = 'EMPLEADO'

	select*from persona
-----------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_update_persona]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_persona]
END
GO

CREATE PROCEDURE [dbo].[sp_update_persona]
(
  @codPersona INT,
  @nombre VARCHAR(20) = NULL,
  @ap_pat VARCHAR(20) = NULL,
  @ap_mat VARCHAR(20) = NULL,
  @salario INT = NULL,
  @usuario VARCHAR(20) = NULL,
  @estado BIT = NULL
)
AS
BEGIN TRY
    BEGIN TRAN

    IF EXISTS (SELECT 1 FROM persona WHERE codPersona = @codPersona)
    BEGIN
        UPDATE persona
        SET
            nombre = ISNULL(@nombre, nombre),
            ap_pat = ISNULL(@ap_pat, ap_pat),
            ap_mat = ISNULL(@ap_mat, ap_mat),
            salario = ISNULL(@salario, salario),
			usuario = ISNULL(@usuario,usuario),
            estado = ISNULL(@estado, estado)
        WHERE
            codPersona = @codPersona

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se actualizó correctamente la persona' AS Mensaje
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'La persona no existe en la tabla' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO
USE dbMinimarket
--------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_persona]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_persona]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_persona]
(
  @codPersona INT
)
AS
BEGIN TRY
    BEGIN TRAN

    IF EXISTS (SELECT 1 FROM persona WHERE codPersona = @codPersona)
    BEGIN
        UPDATE persona
        SET estado = 0 
        WHERE codPersona = @codPersona

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se marcó como inactiva la persona' AS Mensaje
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'La persona no existe en la tabla' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO



----------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_persona]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_persona]
END
GO

CREATE PROCEDURE [dbo].[sp_buscar_persona]
(
    @codigo VARCHAR (10) = NULL,
	@nombre VARCHAR(20) = NULL,
    @ap_pat VARCHAR(20) = NULL,
    @ap_mat VARCHAR(20) = NULL,
    @dni CHAR(8) = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    SELECT *
    FROM persona
    WHERE
        (@codigo IS NULL OR codigo LIKE '%' + @codigo + '%')
		AND (@nombre IS NULL OR nombre LIKE '%' + @nombre + '%')
        AND (@ap_pat IS NULL OR ap_pat LIKE '%' + @ap_pat + '%')
        AND (@ap_mat IS NULL OR ap_mat LIKE '%' + @ap_mat + '%')
        AND (@dni IS NULL OR dni = @dni)
        AND (@estado IS NULL OR estado = @estado)
END
GO
----------------------------------------------------------------------------------------------



		--PRODUCTO--

IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_producto]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_producto]
END
GO

ALTER PROCEDURE [dbo].[sp_insert_producto]
(
  @codProveedor INT,
  @codCategoria INT,
  @nombre VARCHAR(20),
  @descripcion VARCHAR(500),
  @fecha_vencimiento DATE = NULL,
  @unidadMedida VARCHAR(10)
)
AS
BEGIN TRY
    BEGIN TRAN


    IF EXISTS (SELECT 1 FROM proveedor WHERE codProveedor = @codProveedor) AND
       EXISTS (SELECT 1 FROM categoria WHERE codCategoria = @codCategoria)
    BEGIN
        INSERT INTO producto (codProveedor, codCategoria, nombre, descripcion, fecha_vencimiento, unidadMedida)
        VALUES (@codProveedor, @codCategoria, @nombre, @descripcion, @fecha_vencimiento, @unidadMedida)

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se insertó correctamente el producto' AS Mensaje
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'El proveedor o la categoría no existen en las tablas correspondientes' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC [dbo].[sp_insert_producto] 1, 1, 'MILO', 'PARA TODOS', '2025-05-15', 'Kg' 
select*from producto
--------------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_update_producto]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_producto]
END
GO

CREATE PROCEDURE [dbo].[sp_update_producto]
(
  @codProducto INT,
  @codProveedor INT,
  @codCategoria INT,
  @nombre VARCHAR(20) = NULL,
  @descripcion VARCHAR(500) = NULL,
  @fecha_vencimiento DATE = NULL,
  @unidadMedida VARCHAR(10) = NULL,
  @estado BIT = NULL
)
AS
BEGIN TRY
    BEGIN TRAN

    IF EXISTS (SELECT 1 FROM producto WHERE codProducto = @codProducto)
    BEGIN

        IF EXISTS (SELECT 1 FROM proveedor WHERE codProveedor = @codProveedor) AND
           EXISTS (SELECT 1 FROM categoria WHERE codCategoria = @codCategoria)
        BEGIN
            UPDATE producto
            SET
                nombre = ISNULL(@nombre, nombre),
                descripcion = ISNULL(@descripcion, descripcion),
                fecha_vencimiento = ISNULL(@fecha_vencimiento, fecha_vencimiento),
				fecha_modificacion = GETDATE(),
                unidadMedida = ISNULL(@unidadMedida, unidadMedida),
                estado = ISNULL(@estado, estado)
            WHERE
                codProducto = @codProducto

            COMMIT TRAN

            SELECT 1 AS Estado, 'Se actualizó correctamente el producto' AS Mensaje
        END
        ELSE
        BEGIN
            ROLLBACK TRAN
            SELECT 0 AS Estado, 'El proveedor o la categoría no existen en las tablas correspondientes' AS Mensaje
        END
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'El producto no existe' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

EXEC [dbo].[sp_update_producto] @codProducto = 1, @codProveedor = 1, @codCategoria = 2, @descripcion = 'ELABORADO EN PERU'
----------------------------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_producto]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_producto]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_producto]
(
  @codProducto INT
)
AS
BEGIN TRY
    BEGIN TRAN

    IF EXISTS (SELECT 1 FROM producto WHERE codProducto = @codProducto)
    BEGIN
        IF EXISTS (SELECT 1 FROM proveedor WHERE codProveedor = (SELECT codProveedor FROM producto WHERE codProducto = @codProducto)) AND
           EXISTS (SELECT 1 FROM categoria WHERE codCategoria = (SELECT codCategoria FROM producto WHERE codProducto = @codProducto))
        BEGIN
            UPDATE producto
            SET estado = 0 
            WHERE codProducto = @codProducto

            COMMIT TRAN

            SELECT 1 AS Estado, 'Se marcó como inactivo el producto' AS Mensaje
        END
        ELSE
        BEGIN
            ROLLBACK TRAN
            SELECT 0 AS Estado, 'El proveedor o la categoría no existen en las tablas correspondientes' AS Mensaje
        END
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'El producto no existe en la tabla' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO


-------------------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_producto]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_producto]
END
GO

alter PROCEDURE [dbo].[sp_buscar_producto]
(
    @nombre VARCHAR(20) = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    SELECT *
    FROM producto
    WHERE
        (@nombre IS NULL OR nombre LIKE '%' + @nombre + '%')
        AND (@estado IS NULL OR estado = @estado)
END
GO

EXEC [dbo].[sp_buscar_producto] @nombre= 'NESCAFÉ'
---------------------------------------------------------------------------------------------------


				--VENTA--

IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_venta]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_venta]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_venta]
(
  @codCliente INT,
  @codigo_empleado VARCHAR(10),
  @tipoComprobante VARCHAR(20),
  @estado BIT = 1
)
AS
BEGIN TRY
    BEGIN TRAN

    IF EXISTS (SELECT 1 FROM cliente WHERE codCliente = @codCliente)
    BEGIN
        INSERT INTO venta (codCliente, codigo_empleado, tipoComprobante)
        VALUES (@codCliente, @codigo_empleado, @tipoComprobante)

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se insertó correctamente la venta' AS Mensaje
    END
    ELSE
    BEGIN	
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'El cliente no existe en la tabla' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO

----------------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_venta]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_venta]
END
GO

CREATE PROCEDURE [dbo].[sp_delete_venta]
(
  @codVenta INT
)
AS
BEGIN TRY
    BEGIN TRAN


    IF EXISTS (SELECT 1 FROM venta WHERE codVenta = @codVenta)
    BEGIN
        UPDATE venta
        SET estado = 0 
        WHERE codVenta = @codVenta

        COMMIT TRAN

        SELECT 1 AS Estado, 'Se marcó como inactiva la venta' AS Mensaje
    END
    ELSE
    BEGIN
        ROLLBACK TRAN
        SELECT 0 AS Estado, 'La venta no existe en la tabla' AS Mensaje
    END
END TRY
BEGIN CATCH
    ROLLBACK TRAN
    SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
END CATCH
GO


-------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_venta]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_venta]
END
GO

CREATE PROCEDURE [dbo].[sp_buscar_venta]
(
    @tipoComprobante VARCHAR(20) = NULL,
    @estado BIT = NULL,
    @codigo_empleado VARCHAR(10) = NULL
)
AS
BEGIN
    SELECT *
    FROM venta
    WHERE
        (@tipoComprobante IS NULL OR tipoComprobante LIKE '%' + @tipoComprobante + '%')
        AND (@estado IS NULL OR estado = @estado)
        AND (@codigo_empleado IS NULL OR codigo_empleado LIKE '%' + @codigo_empleado + '%')
END
GO


--------------------------------------------------------------------------------------------------------

		--INVENTARIO--

IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_insert_inventario]')
BEGIN
    DROP PROCEDURE [dbo].[sp_insert_inventario]
END
GO

CREATE PROCEDURE [dbo].[sp_insert_inventario]
(
  @codProducto INT,
  @codPersona INT,
  @stock INT,
  @precioCompra MONEY,
  @estado BIT = 1
)
AS
BEGIN
    BEGIN TRY
        BEGIN TRAN

        IF EXISTS (SELECT 1 FROM producto WHERE codProducto = @codProducto) AND
           EXISTS (SELECT 1 FROM persona WHERE codPersona = @codPersona)
        BEGIN

            INSERT INTO inventario (codProducto, codPersona, stock, fecha_hora_entrada, precioCompra)
            VALUES (@codProducto, @codPersona, @stock, GETDATE(), @precioCompra)

            COMMIT TRAN

            SELECT 1 AS Estado, 'Se insertó correctamente en el inventario' AS Mensaje
        END
        ELSE
        BEGIN
            ROLLBACK TRAN

            SELECT 0 AS Estado, 'El código de producto o de persona no existe en las tablas correspondientes' AS Mensaje
        END
    END TRY
    BEGIN CATCH
        ROLLBACK TRAN

        SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
    END CATCH
END
GO

EXEC [dbo].[sp_insert_inventario] 1, 1, 50, 400
---------------------------------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_update_inventario]')
BEGIN
    DROP PROCEDURE [dbo].[sp_update_inventario]
END	
GO

CREATE	PROCEDURE [dbo].[sp_update_inventario]
(
  @codInventario INT,
  @codProducto INT,
  @codPersona INT,
  @stock INT,
  @precioCompra MONEY,
  @estado BIT
)
AS
BEGIN
    BEGIN TRY
        BEGIN TRAN

        IF EXISTS (SELECT 1 FROM inventario WHERE codIventario = @codInventario)
        BEGIN
            IF EXISTS (SELECT 1 FROM producto WHERE codProducto = @codProducto) AND
               EXISTS (SELECT 1 FROM persona WHERE codPersona = @codPersona)
            BEGIN
                UPDATE inventario
                SET 
                    stock = @stock,
                    precioCompra = @precioCompra,
                    estado = @estado
                WHERE codIventario = @codInventario

                COMMIT TRAN

                SELECT 1 AS Estado, 'Se actualizó correctamente el inventario' AS Mensaje
            END
            ELSE
            BEGIN
                ROLLBACK TRAN
                SELECT 0 AS Estado, 'El código de producto o de persona no existe en las tablas correspondientes' AS Mensaje
            END
        END
        ELSE
        BEGIN
            ROLLBACK TRAN
            SELECT 0 AS Estado, 'El código de inventario no existe en la tabla' AS Mensaje
        END
    END TRY
    BEGIN CATCH
        ROLLBACK TRAN
        SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
    END CATCH
END


-----------------------------------------------------------------------------------

IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_delete_inventario]')
BEGIN
    DROP PROCEDURE [dbo].[sp_delete_inventario]
END
GO
------------------------------------------------------------------------------------------
CREATE PROCEDURE [dbo].[sp_delete_inventario]
(
  @codInventario INT
)
AS
BEGIN
    BEGIN TRY
        BEGIN TRAN

        IF EXISTS (SELECT 1 FROM inventario WHERE codIventario = @codInventario)
        BEGIN
            UPDATE inventario
            SET estado = 0
            WHERE codIventario = @codInventario

            COMMIT TRAN

            SELECT 1 AS Estado, 'Se eliminó lógicamente el registro del inventario' AS Mensaje
        END
        ELSE
        BEGIN
            ROLLBACK TRAN
            SELECT 0 AS Estado, 'El código de inventario no existe en la tabla' AS Mensaje
        END
    END TRY
    BEGIN CATCH
        ROLLBACK TRAN
        SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
    END CATCH
END


-----------------------------------------------------------------
IF EXISTS (SELECT * FROM sys.procedures WHERE name = '[dbo].[sp_buscar_inventario]')
BEGIN
    DROP PROCEDURE [dbo].[sp_buscar_inventario]
END
GO
---------------------------------------------------------------------------------------------
CREATE PROCEDURE [dbo].[sp_buscar_inventario]
(
    @codInventario INT = NULL,
    @codProducto INT = NULL,
    @codPersona INT = NULL,
    @estado BIT = NULL
)
AS
BEGIN
    BEGIN TRY
        SELECT *
        FROM inventario
        WHERE 
            (@codInventario IS NULL OR codIventario = @codInventario)
            AND (@codProducto IS NULL OR codProducto = @codProducto)
            AND (@codPersona IS NULL OR codPersona = @codPersona)
            AND (@estado IS NULL OR estado = @estado)
    END TRY
    BEGIN CATCH
        SELECT 0 AS Estado, ERROR_MESSAGE() AS Mensaje
    END CATCH
END
GO