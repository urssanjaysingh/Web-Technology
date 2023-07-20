<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <%= request.getSession().getAttribute("username") %>!</h1>
    <a href="logout">Logout</a>
</body>
</html>
