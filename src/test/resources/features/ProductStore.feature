#language: es
@productStore
Característica: Product - Store
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los productos disponibles en la tienda

  @test
  Escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario: "lucero.abigail.13.04.04@gmail.com" y clave: "Password2024!!!"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito