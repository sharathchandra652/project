<!DOCTYPE html>
<%@page import="detection.defense.cache.pollution.Bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="detection.defense.cache.pollution.dao.ViewDAO"%>
<html>
<head>
    <title>Network</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- favicons -->
    <link rel="apple-touch-icon" sizes="57x57" href="images/favicons/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="images/favicons/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/favicons/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="images/favicons/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/favicons/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="images/favicons/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="images/favicons/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="images/favicons/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicons/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="images/favicons/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="images/favicons/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicons/favicon-16x16.png">
    <link rel="manifest" href="/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- favicons -->
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/custom-responsive-style.css">
    <link href="//fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="script/all-plugins.js"></script>
    <script type="text/javascript" src="script/plugin-active.js"></script>
</head>
<body data-spy="scroll" data-target=".main-navigation" data-offset="150">
<%ArrayList<Bean> al = new ViewDAO().routerViewNewPCRequest(); %>
    <section id="MainContainer">
        <!-- Header starts here -->
        <jsp:include page="routerMenu.jsp"></jsp:include>
        <!-- Header ends here -->        
        <!-- Register section starts here -->
        <section id="Register">
            <div class="container contact-container">
                <h3 class="contact-title" style="margin-top: 15%; color: blue;">New PC Requests</h3>
                <%String status = request.getParameter("status");
                if(status!=null)
                {%>
                	<h1 class="contact-title" style="color: green;"><%out.print(status); %></h1>
                <%}
                %>
                <div class="contact-outer-wrapper">
                    <div class="form-wrap">
                    <%if(!al.isEmpty()){ %>
                        <table class="table table-bordered" style="text-align: center;">
                                    <tr>
                                        <th style="padding: 20px;">UID</th>
                                        <th style="padding: 20px;">UNAME</th>
                                        <th style="padding: 20px;">Email</th>
                                        <th style="padding: 20px;">IpAddress</th>
                                        <th style="padding: 20px;">Mobile</th>
                                        <th style="padding: 20px;">Accept</th>
                                    </tr>
                                    <%for(Bean b:al){ %>
                                    <tr>
                                       <th style="padding: 20px;"><%=b.getUid() %></th>
                                       <th style="padding: 20px;"><%=b.getUname() %></th>
                                       <th style="padding: 20px;"><%=b.getEmail() %></th>
                                       <th style="padding: 20px;"><%=b.getIpaddress() %></th>
                                       <th style="padding: 20px;"><%=b.getMobile() %></th>
                                       <th style="padding: 20px;"><a href="./AcceptNewPCServlet_router?uid=<%=b.getUid()%>">Accept</a></th>
                                    </tr>
                                    <%} %>
                                </table>
                                <%}else{ %>
                                	<h3 class="contact-title" style="margin-top: 5%;">New PC Requests are Not Available</h3>
                                	
                                <%} %>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section ends here -->
    </section>
</body>

</html>