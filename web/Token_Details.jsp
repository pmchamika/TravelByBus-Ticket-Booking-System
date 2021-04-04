<%@ page import="java.sql.ResultSet" %>
<%@ page import="DBconnect.ConnectionMySql" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel By Bus</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
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

    <script src="jquery.min.js"></script>
    <script src="qrcode.min.js"></script>
</head>
<body onload="loca()">

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="tempuser.jsp">Travel<span>ByBus</span></a>
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

<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_3.jpg');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
            <div class="col-md-9 ftco-animate pb-5">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>request Card > Payment Method <i class="ion-ios-arrow-forward"></i></span></p>
                <h1 class="mb-3 bread">Tocken Details</h1>
            </div>
        </div>
    </div>
</section>

<section>




   <h2 >Tocken Details</h2>

    <div class=""></div>
    <div class="" >
        <form action="#" class="request-form ftco-animate">

            <div class="form-group">
                <label for="" class="label">Route</label>
                <select name="pickup" class="form-control" id="route" onchange="loca()">

                    <%
                        ConnectionMySql conn = ConnectionMySql.getCon();
                        String q1="SELECT `point_A`,`point_B`,`r_No` FROM `route`";
                        ResultSet re=conn.selectQuery(q1);
                        while (re.next()){
                    %>
                         <option value="<%=re.getString("r_No")%>"><%=re.getString("point_A")%>-<%=re.getString("point_B")%></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">

                    <label for="" class="label">Date</label>
                    <input type="text" class="form-control" id="book_off_date" placeholder="Date" onchange="">



            </div>

            <div class="form-group">
                <label for="" class="label">Pick UP</label>
                <select name="pickup" class="form-control" id="temp_spoint">

                </select>
            </div>
            <div class="form-group">
                <label for="" class="label">Drop Off</label>
                <select name="dropoff"  class="form-control" placeholder="Drop Off " id="temp_epoint">

                </select>




            </div>
            <input type="hidden" class="form-control" id="tempuid" value="<%=request.getParameter("userid") %>">


                <div class="form-group">
                    <label for="" class="label">Number of Tickets</label>
                    <input type="text" class="form-control" placeholder="Number of Tickets" id="temp_qty">
                </div>



            <div class="form-group">
                <input type="button" value="Proceed and Continue" id="add"  class="btn btn-primary py-3 px-4" onclick="generateQR()">

            </div>
        </form>

    </div>
    </div>
    </div>
    </div>






</section>






<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="js/main.js"></script>

</body>
</html>




<script>

    function loca(){
        var rou=$('#route').val();

        $.ajax({

            type: 'POST',
            url: '/Servletgetlocation',
            data: {

                'rou': rou

            },
            success:function(res){
                res = res.split(",");
                console.log(res);
                var select = document.getElementById("temp_spoint");
                var select2 = document.getElementById("temp_epoint");
                for (var i = 0; i < res.length; i++) {
                    select.options[select.options.length] = new Option(res[i],res[i]);
                    select2.options[select2.options.length] = new Option(res[i],res[i]);
                }
            }

        })
    }

     function gettime(da){
        var rou=$('#route').val();
         $.ajax({

             type: 'POST',
             url: '/ServletgetTime',
             data: {
                 'date': da,
                 'rou': rou

             },
             success:function(res){

             }

         })
     }



    $("#add").click(function () {


        var temp_spoint = $('#temp_spoint').val();
        var temp_epoint = $('#temp_epoint').val();
        var temp_qty = $('#temp_qty').val();
        var temp_date = $('#book_off_date').val();
        var tempuid=$('#tempuid').val();
        var rou=$('#route').val();


        console.log(temp_spoint+ " " + temp_epoint);

        $.ajax({

            type: 'POST',
            url: '/tempory_token',
            data: {
                'temp_spoint': temp_spoint,
                'temp_epoint': temp_epoint,
                'temp_qty': temp_qty,
                'temp_date': temp_date,
                'tempuid' : tempuid,
                'rou' : rou

            },
            success:function(res){
                console.log(res);
                res=res.split(",");
                var r = confirm("price : "+res[1]);
                if (r == true) {
                    window.open('QRCodeGenarator.jsp?hash='+res[0],"window name",
                        "height=500,width=500,modal=yes,alwaysRaised=yes");
                } else {

                }
                // window.location.href="QRCodeGenarator.jsp"
            }

        })
    })
</script>
