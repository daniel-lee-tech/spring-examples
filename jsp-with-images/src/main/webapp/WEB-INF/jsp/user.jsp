<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User ${user.id}</title>
</head>
<body>
<h1>User ${user.id} page</h1>
<h2><a href="/">Home Page</a></h2>
<h2><a href="/users">Show all Users</a></h2>
<h2><a href="/users/add">Add New User</a></h2>


<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.phoneNumber}</td>
        <td>
            <img src="${user.imageUrl}" />
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>