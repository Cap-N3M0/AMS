<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance Management System</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body onload="windowOnLoad();">

    <!-- Header -->
    <header>
        <!-- Wrapper Large screen -->
        <div class="wrapper-lg header">
            
            <!-- Heading -->
            <div class="heading"><h3>Company Header</h3></div>

            <!-- Navbar Menu -->
            <nav class="navbar">
            <ul>
                <li><a>Home</a></li>
                <li><a>About Us</a></li>
                <li><a>Contact Us</a></li>
            </ul>
            </nav>    
        </div>

        <!-- Wrapper for Small Screen -->
        <div class="wrapper-sm header">
            
            <!-- Heading -->
            <div class="heading"><h3>Company Header</h3></div>

            <!-- hidden Toggle for sidebar Menu -->
            <input type="checkbox" id="sidebarMenuToggle" hidden />

            <!-- toggle  and hamburger icon-->
            <label for ="sidebarMenuToggle" class="hamburger">
                <div class="spinner top"></div>
                <div class="spinner middle"></div>
                <div class="spinner bottom"></div>
            </label>

            <!-- SideBar Menu -->
            <div id="sidebarMenu" >

                <!-- Navbar Menu -->
                <nav>
                    <ul>
                        <li><a>Home</a></li>
                        <li><a>About Us</a></li>
                        <li><a>Contact Us</a></li>
                    </ul>
                    </nav>  
            </div>
        </div>
        
    </header>
    <!-- Header Finish -->

    <!-- Main Container for body -->
    <div class="container wrapper-lg wrapper-sm">
        <!-- Left Container -->
        <div id="container1">
            I am container 1. quick brown fox jump over a lazy dog
        </div>
        
        <!-- Right Container -->
        <div id="container2">

            <!-- Form for Login and SignUp -->
            <form action="/" method="POST">
                <!-- <h3></h3> -->
                
                <!-- hidden toggle for slider Menu -->
                <input type="checkbox" id="slider-toggle" hidden>

                <!-- toggle and switch for signup and Register -->
                <label for ="slider-toggle" class="slider"><div class="slider-dot"></div></label>
                
                <!-- form begin -->
                <div class="form-section">
                    <!-- username -->
                    <div class="field">
                        <input type="text" name="fullname" id="fullname" placeholder="John Doe">
                        <label for="fullname">Name</label>
                    </div>
                    
                    <div class="field">
                        <!-- password -->
                        <input type="password" name="password" id="password" placeholder="john.doe@example.com">
                        <label for="password">Password</label>
                    </div>

                    <!-- button for submit form -->
                    <button type="submit" id="bwSubmit" onclick="bwSubmitClick();"></button>
                </div>
            </form>
            <!-- form ends -->
        </div>
        <!-- right container end -->
        
    </div>
    <!-- container end -->

    <!-- Footer starts -->
    <footer>All right reserved. </footer>
    <!-- footer ends -->
</body>

 <script src="${pageContext.request.contextPath}/resources/js/home.js"></script> 

</html>