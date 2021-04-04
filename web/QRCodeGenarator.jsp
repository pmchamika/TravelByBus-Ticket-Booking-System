<%@ page import="DBconnect.ConnectionMySql" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<head>
    <title>Cross-Browser QRCode generator for Javascript</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/qrcode.js"></script>
</head>
<body>
<%
    ConnectionMySql conn = ConnectionMySql.getCon();
    String q1="SELECT `temp_spoint`,`temp_epoint`,`temp_price`,`temp_date` FROM `tempory_token` where token_hashID ='"+request.getParameter("hash")+"'";
    ResultSet re=conn.selectQuery(q1);
    String temp_spoint="";
    String temp_epoint="";
    String temp_price="";
    String temp_date="";
    if (re.next()){
        temp_spoint=re.getString("temp_spoint");
        temp_epoint=re.getString("temp_epoint");
        temp_price=re.getString("temp_price");
        temp_date=re.getString("temp_date");
        String f[]=temp_date.split(" ");
        temp_date=f[0];
    }

%>
<div id="qrcode" style="width:100px; height:100px; margin-top:15px;"></div><br/>
Start point : <%=temp_spoint%><br/>
End point : <%=temp_epoint%><br/>
Price point : <%=temp_price%><br/>
Date point : <%=temp_date%><br/>
<input type="button" value="Print" onclick="window.print()"/>
<input type="hidden" value="<%=request.getParameter("hash") %>" id="qr"/>

<script type="text/javascript">
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 100,
        height : 100
    });

    qrcode.makeCode(document.getElementById("qr").value);



</script>
</body>