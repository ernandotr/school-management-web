<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dev.ernandorezende.service.CourseService, dev.ernandorezende.model.Course, java.util.List" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Course register</title>
</head>
<body>
    <div class="p-5 position-absolute bottom-0 end-0 w-100 h-100 bg-dark text-white">
        <h1>Cadastro de Cursos</h1>
        <hr/>
        <form method="post" action="courses">
            <div class="row">
                 <div class="mb-3 col-4">
                    <label for="code"  class="form-label"> Código:</label>
                    <input id="code"  type="text" name="code" class="form-control" placeholder="Informe o código"/>
                </div>
                <div class="mb-3 col-8">
                    <label for="name" class="form-label"> Nome:</label>
                    <input id="name" class="form-control"  type="text" name="name" placeholder="Informe o nome"/>
                </div>
            </div>

            <div class="row">
                <div class="mb-3 col-4">
                    <label for="workload" class="form-lable"> Carga horária:</label>
                    <input id="workload" class="form-control" type="text" name="workload" placeholder="Informe a carga horária"/>
                </div>
                <div class="mb-3 col-8">
                    <label for="level" class="form-lable"> Nível:</label>
                    <select id="level" class="form-select"  name="level">
                        <option>Básico</option>
                        <option>Intermediário</option>
                        <option>Avançado</option>
                    </select>
                </div>
            </div>

            <div>
                <button class="btn btn-primary" type="submit">Gravar</button>
            </div>
        </form>
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

            <% for(Course course : CourseService.courseList()) { %>

            <tr>
                <td><%= course.code()%></td>
                <td><%= course.name()%></td>
                <td><%= course.workload()%> horas</td>
                <td><%= course.level()%></td>
                <td>
                    <button class="btn btn-primary">Editar</button>
                    <button class="btn btn-danger">Excluir</button>
                </td>
            </tr>
            <%  } %>

            </tbody>
        </table>
    </div>


</body>
</html>