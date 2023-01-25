## Arrancar la aplicación:
````mvn spring-boot:run````

## Ejecutar los tests:
```mvn test```

Para realizar llamadas al endpoint de la prueba, es importante que la fecha del req param esté correctamente formateada, por ejemplo una llamada sería:
``http://localhost:8080/prueba/prices/get-filtered?applicationDate=2020-06-14 16:00:00&productId=35455&brandId=1``