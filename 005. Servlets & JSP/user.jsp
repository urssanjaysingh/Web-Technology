<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <jsp:useBean id="user" class="com.example.UserBean" scope="request" />

    <%-- Setting the properties of UserBean --%>
    <jsp:setProperty name="user" property="username" value="John Doe" />
    <jsp:setProperty name="user" property="age" value="30" />

    <h1>User Details</h1>
    <p>Username: ${user.username}</p>
    <p>Age: ${user.age}</p>
</body>
</html>
