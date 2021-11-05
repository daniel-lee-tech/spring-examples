<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add New User</title>
</head>
<body>
<h1>New User page</h1>
<h2><a href="/">Home Page</a></h2>
<h2><a href="/users">Show all Users</a></h2>

    <form method="post" action="/users/add" enctype="multipart/form-data">
        <input name="name" placeholder="name"/>
        <input name="phoneNumber" type="number" placeholder="phone number" />
        <input name="email" placeholder="email" />
        <input type="file" name="image" accept="image/png, image/jpeg" />
        <button type="submit">Submit</button>
    </form>
</body>
</html>