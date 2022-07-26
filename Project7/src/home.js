import React from 'react';
import "./home.css"

const Home = ({loggedIn}) => {

  return (
    <div className="jumbotron vertical-center">
        <div className="container text-center">
            <h1>Home</h1>
            <p> This is home for loan prediction app. </p>
            <p> Welcome to Tavishi and Manan's Online Loan Prediction and Processing System</p>
            <p> Securing a loan was never so easy. </p>
            {loggedIn==='false' && 
              <div>
                <p>If you are new here, please register before proceeding with the application form. <br/>If you have been here before, Welcome back!</p>
                <a href="/login">Login now</a>
              </div>
            } <br/>
        </div>
    </div>
  );
}

export default Home;