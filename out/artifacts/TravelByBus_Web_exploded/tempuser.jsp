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
</head>
<body>

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

<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
  <div class="overlay"></div>
  <div class="container">
    <div class="row no-gutters slider-text justify-content-start align-items-center">
      <div class="col-lg-6 col-md-6 ftco-animate d-flex align-items-end">
        <div class="text">
          <h1 class="mb-4">Now <span>It's easy for you</span> <span>Travel by Bus</span></h1>
          <p style="font-size: 18px;">You can easily travel by bus using temperory,Permenent Cards and tockens.You only want to use you phone and web to it.</p>

        </div>
      </div>
      <div class="col-lg-2 col"></div>
      <div class="col-lg-4 col-md-6 mt-0 mt-md-5 d-flex">
        <form class="request-form ftco-animate">


          <h2>Buy Token</h2>
          <div class="form-group">
            <label for="" class="label">Full Name</label>
            <input type="text" class="form-control" placeholder="Full Name" id="temp_Fname">
          </div>
          <div class="form-group">
            <label for="" class="label">Address</label>
            <input type="text" class="form-control" placeholder="Address" id="temp_Address">
          </div>
          <div class="d-flex">
            <div class="form-group mr-2">
              <label for="" class="label">Mobile Number</label>
              <input type="text" class="form-control" placeholder="Mobile" id="temp_mobile">
            </div>
            <div class="form-group ml-2">
              <label for="" class="label">NIC</label>
              <input type="text" class="form-control"  placeholder="NIC" id="temp_nic">
            </div>
          </div>

          <div class="form-group">
            <input type="button" value="Buy Token" id="add" class="btn btn-primary py-3 px-4" >
          </div>
        </form>
      </div>
    </div>
  </div>
</div>



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

  $("#add").click(function () {


    var temp_Fname = $('#temp_Fname').val();
    var temp_Address = $('#temp_Address').val();
    var temp_mobile = $('#temp_mobile').val();
    var temp_nic = $('#temp_nic').val();


    console.log(temp_Fname + " " + temp_mobile);

    $.ajax({

      type: 'POST',
      url: '/temp_user',
      data: {
        'temp_Fname': temp_Fname,
        'temp_Address': temp_Address,
        'temp_mobile': temp_mobile,
        'temp_nic': temp_nic
      },
      success:function(res){
        window.location.href="Token_Details.jsp?userid="+res;
      }

    })
  })
</script>
