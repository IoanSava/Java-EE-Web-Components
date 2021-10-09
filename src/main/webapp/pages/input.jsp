<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create a record</title>
    <style>
        div {
            background-color: #f2f2f2;
            padding: 20px;
        }

        select, input {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h3>Create a record</h3>
<div>
    <form method="POST" action="records">
        <label for="key">Key</label><br>
        <input type="text" id="key" name="key" required/><br>

        <label for="value">Value</label><br>
        <input type="text" id="value" name="value" required/><br>

        <label for="categories">Select category</label><br>
        <select name="category" id="categories">
            <%
                String selectedCategory = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("RecordsServlet.selectedCategoryCookie")) {
                            selectedCategory = cookie.getValue();
                        }
                    }
                }

                out.println("<option value=\"\"></option>");

                List<String> categories = (List<String>) request.getAttribute("categories");
                for (String category : categories) {
                    out.println(String.format("<option value=\"%s\" %s>%s</option>",
                            category, category.equals(selectedCategory) ? "selected" : "", category));
                }
            %>
        </select><br>

        <input type="submit" value="Create a record"/>
    </form>
</div>
<a href="${pageContext.request.contextPath}/records">List all records</a>
</body>
</html>