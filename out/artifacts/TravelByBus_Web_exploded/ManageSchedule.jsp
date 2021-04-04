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
                <li class="nav-item"><a href="SignIn.jsp" class="nav-link">Sign In</a></li>
                <%if (session.getAttribute("type")!=null){%>

                <%if(session.getAttribute("type").toString().equalsIgnoreCase("Admin")){%>
                <li class="nav-item"><a href="ManageBus.jsp" class="nav-link">Manage Buses</a></li>
                <li class="nav-item"><a href="ManageRoute.jsp" class="nav-link">Manage Routes</a></li>
                <li class="nav-item"><a href="ManageSchedule.jsp" class="nav-link">Schedules</a></li>
                <li class="nav-item"><a href="tempuser.jsp" class="nav-link">Tickets</a></li>
                <li class="nav-item"><a href="ManagerCardApproval.jsp" class="nav-link">Approval</a></li>
                <li class="nav-item"><a href="ViewCharts.jsp" class="nav-link">Analysis</a></li>

                <%}else if(session.getAttribute("type").toString().equalsIgnoreCase("Customer")){%>

                <li class="nav-item"><a href="ViewSchedule.jsp" class="nav-link">Bus Schedule</a></li>
                <li class="nav-item"><a href="PaymentMethod.jsp" class="nav-link">Payment Method</a></li>
                <li class="nav-item"><a href="RequestCard.jsp" class="nav-link">Request Card</a></li>
                <%}%>

                <%}else{%>


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
            <div class="form-row">
                <div class="col-md-3 form-group" style="margin-left:1%">

                    <label for="" class="label">Bus No</label>
                        <%
                            BusDao bdao= new BusDaoImpl();
                            try {
                                List<Bus> listBus = bdao.getBusList();

                        %>
                              <select class="form-control select2"  name="busNo" id="busNo" style="width: 100%" >
                                <%  for(Bus bus : listBus) { %>
                                <option value="<%= bus.getBusNo()%>"><%= bus.getBusNo()%> </option>
                                <% } %>
                              </select>

                         <%   } catch (Exception e) {
                                e.printStackTrace();
                            }
                        %>

                </div>

                <div class="col-md-3 form-group">
                    <label for="" class="label">Route No</label>
                    <%
                        RouteDao rdao= new RouteDaoImpl();
                        try {
                            List<Route> listRoute = rdao.getRouteList();

                    %>
                    <select class="form-control select2"  name="routeNo" id="routeNo" style="width: 100%" >
                        <%  for(Route route : listRoute) { %>
                        <option value="<%= route.getR_no()%>"><%= route.getR_no()%>  <%= route.getPointA()%> - <%= route.getPointB()%></option>
                        <% } %>
                    </select>

                    <%   } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>

                </div>
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">Conductor ID</label>
                    <input type="text" id="c_id" class="form-control" placeholder="">
                </div>

                <div class="form-group col-md-6">
                    <label for="s_date">Schedule Date</label>
                    <input type="text" class="form-control" id="s_date" placeholder="2019-08-05">
                </div>
                <div class="form-group col-md-6">
                    <label for="s_time">Schedule Times</label>
                    <input type="text" class="form-control" id="s_time" placeholder="9.00 AM,10.00 AM,1.30 PM,5.45 PM">
                </div>

                <div class="col-md-3 form-group">
                    <input type="button" value="Add" id="add" class="btn btn-primary py-3 px-4" >
                    <input type="button" value="update" id="update" class="btn btn-secondary py-3 px-4" >
                </div>
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Schedule Management <i class="ion-ios-arrow-forward"></i></span></p>
                <h1 class="mb-3 bread">Schedule Management</h1>
            </div>
        </div>
    </div>
</section>


<table id="tableSchedule" class="table table-bordered table-striped table-hover table-responsive-md ">
    <thead>
    <tr>
        <th>Bus No</th>
        <th>Route No</th>
        <th>Ticket Inspector ID</th>
        <th>Schedule Date</th>
        <th>Added By</th>
        <th>Edit Records</th>
        <th>Delete Records</th>
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

<%--<script src="js/jquery.dataTables.min"></script>--%>
<!--Import jQuery before export.js-->


<!--Data Table-->
<script type="text/javascript"  src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"  src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>



<%--  <!--Export table button CSS-->

  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">--%>


</body>
</html>

<script>
    var table;
    var ScheduleIdForUpdate="";
    $(document).ready(function () {

        table=$('#tableSchedule').dataTable({


            "lengthMenu": [[ -1], ["All"]],


            ordering: false,  // Disabels COLUMN ordering
            scrollY: "600px",
            scrollCollapse: false,

        });
        loadTable();
        $("#update").hide();



    });


    function deleteSchedule(data) {

        $.ajax({

            type: 'POST',
            url: '/DeleteSchedule',
            data: {
                'scheduleId': data

            },

            success:function () {
                window.location.href="ManageSchedule.jsp";
                $('#busNo').val();
                $('#routeNo').val();
                $('#c_id').val();
                $('#s_date').val();
                $('#s_time').val();

                ScheduleIdForUpdate="";
                $("#update").hide();
                // table.draw();
            }

        })
        //table.ajax.reload();
    };

    function editSchedule(data) {

        ScheduleIdForUpdate=data;
        $.ajax({

            type: 'POST',
            url: '/UpdateSchedule',
            cache: false,
            dataType: 'json',
            data: {
                'scheduleId': data,
                'query':'selectQ'

            },

            success: function (result, textStatus, jqXHR) {
                var sDate=result[0].s_date;
                var dateSplit=sDate.split(" ")
                // table.draw();

                $("#busNo").val(result[0].b_No).change();
                $('#routeNo').val(result[0].r_No).change();
                $('#c_id').val(result[0].con_u_ID);
                $('#s_date').val(dateSplit[0]);
                $('#s_time').val(result[0].s_time);
                $("#update").show();

            }

        })
        //table.ajax.reload();
    };
    function loadTable(){

        $.ajax({
            url: '/ViewSchedule',
            type: 'POST',
            cache: false,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function (data, textStatus, jqXHR) {
                console.log(data[0]);
                $("#tableSchedule > tbody").html("");

                for (var i = 0; i < data.length; i++) {
                    var sDate=data[i].s_date;
                    var dateSplit=sDate.split(" ")

                    var tab = '';
                    tab += "<tr class='text-dark'>";
                    tab += "<td>";
                    tab += data[i].b_No;
                    tab += "</td>"
                    tab += "<td>";
                    tab += data[i].r_No;
                    tab += "</td>";
                    tab += "<td>";
                    tab += data[i].con_u_ID;
                    tab += "</td>";
                    tab += "<td>";
                    tab += dateSplit[0];
                    tab += "</td>";
                    tab += "<td>";
                    tab += data[i].add_uid;
                    tab += "</td>";
                    tab += "<td>";
                    tab +="<input type='button' class='btn btn-primary edit_btn' onclick=editSchedule("+data[i].s_ID+") id="+data[i].s_ID+" value='Edit Schedule'><i class='glyphicon glyphicon-pencil'></i></input>";
                    tab += "</td>";
                    tab += "<td>";
                    tab +="<input type='button' class='btn btn-primary delete_btn' onclick=deleteSchedule("+data[i].s_ID+") id="+data[i].s_ID+" value='Delete Schedule'><i class='glyphicon glyphicon-pencil'></i></input>";
                    tab += "</td>";
                    tab += "</tr>";
                    $('#tableSchedule > tbody').append(tab);
                }
            }
        });
    }

    $("#add").click(function () {


        var busNo = $('#busNo').val();
        var routeNo = $('#routeNo').val();
        var cid = $('#c_id').val();
        var s_date = $('#s_date').val();
        var s_time = $('#s_time').val();


        if(busNo==""){
            alert("Please enter the bus no to continue")
        }else if(routeNo==""){
            alert("Please enter the route no to continue")
        }else if(cid==""){
            alert("Please enter the Conductor to continue")
        }else if(s_date==""){
            alert("Please enter the Schedule date no to continue")
        }else if(s_time==""){
            alert("Please enter the Schedule times to continue")
        }else {

            console.log(s_date);
            $.ajax({

                type: 'POST',
                url: '/AddSchedule',
                data: {
                    'busNo': busNo,
                    'routeNo': routeNo,
                    'cid': cid,
                    's_date': s_date,
                    's_time': s_time
                },

                success: function () {
                    window.location.href = "ManageSchedule.jsp"

                }

            })
        }
    })

    $("#update").click(function () {


        var busNo = $('#busNo').val();
        var routeNo = $('#routeNo').val();
        var cid = $('#c_id').val();
        var s_date = $('#s_date').val();
        var s_time = $('#s_time').val();

        if(busNo==""){
            alert("Please enter the bus no to continue")
        }else if(routeNo==""){
            alert("Please enter the route no to continue")
        }else if(cid==""){
            alert("Please enter the Conductor to continue")
        }else if(s_date==""){
            alert("Please enter the Schedule date no to continue")
        }else if(s_time==""){
            alert("Please enter the Schedule times to continue")
        }else {
            $.ajax({
                type: 'POST',
                url: '/UpdateSchedule',
                data: {
                    'scheduleId': ScheduleIdForUpdate,
                    'busNo': busNo,
                    'routeNo': routeNo,
                    'cid': cid,
                    's_date': s_date,
                    's_time': s_time,
                    'query': 'updateQ'
                },

                success: function () {
                    window.location.href = "ManageSchedule.jsp"
                    ScheduleIdForUpdate = "";
                    $("#update").hide();

                }

            })
        }
    })

    $(function () {
        //Initialize Select2 Elements
        $('.select2').select2()
    });
</script>