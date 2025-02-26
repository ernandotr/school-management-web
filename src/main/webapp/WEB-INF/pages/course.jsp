<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            <div class="mb-3 mt-3">
                <label for="code"  class="form-label"> Código:</label>
                <input id="code"  type="text" name="code" class="form-control" placeholder="Informe o código"/>
            </div>
            <div class="mb-3">
                <label for="name" class="form-lable"> Nome:</label>
                <input id="name" class="form-control"  type="text" name="name" placeholder="Informe o nome"/>
            </div>
            <div class="mb-3">
                <label for="workload" class="form-lable"> Carga horária:</label>
                <input id="workload" class="form-control" type="text" name="workload" placeholder="Informe a carga horária"/>
            </div>
            <div class="mb-3">
                <label for="level" class="form-lable"> Nível:</label>
                <select id="level" class="form-select"  name="level">
                    <option>Básico</option>
                    <option>Intermediário</option>
                    <option>Avançado</option>
                </select>
            </div>
            <div>
                <button class="btn btn-primary" type="submit">Gravar</button>
            </div>
        </form>
        <hr/>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <td>Código</td>
                <td>Nome</td>
                <td>Carga horária</td>
                <td>Nível</td>
                <td>Ações</td>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>C-001</td>
                <td>Java</td>
                <td>50 horas</td>
                <td>Avançado</td>
                <td>
                    <button class="btn btn-primary">Editar</button>
                    <button class="btn btn-danger">Excluir</button>
                </td>
            </tr><tr>
                <td>C-002</td>
                <td>HTML</td>
                <td>30 horas</td>
                <td>Intermediário</td>
                <td>
                    <button class="btn btn-primary">Editar</button>
                    <button class="btn btn-danger">Excluir</button>
                </td>
            </tr><tr>
                <td>C-003</td>
                <td>CSS</td>
                <td>20 horas</td>
                <td>Básico</td>
                <td>
                    <button class="btn btn-primary">Editar</button>
                    <button class="btn btn-danger">Excluir</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>


</body>
</html>