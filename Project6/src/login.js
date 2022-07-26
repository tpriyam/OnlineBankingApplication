import React, { useState, useEffect } from 'react';import "./login.css";

function Login() {
  const [message, setMessage] = useState(0);

  useEffect(() => {
    fetch('http://localhost:5000/login').then(res => res.json()).then(data => {
      setMessage(data.message);
    });
  }, []);

  return (
    <div className="pad">
        <form action = "http://localhost:5000/login" method = "post">
            <div className="form-group">
                <label>User ID</label> <br/>
                <input placeholder="Enter userID"/><br/>
            </div>
            <div className="form-group">
                <label>Password</label> <br/>
                <input type="password" placeholder="Password"/><br/>
                <small id="emailHelp" className="form-text text-muted">We'll never share your password with anyone else.</small>
            </div>
            <div className="form-check">
                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                <label className="form-check-label" for="exampleCheck1">Remember me</label>
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
        </form>
        <a href="/register">Register new user?</a>
    </div>
  );
}

  export default Login;