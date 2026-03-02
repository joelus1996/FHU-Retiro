<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

<style>
body {
    display: block;
    margin: 8px;
    background-color:#000;
}

.top {
    height: 89px;
}

.content {
    position: absolute;
    width: 100%;
    display: inline-flex;
    justify-content: center;
    height: 80%;
}
</style>

</head>
<meta charset="utf-8">
<meta name="viewport" content="width=1024">

<body>
<div class="top"></div>
<div class="content">
 	<iframe style="width: 87%;border: thin;" src=" ${url} "></iframe>
</div>
</body>
</html>