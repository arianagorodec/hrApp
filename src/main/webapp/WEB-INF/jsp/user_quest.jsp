<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>User</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
     <link rel="apple-touch-icon" type="image/png" href="https://static.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png" />
<meta name="apple-mobile-web-app-title" content="CodePen">
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico" />
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111" />
<title>CodePen - Chat Widget</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link href="${contextPath}/resources/css31/font-awesome.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css31/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css31/templatemo-style.css" rel="stylesheet">

     </head>
  <body>  
    <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>User</h1>
        </header>
        <div class="profile-photo-container">
          <img src="${contextPath}/resources/images3/profile-photo.jpg" alt="Profile Photo" class="img-responsive">
          <div class="profile-photo-overlay"></div>
        </div>      
        <!-- Search box -->
        <form class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">           
          </div>
        </form>
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
            <li><a href="/"><i class="fa fa-user fa-fw"></i>Профиль</a></li>
            <li><a href="#" class="active"><i class="fa fa-file-text-o fa-fw"></i>Анкета</a></li>
            <li><a href="/user/message"><i class="fa fa-comments fa-fw"></i>Сообщения</a></li>
            <li><a href="/logout"><i class="fa fa-times-circle fa-fw"></i>Выход</a></li>
          </ul>  
        </nav>
      </div>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
          <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li><a href="" class="active">Пользователь</a></li>
                              </ul>  
            </nav> 
          </div>
        </div>

        <div class="templatemo-content-container">
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
              <div class="square"></div>
              <h2 class="templatemo-inline-block">Инструкция для пользвователя</h2><hr>
              <p>В данном раздели вы можете пройти анкетирование и дать нам более полную информацию о вас. Мы обязуемся предоставить конфеденциальность этим данным и не передовать их третьим лицам, за предалами нашего банковского учереждения, без вашего согласия.</p>
              <p>Для того что бы закрыть данную справку нажмите на крестик в верхнем правом углу.</p>              
            </div>                   
            </div>
          </div>

          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                <i class="fa fa-times"></i>
                <div class="panel-heading templatemo-position-relative">
                  <h2 class="text-uppercase">Ваша анкета</h2>
                        <section class="home_banner_area">
            <div class="container box_1620">

<form class="form2">
      <section class="intro first"><p><span lang="RU">Здравствуйте, <span>${name}</span></span></p><p><span lang="RU">потратьте, пожалуйста, несколько минут своего времени на заполнение следующей анкеты.</span></p><p><span lang="RU">Данная информация может помочь вам при трудоустройстве в наше банковское учереждение.</span></p>
</section>

<div>
  <fieldset>
   <legend><p class="step-icon"><span>01</span></p></legend>
   <label>Работали ли вы где-то до этого момента?</label>
   <div>
     <input name="job" type="radio" value="yes"> Да<br>
     <input name="job" type="radio" value="no" > Нет.
     </div>
  </fieldset>
  </div>

<div>
  <fieldset>
   <legend><p class="step-icon"><span>02</span></p></legend>
   <label>Есть ли у Вас какие-либо вредные привычки?</label>
   <div>
     <input name="habit" type="radio" value="yes"> Да<br>
     <input name="habit" type="radio" value="no" > Нет.
     </div>
  </fieldset>
</div>

<div>
<fieldset>
   <legend><p class="step-icon"><span>03</span></p></legend>
    <label>Сможете ли Вы работать удалённо, при необходимости (неуспели доделать на работе, опасная эпидемиологическая ситуация и т.д.) ?</label>
    <div>
     <input name="udalenka" type="radio" value="yes"> Да<br>
     <input name="udalenk" type="radio" value="no" > Нет.
</div>
  </fieldset>
  </div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>04</span></p></legend>
        <label>Как вы оцениваете своё умение работать в команде ?</label>
        <div>
         <input name="assessment" type="radio"> Отлично<br>
         <input name="assessment" type="radio"> Хорошо <br>
         <input name="assessment" type="radio"> Удовлетворительно <br>
         <input name="assessment" type="radio"> Плохо.
        </div>
    </fieldset>
    </div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>05</span></p></legend>
      <div>
        <label>Наскольеко хорошо вы осваиваете новые программные продукты ?</label>
        <div>
        <input name="program" type="radio"> Несколько часов<br>
         <input name="program" type="radio"> Несколько дней<br>
         <input name="program" type="radio"> Несколько недель<br>
         <input name="program" type="radio"> Несколько лет.
        </div>
      </div>
    </fieldset>
</div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>06</span></p></legend>
    <label>Что вы считаете главным в работе?</label>
    <div>
     <input type="checkbox"> Зарплата<br>
     <input type="checkbox"> Самореализация<br>
     <input type="checkbox"> Удовольствие от работы<br>
     <input type="checkbox"> Хорошоие условия труда<br>
     <input type="checkbox"> Коллектив<br>
     <input type="checkbox"> Руководство<br>
   </div>
  </fieldset>
</div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>07</span></p></legend>
    <label>Как бы Вы описали себя самого?</label>
    <div>
     <input type="checkbox"> Общительный<br>
     <input type="checkbox"> Творческий<br>
     <input type="checkbox"> Сдержанный<br>
     <input type="checkbox"> Робкий<br>
     <input type="checkbox"> Кооперирующий<br>
     <input type="checkbox"> Руководящий<br>
     <input type="checkbox"> Действующий<br>
     <input type="checkbox"> Аналитический
   </div>
  </fieldset>
</div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>08</span></p></legend>
    <label>Отметьте то, что Вам интереснее всего</label>
    <div>
     <input type="checkbox"> Спорт<br>
     <input type="checkbox"> Наука<br>
     <input type="checkbox"> Сериалы<br>
     <input type="checkbox"> Кино<br>
     <input type="checkbox"> Книги<br>
     <input type="checkbox"> Музеи<br>
     <input type="checkbox"> Путешествия<br>
     <input type="checkbox"> другое
   </div>
  </fieldset>
</div>
<div>
<fieldset>
   <legend><p class="step-icon"><span>09</span></p></legend>

        <label>Сюда вы можете загрузить ваше резюме</label>
<div>

        <input type="file">

      </div>
</fieldset>
</div>
<div>
<fieldset>
  <legend><p class="step-icon"><span>10</span></p></legend>

        <label>Ваш комментарий</label>
        <div>
        <textarea></textarea>

</fieldset>
</div>


      <div>
                <button type="submit" class="login100-form-btn">Отправить</button>

             <button type="reset" class="login100-form-btn">
             Сбросить
            </button>
      </div>

    </form>

            </div>

        </section>

                </div>

               
                </div>                          
              </div>      
          </div> <!-- Second row ends -->
          
          <footer class="text-right">
            <p>КП &copy; 2020 БГУИР
            | Developers: Кошман.В.Д. Городецкая А.М.</p>
          </footer>         
        </div>
      </div>
    </div>
    
    <!-- JS -->
    <script src="${contextPath}/resources/js3/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="${contextPath}/resources/js3/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="https://www.google.com/jsapi"></script> <!-- Google Chart -->
  
    <script type="text/javascript" src="${contextPath}/js3/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>