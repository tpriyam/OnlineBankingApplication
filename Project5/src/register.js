import React from 'react';

class Register extends React.Component {
    render() {
      return (
        <div>
          <h1>Register </h1>
          <form action = "http://localhost:5000/register" method = "post">
            Name: <input type="text" name="name"></input><br/>
            Username: <input type="text" name="username"></input><br/>
            Password: <input type="password" name="password"></input><br/>
            <button type="submit" className="btn btn-primary">Submit</button>
          </form>
          <a href="/login">Already a user?</a>
        </div>
      );
    }
  }

  export default Register;