<!DOCTYPE html>
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
    <section id="MainContainer">
        <!-- Header starts here -->
        <jsp:include page="menu.jsp"></jsp:include>
        <!-- Header ends here -->
        
        <!-- Banner starts here -->
        <section id="HeroBanner">
            <div class="hero-content">
                <h1>Research on Data Routing Strategy in Cloud Environment</h1>
                <%String status = request.getParameter("status");
                if(status!=null)
                {%>
                	<h1><%out.print(status); %></h1>
                <%}
                %>
            </div>
        </section>
        <!-- Banner ends here -->
        <!-- Register section starts here -->
        <section id="Register">
            <div class="container contact-container">
                <h3 class="contact-title" style="margin-top: 10%;">PC Registration</h3>
                <div class="contact-outer-wrapper">
                    <div class="form-wrap">
                        <form action="./RegisterServlet" method="post">
                            <div class="fname floating-label">
                                <input type="text" class="floating-input" name="name" id="full-name-field" required="" />
                                <label for="full-name-field">Name</label>
                            </div>
                            <div class="email floating-label">
                                <input type="email" class="floating-input" name="email" id="mail-field" required="" />
                                <label for="mail-field">Email</label>
                            </div>
                            <div class="contact floating-label">
                                <input type="password" class="floating-input" name="password" id="contact-us-field"  required=""/>
                                <label for="contact-us-field">Password</label>
                            </div>
                            <div class="company floating-label">
                                <input type="tel" class="floating-input" name="mobile" id="company-field" maxlength="10" required=""/>
                                <label for="company-field">Mobile</label>
                            </div>
                            <div class="user-msg floating-label">
                                <textarea class="floating-input" name="address" id="user-msg-field" required=""></textarea>
                                <label for="user-msg-field" class="msg-label">Address</label>
                            </div>
                            <div class="submit-btn">
                                <button type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section ends here -->
        <!-- About Us section starts here -->
        <section id="About">
            <div class="container" style="margin-bottom: 20%;">
                <div class="about-wrapper">
                    <h2 style="margin-top: 10%;">About Project</h2>
                    <p>
                    </p>
                </div>
            </div>
        </section>
        <!-- About Us section ends here -->
        
        <!-- Contact us section starts here -->
        <section id="ContactUs">
            <div class="container contact-container" style="margin-bottom: 10%;">
                <h3 class="contact-title">Router (Or) User Login</h3>
                <div class="">
                    <div class="form-wrap">
                        <form action="./LoginServlet" method="post">
                            <div class="email floating-label" style="margin-left: 40%;">
                                <input type="email" class="floating-input" name="email" id="mail-field" required=""/>
                                <label for="mail-field">Email</label>
                            </div>
                            <div class="contact floating-label" style="margin-left: 40%;">
                                <input type="password" class="floating-input" name="password" id="contact-us-field" required=""/>
                                <label for="contact-us-field">Password</label>
                            </div>
                            <div class="submit-btn">
                                <button type="submit">Login</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Contact us section ends here -->
    </section>
</body>

</html>