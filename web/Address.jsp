<%--
  Created by IntelliJ IDEA.
  User: kaushirajapakshe
  Date: 2019-09-28
  Time: 09:53
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

<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_2.jpg'); overflow: auto"
         data-stellar-background-ratio="0.5">
    <div class="overlay"></div>

    <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start" style="margin-top: 12vh">

        <div class="col-md-9 ftco-animate pb-5">
            <div class="container">

                <div class="col-md-6 form-group">
                    <label for="" class="label">Address</label>
                    <input type="text" id="address" class="form-control" placeholder="No.21, Welhena Road">
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">City</label>
                    <input type="text" id="city" class="form-control"
                           placeholder="Minuwangoda">
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">State</label>
                    <input type="text" id="state" class="form-control" placeholder="Mathammana">
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">Postal Code</label>
                    <input type="text" id="postalCode" class="form-control"
                           placeholder="11500">
                </div>
                <div class="col-md-6 form-group">
                    <label for="" class="label">Country</label>
                    <input type="text" id="country" class="form-control"
                           placeholder="Sri Lanka">
                </div>
                <div class="col-md-6 form-group">
                    <input type="button" value="Continue" id="addAddress" class="btn btn-primary py-3 px-4">
                    <input type="button" value="update" id="update" class="btn btn-secondary py-3 px-4" >
                </div>
                <p class="breadcrumbs"><span class="mr-2"><a href="Home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span>
                    <span>Payment via Card <i class="ion-ios-arrow-forward"></i></span></p>
                <h1 class="mb-3 bread">Card Payment</h1>
            </div>
        </div>
    </div>
</section>

<table id="tableAddress" class="table table-bordered table-striped table-hover table-responsive-md ">
    <thead>
    <tr>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Postal Code</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>

    </tbody>

</table>

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
    var table;
    var addressIdForUpdate="";
    $(document).ready(function () {

        table=$('#tableAddress').dataTable({

            /*  dom: 'Bfrtip',
              paging: true,
              buttons: [
                'print'
              ]*/
            "lengthMenu": [[ -1], ["All"]],


            ordering: false,  // Disabels COLUMN ordering
            scrollY: "600px",
            scrollCollapse: false,
            /* ajax:{
               method:'POST',
               url:'/bus',
               dataSrc:datas
             },
             columns:[
               {data:"b_no"},
               {data:"b_Model"},
               {data:"No_BSeats"},
               {data:"add_uid"}


             ]*/
        });
        loadTable();
        $("#update").hide();
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


    function deleteAddress(data) {

        $.ajax({

            type: 'POST',
            url: '/DeleteAddress',
            data: {
                'addressId': data

            },

            success:function () {
                window.location.href="PaymentMethod.jsp";
                $('#address').val();
                $('#city').val();
                $('#state').val();
                $('#postalCode').val();
                $('#country').val();


                addressIdForUpdate="";
                $("#update").hide();
                // table.draw();
            }

        })
        //table.ajax.reload();
    };

    function editAddress(data) {
        addressIdForUpdate=data;
        $.ajax({

            type: 'POST',
            url: '/UpdateAddress',
            cache: false,
            dataType: 'json',
            data: {
                'addressId': data,
                'query':'selectQ'

            },

            success: function (result, textStatus, jqXHR) {

                // table.draw();
                $('#address_id').val(result[0].address_id);
                $('#address').val(result[0].address);
                $('#city').val(result[0].city);
                $('#state').val(result[0].state);
                $('#postalCode').val(result[0].postalCode);
                $('#country').val(result[0].country);

                $('#address_id').attr('disabled',true);
                $("#update").show();
            }

        })
        //table.ajax.reload();
    };
    // function loadTable(){
    //
    //     $.ajax({
    //         url: '/ViewBus',
    //         type: 'POST',
    //         cache: false,
    //         dataType: 'json',
    //         processData: false,
    //         contentType: false,
    //         success: function (data, textStatus, jqXHR) {
    //             console.log(data[0]);
    //             $("#tableBus > tbody").html("");
    //
    //             for (var i = 0; i < data.length; i++) {
    //
    //                 var tab = '';
    //                 tab += "<tr class='text-dark'>";
    //                 tab += "<td>";
    //                 tab += data[i].b_no;
    //                 tab += "</td>"
    //                 tab += "<td>";
    //                 tab += data[i].b_Model;
    //                 tab += "</td>";
    //                 tab += "<td>";
    //                 tab += data[i].No_BSeats;
    //                 tab += "</td>";
    //                 tab += "<td>";
    //                 tab += data[i].add_uid;
    //                 tab += "</td>";
    //                 tab += "<td>";
    //                 tab +="<input type='button' class='btn btn-primary edit_btn' onclick=editBus("+data[i].b_ID+") id="+data[i].b_no+" value='Edit Bus'><i class='glyphicon glyphicon-pencil'></i></input>";
    //                 tab += "</td>";
    //                 tab += "<td>";
    //                 tab +="<input type='button' class='btn btn-primary delete_btn' onclick=deleteBus("+data[i].b_ID+") id="+data[i].b_no+" value='Delete Bus'><i class='glyphicon glyphicon-pencil'></i></input>";
    //                 tab += "</td>";
    //                 tab += "</tr>";
    //                 $('#tableBus > tbody').append(tab);
    //             }
    //         }
    //     });
    // }
    $("#addPayment").click(function () {


        var address = $('#address').val();
        var city = $('#city').val();
        var state = $('#state').val();
        var postalCode = $('#postalCode').val();
        var country = $('#country').val();

        if (address == "") {
            alert("Please enter the Address to continue")
        } else if (city == "") {
            alert("Please enter the City to continue")
        } else if (state == "") {
            alert("Please enter the State to continue")
        } else if (postalCode == "") {
            alert("Please enter the Postal Code to continue")
        } else if (country == "") {
            alert("Please enter the Country to continue")
        } else {

            $.ajax({

                type: 'POST',
                url: '/Address',
                data: {
                    'address' : address,
                    'city' : city,
                    'state': state,
                    'postalCode': postalCode,
                    'country': country,
                },

                success: function () {
                    window.location.href = "Home.jsp"

                }

            })
        }
    })
    // $("#update").click(function () {
    //
    //
    //     var busNo = $('#busNo').val();
    //     var model = $('#model').val();
    //     var No_BSeats = $('#No_BSeats').val();
    //
    //     if(busNo==""){
    //         alert("Please enter the bus no to continue")
    //     }else if(model==""){
    //         alert("Please enter the bus modal to continue")
    //     }else if(No_BSeats==""){
    //         alert("Please enter the No of seats to continue")
    //     }else {
    //
    //         $.ajax({
    //
    //             type: 'POST',
    //             url: '/UpdateBus',
    //             data: {
    //                 'busId': busIdForUpdate,
    //                 'busNo': busNo,
    //                 'model': model,
    //                 'No_BSeats': No_BSeats,
    //                 'query': 'updateQ'
    //             },
    //
    //             success: function () {
    //                 window.location.href = "ManageBus.jsp"
    //                 busIdForUpdate = "";
    //                 $("#update").hide();
    //                 $('#busNo').attr('disabled', false);
    //             }
    //
    //         })
    //     }
    // })
</script>


