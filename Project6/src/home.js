import React, { useState, useEffect } from 'react';
import "./home.css"

function Home() {
  const [header, setHeader] = useState(0);

  useEffect(() => {
    fetch('http://localhost:5000/').then(res => res.json()).then(data => {
      setHeader(data.heading);
    });
  }, []);

  return (
    <div className="jumbotron vertical-center">
        <div className="container text-center">
            <h1>Home</h1>
            <p> This is home for loan prediction app. </p>
            <p> Welcome to Tavishi and Manan's Online Loan Prediction and Processing System</p>
            <p>Securing a loan was never so easy. If you are new here, please register before proceeding with the application form. <br/>If you have been here before, Welcome back!</p>
            <a href="/login">Login now</a> <br/>
        </div>
    </div>
  );
}

export default Home;

// class Login extends React.Component {
//     render() {
//       const [header, setHeader] = useState(0);
//       useEffect(() => {
//         fetch('/').then(res => res.json()).then(data => {
//           setHeader(data);
//         });
//       }, []);
//       return (
//         <div class="jumbotron vertical-center">
//             <div class="container text-center">
//                 <h1>Home {header}</h1>
//                 <p> This is home for loan prediction app.</p>
//                 <p> Welcome to Tavishi and Manan's Online Loan Prediction and Processing System</p>
//                 <p>Securing a loan was never so easy. If you are new here, please register before proceeding with the application form. <br/>If you have been here before, Welcome back!</p>
//                 <a href="/login">Login now</a> <br/>
//             </div>
//         </div>
//       );
//     }
//   }
// }