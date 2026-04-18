# Serenity BDD - Pruebas Automatizadas

## 📋 Descripción

Este proyecto contiene pruebas automatizadas utilizando Serenity BDD con Java, JUnit 5 y Selenium WebDriver sobre el sitio de pruebas OpenCart.

---

## ⚙️ Requisitos

* Java 11 o superior
* Maven instalado
* Google Chrome instalado

---

## 📦 Instalación

1. Clonar el repositorio:

```bash
git clone 
cd 
```

---

## 🚀 Ejecución de pruebas

### Ejecutar todos los tests

```bash
mvn clean verify
```

---

### Ejecutar un caso específico por tag

```bash
mvn test -Dgroups=nombreDelCaso
```

Ejemplo:

```bash
mvn test -Dgroups=checkout
```

---

## 📊 Reportes

Luego de la ejecución, el reporte se genera en:

```
target/site/serenity/index.html
```

Abrir el archivo en el navegador para visualizar resultados detallados.

---

## 🧪 Estructura del proyecto

```
src/test/java/com/tuempresa/
├── pages/     → Page Objects
└── tests/     → Casos de prueba

src/test/resources/
└── serenity.properties → Configuración del framework
```

---

## ⚠️ Notas

* Las pruebas se ejecutan en modo headless por defecto.
* Se utilizan esperas dinámicas para manejar la naturaleza asíncrona de la aplicación.
* Los selectores fueron adaptados según la estructura del sitio bajo prueba.

---

## 🧑‍💻 Autor

Jhoan Velasquez