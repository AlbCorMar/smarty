<section>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
            <a class="navbar-brand" href="/home">
                <img src="/images/logo.png"  height="40" alt="#" />
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

                <ul class="navbar-nav  mr-auto ">
                    <li class="nav-item active"><a class="nav-link" href="/home"><s:message code="navBar.Home"/></a></li>
                    <li class="nav-item disabled"><a class="nav-link" href="/about"><s:message code="navBar.About"/></a></li>
                    <li class="nav-item disabled"><a class="nav-link" href="/bet"><s:message code="navBar.Bet"/></a></li>
                    <li class="nav-item disabled"><a class="nav-link" href="/Results/historic"><s:message code="navBar.Historic"/></a></li>
                    <li class="nav-item disabled"><a class="nav-link" href="/contact"><s:message code="navBar.Contact"/></a></li>
                </ul>
                <ul class="navbar-nav ml-auto nav-flex-icons">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="language" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <i style="padding: 0px 6px 0px 6px" class="fa fa-language"></i><s:message code="navBar.Language"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-default"
                             aria-labelledby="navbarDropdownMenuLink-333">
                            <a class="dropdown-item" href="?lang=es"><s:message code="navBar.Spanish"/></a>
                            <a class="dropdown-item" href="?lang=en"><s:message code="navBar.English"/></a>
                        </div>
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="login" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i style="padding: 0px 6px 0px 6px" class="fas fa-sign-in-alt"></i><s:message code="navBar.Login"/>
                            </a>
                        </li>
                        <input type="hidden" id="userRegistred" value = "">
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="principalUserName" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i style="padding: 0px 6px 0px 6px" class="fas fa-user"></i><sec:authentication property="principal.username"/>

                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-default"
                                 aria-labelledby="navbarDropdownMenuLink-333">
                                <a id="showUser" href="#" class="dropdown-item"><s:message code="navBar.Profile"/></a>
                                <a class="dropdown-divider"></a>
                                <a class="dropdown-item" href="#" id="logOut"><s:message code="navBar.Logout"/></a>
                            </div>
                        </li>
                        <input type="hidden" id="userRegistred" value = <sec:authentication property="principal.username"/>>
                    </sec:authorize>
                </ul>
            </div>
        </nav>
        <div class="right_top_section">
            <!-- social icon -->
            <ul class="social-icons pull-left">
                <li><a class="facebook" href="#"><i class="fab fa-facebook"></i></a></li>
                <li><a class="twitter" href="#"><i class="fab fa-twitter"></i></a></li>
                <li><a class="youtube" href="#"><i class="fab fa-youtube"></i></a></li>
                <li><a class="pinterest" href="#"><i class="fab fa-pinterest-p"></i></a></li>
            </ul>
        </div>
    </header>
    <div class="inner-page-banner">
        <div class="container">
        </div>
    </div>
    <div id="loginModal" class ="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 >LOGIN</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
                </div>
                <div class="modal-body">
                    <form id="formLogin">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                        <div class="form-group">
                            <label for="userName"><s:message code="Login.Username"/></label>
                            <input type="text" class="form-control form-control-lg" name="logUsername" id="username"
                                   required=""/>
                        </div>
                        <div class="form-group">
                            <label for="password"><s:message code="Login.Password"/></label>
                            <input type="password" class="form-control form-control-lg" name="logPassword" id="password"/>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="remember-me" name="remember-me">
                            <label class="custom-control-label" for="remember-me"><s:message code="Login.rememberMe"/>
                            </label>
                        </div>
                    </form>
                    <div class="form-group">
                        <button class="btn btn-success btn-lg center" id="bottomLogin">Login</button>
                    </div>
                    <br class="custom-control custom-checkbox">
                    <label><s:message code="Login.Haveaccount"/><a style="padding-left:5px;" href="/user" class="float-right"><s:message code="Login.NewUser"/></a></label>
                    <label><a href="#" class="float-right"><s:message code="Login.ForgotPasswor"/></a></label>

                </div>
            </div>
        </div>
    </div>
</section>

