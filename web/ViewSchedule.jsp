<%@ page import="IT17056212.dao.BusDao" %>
<%@ page import="IT17056212.daoImpl.BusDaoImpl" %>
<%@ page import="IT17056212.model.Bus" %>
<%@ page import="java.util.List" %>
<%@ page import="IT17056212.dao.RouteDao" %>
<%@ page import="IT17056212.daoImpl.RouteDaoImpl" %>
<%@ page import="IT17056212.model.Route" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel By Bus</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
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
    <link rel="stylesheet" href="css/select2.min.css">


    <%-- <script src="js/jquery.dataTables.js" type="text/javascript"></script>--%>
    <%-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>--%>
    <%--<script src="js/google-map.js"></script>--%>
    <%--<script src="js/main.js"></script>--%>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html">Travel<span>ByBus</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
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
                <li class="nav-item"><a href="RequestCard.jsp" class="nav-link">Request Card</a></li>

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

<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>

    <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
        <div class="col-md-9 ftco-animate pb-5">
            <div class="container">

            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Bus Schedule <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread" id="header1"></h1>
        </div>
    </div>
    </div>
</section>


<table id="tableSchedule" class="table table-bordered table-striped table-hover table-responsive-md ">
    <thead>
    <tr>
        <th>Route</th>
        <th>Schedule</th>
        <th>From</th>


    </tr>
    </thead>
    <tbody>

    </tbody>

</table>






<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

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
<script src="js/moment.min.js"></script>

<%--<script src="js/jquery.dataTables.min"></script>--%>
<!--Import jQuery before export.js-->


<!--Data Table-->
<%--<script type="text/javascript"  src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>--%>


</body>
</html>

<script>
    var table;
    var pointA;
    var pointB;
    $(document).ready(function () {

        table=$('#tableSchedule').dataTable({

            /*  dom: 'Bfrtip',
              paging: true,
              buttons: [
                'print'
              ]*/
            "lengthMenu": [[ -1], ["All"]],


            ordering: false,  // Disabels COLUMN ordering
            scrollY: "600px",
            scrollCollapse: false,

        });
        loadTable();

        $('#header1').text("Today - "+moment().format('ddd MMM DD YYYY hh:mm:ss'));

        /*
          $('.dataTables_filter input').unbind().keyup(function(e) {
              var value = $(this).val();
              if (value.length>1) {
                alert(value);
                table.search(value).draw();
              } else {
                //optional, reset the search if the phrase
                //is less then 3 characters long
                table.search('').draw();
              }
        */


    });

    function loadTable(){

        $.ajax({
            url: '/ViewTodaySchedule',
            type: 'POST',
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function (data, textStatus, jqXHR) {
                console.log(data[0]);
                $("#tableSchedule > tbody").html("");
                console.log(data.length)

                for (var fullData = 0; fullData < data.length; fullData++) {

                    var start;
                    var end;
                    var time=data[fullData].s_time;

                    var arr=time.split(",");
                    var sTimes="";
                    var routePath="";

                    for (var arrayLength1 = 0; arrayLength1 <  arr.length; arrayLength1++) {
                        sTimes=sTimes+arr[arrayLength1]+"<br>";
                    }

                    $.ajax({
                        url: '/ViewRoute',
                        type: 'POST',
                        async:false,
                        cache: false,
                        dataType: 'json',
                        data: {
                            'query':'conSelect',
                            'rNo':data[fullData].r_No

                        },

                        success: function (data, textStatus, jqXHR) {
                                pointA=data[0].point_A
                                pointB=data[0].point_B

                        }
                    })

                    var len= arr.length;
                    var path;

                    for (var arraylength2 = 1; arraylength2 <=  len; arraylength2++) {
                        while(len!=0) {

                            if ((len % 2 == 0)) {
                                start = pointB;
                                end = pointA;
                                path=pointB+" "+ "to"+" " +pointA;
                                routePath=routePath+path+"<br>";

                            } else {
                                start = pointA;
                                end = pointB;
                                path=pointA+" "+ "to"+" " +pointB;
                                routePath=routePath+path+"<br>";
                            }


                            len--;
                        }
                    }


                    var tab = '';
                    tab += "<tr class='text-dark'>";
                    tab += "<td>";
                    tab += data[fullData].r_No;
                    tab += "</td>";
                    tab += "<td>";
                    tab += sTimes;
                    tab += "</td>";
                    tab += "<td>";
                    tab += routePath;
                    tab += "</td>";




                    tab += "</tr>";
                    $('#tableSchedule > tbody').append(tab);
                }
            }
        });
    }

</script>