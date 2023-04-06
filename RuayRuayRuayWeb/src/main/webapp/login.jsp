<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous"
        />
        <link rel="stylesheet" href="style.css">
        <title>Login</title>
      </head>
    
      <body class="">
        <div class="vh-100 d-flex justify-content-center align-items-center ">
          <div class="col-md-4 p-5 shadow-sm border rounded-3 bg-white">
            <h2 class="text-center mb-4 text-dark">Login</h2>
            <form action="checklogin.jsp" method="post">
              <div class="mb-3">
                <label for="username"class="form-label"
                  >Username</label
                >
                <input
                  type="text"
                  class="form-control "
                  id="user"
                  name="user" 
                />
              </div>
              <div class="mb-3">
                <label for="c" class="form-label"
                  >Password</label
                >
                <input
                  type="password"
                  class="form-control border "
                  id="pass"
                  name="pass" 
                />
              </div>
              
              <div class="d-grid">
                <button class="btn btn-dark" type="submit">Login</button>
              </div>
            </form>
            
          </div>
        </div>
    
        <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
          crossorigin="anonymous"
        ></script>
      </body>
    </html>
    