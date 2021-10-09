<%@ page import="java.util.List" %>
<%@ page import="ro.uaic.info.webcomponents.models.Record" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Records</title>
    <style>
        table {
            margin-bottom: 20px;
        }

        table, th, td {
            border:1px solid black;
        }
    </style>
</head>
<body>
<h3>Records</h3>
<table>
    <tr>
        <th>Key</th>
        <th>Value</th>
        <th>Category</th>
    </tr>
    <%
        List<Record> records = (List<Record>) request.getAttribute("records");
        for (Record record : records) {
            out.println(String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
                    record.getKey(), record.getValue(), record.getCategory()));
        }
    %>
</table>
<a href="${pageContext.request.contextPath}/">Create a new record</a>
</body>
</html>