# Java-EE-Web-Components

### ✔️ Web components

* A page containing a form for introducing a record: **src/main/webapp/pages/input.jsp**
* A page describing the response that will be delivered to the client: **src/main/webapp/pages/result.jsp**
* An object-oriented domain model: **src/main/java/ro/uaic/info/webcomponents/models**
* Servlets: **src/main/java/ro/uaic/info/webcomponents/controllers**
* Daos: **src/main/java/ro/uaic/info/webcomponents/daos**

### ✔️ Web filters

* A web filter that will log all requests received by input.jsp: **src/main/java/ro/uaic/info/webcomponents/filters/LogFilter.java**
* A web filter that will decorate the response by adding a specific prelude (at the beginning) and a specific coda (at the end) to the generated HTML page: **src/main/java/ro/uaic/info/webcomponents/filters/ResponseDecorator.java**

### ✔️ Web listener

* **src/main/java/ro/uaic/info/webcomponents/listeners/DefaultCategoryListener.java**

### ✔️ Cookie

* **getSelectedCategoryCookie** method from **src/main/java/ro/uaic/info/webcomponents/controllers/RecordsServlet.java**

### ❌️ CAPTCHA