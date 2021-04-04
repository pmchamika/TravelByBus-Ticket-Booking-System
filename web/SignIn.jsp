<%--
  Created by IntelliJ IDEA.
  User: kaushirajapakshe
  Date: 2019-09-27
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel By Bus</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/ManageMyStyles.css">


    <%-- <script src="js/jquery.dataTables.js" type="text/javascript"></script>--%>
    <%-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>--%>
    <%--<script src="js/google-map.js"></script>--%>
    <%--<script src="js/main.js"></script>--%>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="Home.jsp">Travel<span>ByBus</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="Home.jsp" class="nav-link">Home</a></li>

                <%if (session.getAttribute("type")!=null){%>

                <%if(session.getAttribute("type").toString().equalsIgnoreCase("Admin")){%>
                <li class="nav-item"><a href="ManageBus.jsp" class="nav-link">Manage Buses</a></li>
                <li class="nav-item"><a href="ManageRoute.jsp" class="nav-link">Manage Routes</a></li>
                <li class="nav-item"><a href="ManageSchedule.jsp" class="nav-link">Schedules</a></li>
                <li class="nav-item"><a href="tempuser.jsp" class="nav-link">Tickets</a></li>
                <li class="nav-item"><a href="ManagerCardApproval.jsp" class="nav-link">Card Approval</a></li>
                <li class="nav-item"><a href="ViewCharts.jsp" class="nav-link">Analysis</a></li>

                <%}else if(session.getAttribute("type").toString().equalsIgnoreCase("Customer")){%>

                <li class="nav-item"><a href="ViewSchedule.jsp" class="nav-link">Bus Schedule</a></li>
                <li class="nav-item"><a href="PaymentMethod.jsp" class="nav-link">Payment Method</a></li>
                <%}%>
                <%}else{%>

                <li class="nav-item"><a href="SignIn.jsp" class="nav-link">Sign In</a></li>
                <li class="nav-item"><a href="Register.jsp" class="nav-link">Register</a></li>

                <%}%>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_2.jpg'); overflow: auto"
         data-stellar-background-ratio="0.5">
    <div class="overlay"></div>

    <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start" style="margin-top: 7vh">
        <div class="col-md-9 ftco-animate pb-5">
            <div class="container">
                <div class="col-md-6 form-group">
                    <label for="" class="label">User Name</label>
                    <input type="text" id="username" class="form-control" placeholder="kaushi.rajapakshe1@gmail.com">
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">Password</label>
                    <input type="password" id="signPassword" class="form-control"
                           placeholder="Please enter strong password">
                </div>
                <div class="col-md-6 form-group">
                    <input type="button" value="Sign In" id="signIn" class="btn btn-primary py-3 px-4">
                </div>
                <div class="col-md-6 form-group">
                    <input type="button" value="Need an Account?" id="signRegister" class="btn-lg btn-success"
                           style="cursor: pointer;">
                </div>
                <br/><br/>
                <div class="col-md-6 form-group">
                    <input type="button" value="Continue with Facebook" id="signFacebook" class="btn-lg btn-primary"
                           style="cursor: pointer;">
                </div>
                <div class="col-md-6 form-group">
                    <input type="button" value="Continue with Twitter" id="signTwitter" class="btn-lg btn-primary"
                           style="cursor: pointer;">
                </div>
                <p class="breadcrumbs"><span class="mr-2"><a href="Home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span>
                    <span>Sign In with Email <i class="ion-ios-arrow-forward"></i></span></p>
                <h1 class="mb-3 bread">Sign In with Email</h1>
            </div>
        </div>
    </div>
</section>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>

<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.buttons.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.timepicker.min.js"></script>
<script src="js/scrollax.min.js"></script>
<script src="js/select2.full.min.js"></script>
<script src="js/buttons.print.min.js"></script>
<script src="js/Chart.js"></script>
<%--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>--%>
<%--<script src="js/google-map.js"></script>--%>
<script src="js/main.js"></script>

<%--  <!--Export table button CSS-->

  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">--%>


</body>
</html>

<script>
    $("#signIn").click(function () {


        var username = $('#username').val();
        var signPassword = $('#signPassword').val();

        if (username == "") {
            alert("Please enter the Email to continue")
        } else if (signPassword == "") {
            alert("Please enter the Password to continue")
        } else {

            $.ajax({

                type: 'POST',
                url: '/SignInServlet',
                data: {
                    'username': username,
                    'signPassword': signPassword,
                },

                success: function () {
                    window.location.href = "Home.jsp"
                }

            })
        }
    })

    $("#signRegister").click(function () {


        $.ajax({

            success: function () {
                window.location.href = "Register.jsp"

            }

        })
    })
    $("#signFacebook").click(function () {


        $.ajax({

            success: function () {
                window.location.href = "https://www.facebook.com/login.php?"

            }

        })
    })
    $("#signFacebook").click(function () {


        $.ajax({

            success: function () {
                window.location.href = "https://www.facebook.com/login.php?"

            }

        })
    })
    $("#signTwitter").click(function () {


        $.ajax({

            success: function () {
                window.location.href = "https://twitter.com/login?"

            }

        })
    })

</script>