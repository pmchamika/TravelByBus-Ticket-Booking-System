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
    String q1="SELECT `t_IssueDate`,`t_ExpireDate` FROM `token` where token_hashID ='"+request.getParameter("hash")+"'";
    ResultSet re=conn.selectQuery(q1);
    String t_IssueDate="";
    String t_ExpireDate="";
    if (re.next()){
        t_IssueDate=re.getString("t_IssueDate");
        t_ExpireDate=re.getString("t_ExpireDate");
        String f[]=t_IssueDate.split(" ");
        t_IssueDate=f[0];
        String f2[]=t_ExpireDate.split(" ");
        t_ExpireDate=f2[0];
    }

%>
<div id="qrcode" style="width:100px; height:100px; margin-top:15px;"></div><br/>
Issue Date : <%=t_IssueDate%><br/>
Expire Date : <%=t_ExpireDate%><br/>
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