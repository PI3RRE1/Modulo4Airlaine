<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>	
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cliente</title>
<!--     <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css"> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<!--     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> -->

<link rel="stylesheet" href="src/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;700&display=swap"
	rel="stylesheet">
<link rel="shortcut icon" href="src/imagem/localizacao.png"
	type="image/x-icon">


</head>
<body>

	<header>
		<nav class="navbar bg-body-tertiary">
			<div class="container">
				<a class="navbar-brand" href="index.html" alt="home"> <img
					src="src/imagem/Logo.png" alt="Airline Viagens home" width="150"
					height="40">
				</a>
				<!-- <a class="navbar-brand" href="#">Navbar</a> -->
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link active" aria-current="page" href="Destino.html">Destino</a>
						<a class="nav-link" href="Promocoes.html">Promoções</a> <a
							class="nav-link" href="Contato.html">Contato</a>
							<a class="nav-link" href="Cliente.jsp">Cadastro</a>
                             <a class="nav-link" href="Clintelist.jsp">Consultar</a>
					</div>
				</div>
		</nav>
	</header>

	<table class="table container p-5">
		<thead>
			<tr>
				<th scope="col">Clientes</th>
				<th scope="col">Nome</th>
				<th scope="col">Telefone</th>
				<th scope="col">Cpf</th>
				<th scope="col">Email</th>
				<th scope="col">Ações</th>
			</tr>
		</thead>
		<tbody>
		<jstl:forEach items="${clientes}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.nome}</td>
                        <td>${c.telefone}</td>
                        <td>${c.cpf}</td>
                        <td>${c.email}</td>
                        

                        <td>
                            <a href="cliente?id=${c.id}" class="btn btn-primary mb-1" >Editar</a>

                            <a href="cliente-delete?id=${c.id}" onclick="return confirm('Deseja excluir ${c.nome}?')" class="btn btn-danger mb-1">Excluir</a>
                        </td>

                    </tr>
                </jstl:forEach>
			
			
		</tbody>
	</table>

	<footer class="text-center text-white pt-3"
		style="background-color: white">
		<div class="text-center text-dark p-3"
			style="background-color: lightgray;">
			© 2023 Copyright: <a class="text-dark" href="index.html">Airline.com</a>
			<img src="src/imagem/Logo.png" class="img-fluid" alt="Logo"
				width="150" height="40">
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>