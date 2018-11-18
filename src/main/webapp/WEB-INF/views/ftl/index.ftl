<!DOCTYPE html>
<html>
  <head>
<meta charset="UTF-8"/>
    <title>PropertiesToHTML</title>
	  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  </head>
  <body>
	<div class="container border-container">
		<div >
            <h1 class="text-center">Резюме</h1>
		</div>
		<div>
            <h2  class="text-center">на должность Java-стажер</h2>
        </div>
		<div class="row">
		  <div class="col-md-6 col-sm-6">
                <h3>Информация о себе:</h3>

                <br>ФИО:<#if user.lastName??>${user.lastName}</#if> <#if user.firstName??>${user.firstName}</#if> <#if user.secondName??>${user.secondName}</#if>
				<br>Дата рождения:<#if user.birthDate??>${user.birthDate}</#if>
				<br>Тел:<#if user.phone??>
				<ul>
					<#list user.phone as phoneItem>
					<li>${phoneItem}
					</#list>
				</ul>
  				</#if>
				 e-mail : <#if user.email??>
  					<ul>
	  					<#list user.email as emailItem>
	  					<li>${emailItem}
	  					</#list>
  					</ul>
					</#if>
		  </div>
		  <div class="col-md-6 col-sm-6">
			<img src="<#if user.imgSrc??>${user.imgSrc}</#if>" class="img-rounded" alt="<#if user.imgSrc??>${user.imgSrc}</#if>">
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
			<h3>Цель:</h3>
			  <#if user.goals??>
			  <ul>
				  <#list user.goals as goal>
				  <li>${goal}
				  </#list>
			  </ul>
		      </#if>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
			<h3>Опыт работы</h3>
			  <#if user.workExperience??>
			  <ul>
				  <#list user.workExperience as key, value>
				  <li>${key} - ${value} мес.
			  	  </#list>
			  </ul>
		  </#if>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
			  <h3>Образование</h3>
			  <#if user.education??>
			  <ul>
				  <#list user.education as educationItem>
				  <li>${educationItem}
				  </#list>
			  </ul>
		      </#if>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
				<h3>Доп. образование и курсы:</h3>
			  <#if user.additionalEducation??>
			  <ul>
				  <#list user.additionalEducation as additionalEducationItem>
				  <li>${additionalEducationItem}
				  </#list>
			  </ul>
		      </#if>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
			<h3>Навыки:</h3>
			  <#if user.skills??>
			  <ul>
				  <#list user.skills as skill>
				  <li>${skill}
				  </#list>
			  </ul>
		  </#if>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-12 col-sm-12">
			<h3>Пример кода:</h3>
			  <#if user.codeSample??>
			  <ul>
				  <#list user.codeSample as codeSampleItem>
				  <li><a href="${codeSampleItem}" >${codeSampleItem}</a>
				  </#list>
			  </ul>
		  </#if>
		  </div>
		</div>
	</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

     <!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
    <!--<script src="//code.jquery.com/jquery.js"></script>-->
     <!--Include all compiled plugins (below), or include individual files as needed-->
    <!--<script src="js/bootstrap.min.js"></script>-->

  </body>
</html>
