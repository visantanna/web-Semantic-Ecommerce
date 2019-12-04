<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Semantic E-commerce</title>
    <meta name="description" content="" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <spring:url value="/resources/styles.css" var="stylesCss" />
  

    <link href="${stylesCss}" rel="stylesheet">
    <link href="${gradientsCss}" rel="stylesheet">
  </head>
  <body class="">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="#">
          <img src="GaleriaPaje.png" height = "100" width = "180" alt="">
        </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
        </li>
        <li class="nav-item">
			<p>
			<a class="button" href="#" title="LogIn">
					Log-in
			</a>
			</p>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Page Content -->
<div class="blank-space">
  
</div>
<main role="main">
  <article class="card-60 social">
    <figure>
      <a class="ribbon-buy popular" href="#" title="Popular">
			Hot
		</a>
      <img src="http://www.theplayoffs.com.br/wp-content/uploads/2018/03/nba-store-brasil-e1519915445743.jpg" width="800px" height="600px" alt="NBA STORE">
    </figure>
    <!-- end figure-->
    <div class="flex-content">
       <h2>
Nome da Loja
		</h2>
 
      <ul>
        <li>
          <strong title="Type">Tipo:</strong>
            Tipo de Produto
        </li>
		<li>
			
				<strong title="Local">Localização:</strong>
				<a class="location" title="Location" href="">
						Andar: 1 , Loja: 10
				</a>
			
		</li>
		<li></li>
								<!--<li><strong title="availability">Color:</strong> Red/Orange/Black/Blue</li>
								<li><strong title="Shipping">Shipping:</strong> Free</li>-->
							</ul>
       <p>
			Uma pequena descrição da loja sem muita pretensão de ser incrivel

      </p>
      <footer>
        <p>
          <a></a>
          <a></a>
          <a class="button" href="#" title="Loja">
					Visite a Loja
			</a>
        </p>
      </footer>
    </div>
    <!-- end .flex-content-->
  </article>
</main>
</body>
</html>
