<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Implicit Objects Example</title>
</head>
<body>
    <h1>Implicit Objects Example</h1>
    
    <%-- Using implicit objects --%>
    
    <h2>Request Information:</h2>
    <p>Parameter value: <%= request.getParameter("paramName") %></p>
    <p>HTTP Method: <%= request.getMethod() %></p>
    
    <h2>Session Information:</h2>
    <p>Session ID: <%= session.getId() %></p>
    <%-- Storing session attribute --%>
    <% session.setAttribute("username", "John Doe"); %>
    
    <%-- Using JSP Expression Language (EL) --%>
    
    <h2>EL Example:</h2>
    <p>Parameter value: ${param.paramName}</p>
    <p>Session Attribute: ${sessionScope.username}</p>
</body>
</html>
