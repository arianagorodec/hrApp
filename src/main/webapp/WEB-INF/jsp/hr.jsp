<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>HR</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
   
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="${contextPath}/resources/css6/font-awesome.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css6/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css6/templatemo-style.css" rel="stylesheet">
    
    

  </head>
  <body>  
    <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>HR</h1>
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
            <li><a href="#" class="active"><i class="fa fa-home fa-fw"></i>Главная</a></li>
            <li><a href="/hr/diagram"><i class="fa fa-bar-chart fa-fw"></i>Диаграммы</a></li>
            <li><a href="/hr/statistics"><i class="fa fa-area-chart"></i>Статистика</a></li>
            <li><a href="/hr/profile" ><i class="fa  fa-list-alt"></i>Досье</a></li>
            <li><a href="/hr/event" ><i class="fa  fa-calendar fa-fw"></i>Календарь</a></li>
            <li><a href="/hr/interviewer" ><i class="fa fa-pencil-square-o "></i>Собеседования</a></li>
            <li><a href="/hr/message" ><i class="fa fa-comments fa-fw"></i>Сообщения</a></li>
            <li><a href="/hr/staffingTable"><i class="fa fa-th-list"></i>Штатное расписание </a></li>
            <li><a  href="/hr/report"><i class="fa fa-database fa-fw"></i>Отчёт по ЗП</a></li>
            <li><a href="/hr/certificate" ><i class="fa fa-file-text-o fa-fw"></i>Заказ справок</a></li>
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
                <li><a href="" class="active">HR</a></li>
                              </ul>  
            </nav> 
          </div>
        </div>
        <div class="templatemo-content-container">
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
              <div class="square"></div>
              <h2 class="templatemo-inline-block">Инструкция для пользователя</h2><hr>
              <p>Добро пожаловать в ваш аккаует сотрудника. Данный аккаунт предоставляет вам возможность контролировать важные экономические показатели в режиме реального времени, а так же просматривать статистику за определённый период.</p><p>
              В аккаунте содержится ваша личная информация. Так же здесь размещается календарь событий, который включает в себя рассписание встреч, больничных и отпусков. При помощи вашей страничке вы можете просматривать свои расчётные листы и заказывать нужные вам документы онлайн.</p>
              <p>Если вы ознакомились со справочной информацией и она вам больше не нужна, нажните на крестик в правом верхнем углу</p>             
            </div>
            
            
          </div>
          <div class="templatemo-flex-row flex-content-row">
            
            <div class="col-1">
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                <i class="fa fa-times"></i>
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">Ваш профиль</h2></div>
                 
          
               
              <section class="home_banner_area">
            <div class="container box_1620">

              <div class="banner_content">
            <div class="media" style=" width:1400px;">
              <c:if test="${not empty photo}">
                <div class="d-flex">
                  <img src="/photoUser/${photo}" width="668" height="690" alt="profile">
                </div>
              </c:if>
              <div class="media-body">
                <div class="personal_text">
                  <h6>Hello Everybody, i am</h6>
                  <h3>${name}</h3>
                  <h4>Сотрудник</h4>
                  <p>HR банковского учереждения. В обязаности HR входит контроль и найм сотруднтков, а так же отчётность по некоторым вопросам, предоставляемые другим отделам</p>
                  <ul class="list basic_info">
                    <li><a href="#"><i class="fa fa-calendar-o"></i> ${birthday}</a></li>
                    <li><a href="#"><i class="fa fa-phone"></i> ${mobphone}</a></li>
                    <li><a href="#"><i class="fa  fa-envelope"></i> ${email}</a></li>
                    <li><a href="#"><i class="fa  fa-transgender"></i> ${gender}</a></li>
                    <li><a href="#"><i class="fa   fa-suitcase"></i>${department}</a></li>
                    <li><a href="#"><i class="fa   fa-list-alt"></i>${post}</a></li>
                  </ul>

                  <ul class="list personal_social">
                    <li><a href="#open"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#open"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#open"><i class="fa fa-linkedin"></i></a></li>
                  </ul>

                  <div id="open" class="modal">
                    <div>
                      <a href="#close" title="Закрыть" class="close">X</a>

                      <form>
                        <div class="modal-body">
                          <input type="networc" id="id" name="id" class="hidden"/>
                          <div class="form-group required">
                            <label  class="col-sm-3 control-label" style="color:#606061 ">Ссылка на социальную сеть</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Введите ссылку" required=""/>
                            </div>
                          </div>
                        </div>

                        <div class="modal-footer">
                          <button type="submit" class="login100-form-btn">Сохранить изменения</button>
                          <button class="login100-form-btn">

                            <a href="#close" title="Закрыть" >Отмена</a>
                          </button>
                        </div>
                      </form>
                    </div>
                  </div>

                  <form method="post" enctype="multipart/form-data">
                    <ul class="list_download">
                      <input type="file" name="file" id="file" />
                      <label for="file">Новый аватар</label>
                      <button class="login100-form-btn" href="#" >Заменить</button>
                    </ul>
                  </form>
                </div>
              </div>
            </div>

                </div>
          </div>

        </section>
            
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
    <script src="${contextPath}/resources/js5/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="${contextPath}/resources/js5/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
  </body>
</html>