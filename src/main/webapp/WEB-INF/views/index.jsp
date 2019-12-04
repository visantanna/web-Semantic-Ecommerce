<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Semantic E-commerce</title>
    <meta name="description" content="" />

    <spring:url value="/resources/styles.css" var="stylesCss" />
  

    <link href="${stylesCss}" rel="stylesheet">
    <link href="${gradientsCss}" rel="stylesheet">
  </head>
  <body class="">
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
          <strong title="Type">Tipo de Produto:</strong>
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
