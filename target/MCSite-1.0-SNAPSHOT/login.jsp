


<!DOCTYPE html>

<html>

<body>

<jsp:include page="base.jsp"></jsp:include>

<br>

  <h1>Login</h1>

  <div class="content-section">
      <form action="login" METHOD="POST">
          <br>
          Please enter your username
          <input type="text" name="username"/><br>

          Please enter your password
          <input type="password" name="password"/>

          <input type="submit" value="submit"><br>

      </form>
    <div class='border-top pt-3'>
      Hai bisogno di un account? <a class="ml-2" href="register">Registrati</a>
    </div>

  </div>
