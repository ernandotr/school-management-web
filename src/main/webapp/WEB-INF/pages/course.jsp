<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Course register</title>
</head>
<body>
    <div class="p-5 position-absolute bottom-0 end-0 w-100 h-100 bg-dark text-white">

        <br>
        <h1>

        </h1>
        <hr/>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Carga horária</th>
                <th>Nível</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.code()}</td>
                    <td>${course.name()}</td>
                    <td>${course.workload()} horas</td>
                    <td>${course.level()}</td>
                    <td>
                        <a href="edit-course" method="put"  class="btn btn-primary">Editar</a>
                        <a href="remove-course?code=${course.code()}" method="delete" class="btn btn-danger">Excluir</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>


</body>
</html>