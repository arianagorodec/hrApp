<%@ page import="java.sql.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Create your Account</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css2/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts2/material-design-iconic-font/css/material-design-iconic-font.min.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="${contextPath}/resources/css2/style.css"/>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
	<div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
<%--		        <form class="form-register" action="#" method="post">--%>
	<form:form method="POST" modelAttribute="userForm" class="form-register" action="#">
		        	<div id="form-total">
		        		<!-- SECTION 1 -->
			            <h2>
			            	<p class="step-icon"><span>01</span></p>
			            	<span class="step-text">Личная информация</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Личная информация о пользователе</h3>
									<p>Пожалуйста, введите вашу личную информацию в соответствующие поля и, по завершению, перейдите к следующему шагу,нажав кнопку далее или на цифру 2 слева.  </p>
								</div>
								<div class="form-row">
									<div class="form-holder">
										<fieldset>
											<legend>Имя</legend>
											<form:input type="text" path="name" class="form-control" id="first-name" name="first-name" placeholder="Имя" autofocus="true" ></form:input>
<%--											<input type="text" class="form-control" id="first-name" name="first-name" placeholder="Имя" required>--%>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>Фамилия</legend>
											<form:input type="text" path="surname" class="form-control" id="last-name" name="last-name" placeholder="Фамилия" autofocus="true"></form:input>
<%--											<input type="text" class="form-control" id="last-name" name="last-name" placeholder="Фамилия" required>--%>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Ваш Email</legend>
											<div>
												<form:input type="text" name="your_email" id="your_email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" path="username" placeholder="example@email.com"
															autofocus="true"></form:input>
												<form:errors path="username"></form:errors>
													${usernameError}
											</div>
<%--											<input type="text" name="your_email" id="your_email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>--%>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Номер телефона</legend>
											<form:input type="text" path="mobphone" class="form-control" id="phone" name="phone" placeholder="+375 (29)-999-7777" autofocus="true"></form:input>
<%--											<input type="text" class="form-control" id="phone" name="phone" placeholder="+375 (29)-999-7777" required>--%>
										</fieldset>
									</div>
								</div>

								<div class="form-row">
									<div class="form-h">
						      	<fieldset>
								<legend>Пол</legend>
<%--									<input id="gender-male" type="radio" name="gender" value="male"/>--%>
									<form:radiobutton path="gender" id="gender-male" name="gender" value="male"/>
								    <label for="gender-male">Мужсой</label>

									<form:radiobutton path="gender" id="gender-female" name="gender" value="female"/>
<%--								    <input id="gender-female" type="radio" name="gender" value="female"required/>--%>
								    <label for="gender-female">Женский</label>
								</fieldset>
							</div>
							</div>
							
								<div class="form-row form-row-date">
									<div class="form-holder form-holder-2">
										<label class="special-label">Дата рождения:</label>
<%--										<form:input type="date" path="birthday" class="form-control" id="birthday" name="birthday" ></form:input>--%>
										<fmt:format var="day" value="${day}" pattern="DD"/>
										<select name="day" id="day">
											<option value="DD" disabled selected>ДД</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
										</select>
										<fmt:format var="month" value="${month}" pattern="MM"/>
										<select name="month" id="month">
											<option value="MM" disabled selected>ММ</option>
											<option value="02">Feb</option>
											<option value="03">Mar</option>
											<option value="04">Apr</option>
											<option value="05">May</option>
											<option value="06">Jun</option>
											<option value="07">Jul</option>
											<option value="08">Aug</option>
											<option value="09">Sep</option>
											<option value="10">Oct</option>
											<option value="11">Nov</option>
											<option value="12">Dec</option>
											<option value="01">Jan</option>
										</select>
										<fmt:format var="year" value="${year}" pattern="YYYY"/>
										<select name="year" id="year">
											<option value="YYYY" disabled selected>ГГГГ</option>
											<option value="2007">2017</option>
											<option value="2008">2016</option>
											<option value="2009">2015</option>
											<option value="2010">2014</option>
											<option value="2011">2013</option>
											<option value="2012">2017</option>
											<option value="2013">2016</option>
											<option value="2014">2015</option>
											<option value="2015">2014</option>
											<option value="2016">2013</option>
											<option value="2017">2017</option>
											<option value="2018">2016</option>
											<option value="2019">2015</option>
											<option value="2020">2014</option>
										</select>
									</div>
								</div>

							</div>
			            </section>
			            <!-- <div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="text" class="form-control input-border" id="id" name="id" placeholder="ID" required>
									</div>
								</div> -->
						<!-- SECTION 2 -->
			            <h2>
			            	<p class="step-icon"><span>02</span></p>
			            	<span class="step-text">Валидация</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Ваше ID сотрудника </h3>
									<p>Пожалуйста, введите ваше ID и пароль, затем перейдите к следующему шагу, чтобы мы могли создать вашу учетную запись.</p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-1">
										<form:input type="text" path="idP" name="find_bank" id="find_bank" placeholder="Ваше ID сотрудника" class="form-control" autofocus="true"></form:input>
<%--										<input type="text" name="find_bank" id="find_bank" placeholder="Ваше ID сотрудника" class="form-control" required>--%>
									</div>						
								</div>

								<div class="form-row">
									<div class="form-holder form-holder-1">
										<div class="wrap-input100 validate-input" data-validate = "Password is required">
											<div class="password">
												<form:input type="password" id="password-input" path="password"  placeholder="Введите пароль" name="password"></form:input>
<%--												<input type="password" id="password-input" placeholder="Введите пароль" name="password">--%>
												<a href="#" class="password-control" onclick="return show_hide_password(this);"></a>
											</div>
											<span class="focus-input100"></span>
											<span class="symbol-input100">
												<i class="fa fa-lock" aria-hidden="true"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-1">
										<div class="wrap-input100 validate-input" data-validate = "Password is required">
											<div class="password2">
												<form:input type="password" path="passwordConfirm"
															id="password-input2" placeholder="Введите пароль повторно" name="password2"></form:input>
												<a href="#" class="password-control2" onclick="return show_hide_password2(this);"></a>
												<form:errors path="password"></form:errors>
													${passwordError}
<%--												<input type="password" id="password-input2" placeholder="Введите пароль повторно" name="password2">--%>
<%--												<a href="#" class="password-control2" onclick="return show_hide_password2(this);"></a>--%>
											</div>
											<span class="focus-input100"></span>
											<span class="symbol-input100">
												<i class="fa fa-lock" aria-hidden="true"></i>
											</span>
										</div>
									</div>
								</div>

							</div>
							<div class="wizard-header">

								<p>*В случае, если вы являетесь соискателем, введите в поле Ваше ID сотрудника 16 нулей и перейдите к следующему шагу</p>
							</div>
			            </section>
			            <!-- SECTION 3 -->

			            <h2>
			            	<p class="step-icon"><span>03</span></p>
			            	<span class="step-text">Соглашение</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Пользовательское соглашение</h3>
									<p>Пожалуйста, введите информацию и перейдите к следующему шагу, чтобы мы могли создать вашу учетную запись.</p>
								</div>
								<div class="form-row">
			                		<div class="form-holder form-holder-2">
			                			
			                		</div>
			                	</div>
			                	<div>
			                		<fieldset class="row4">
                <legend>Условия и рассылка
                </legend>
                <p class="agreement">
                    <input type="checkbox" value="">
                    <label>*  Я принимаю <a href="#"> Условия использования</a></label>
                </p>
                <p class="agreement">
                    <input type="checkbox" value="">
                    <label>Я хочу получать персональные предложения от вашего сайта</label>
                </p>
                <p class="agreement">
                    <input type="checkbox" value="">
                    <label>Разрешить партнерам присылать мне персонализированные предложения и сопутствующие услуги</label>
                </p>
            </fieldset>
            <div >
						
						<a class="txt2" href="/">
							Выход
						</a>
				<button type="submit" >Зарегистрироваться</button>
<%--				<button type="submit" ><a href="/">Зарегистрироваться</a></button>--%>
					</div>
			                	</div>
							</div>
			            </section>
			            </div>
		        	</div>
			</form:form>
<%--		        </form>--%>
			</div>
		</div>
	</div>
</div>
</div>
	<script src="${contextPath}/resources/js2/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/resources/js2/jquery.steps.js"></script>
	<script src="${contextPath}/resources/js2/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>