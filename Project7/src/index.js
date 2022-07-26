import ReactDOM from 'react-dom';
import { BrowserRouter, Switch , Route} from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import './index.css';
import Login from "./login";
import Register from "./register";
import Home from "./home"
import LoanForm from './loanform';
import NavBar from "./navbar"
import ClientStatus from './clientstatus';
import 'bootstrap/dist/css/bootstrap.min.css';
// import background from "./img_financedoodle.jpg";


const App = () => {

  const [loggedIn, setLoggedIn] = useState('false');
  const [clientId, setClientId] = useState(null);
  // sessionStorage.setItem("loggedIn", "false");
  // sessionStorage.setItem("clientId", null);
  
  useEffect(() => {
    setLoggedIn(sessionStorage.getItem("loggedIn") === null ? 'false' : sessionStorage.getItem("loggedIn"));
    setClientId(sessionStorage.getItem("clientId"));
    console.log("in effect: " + sessionStorage.getItem("loggedIn") + " " + sessionStorage.getItem("clientId") ) //+ " " +  loggedIn + " " +  clientId
  }, []);

  return (
    <BrowserRouter>
      <div>

        <NavBar loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>

        <Switch>
          <Route exact path="/">
            <Home loggedIn={loggedIn}/>
          </Route>
          <Route exact path="/login">
            <Login loggedIn={loggedIn} setLoggedIn={setLoggedIn} setClientId={setClientId}/>
          </Route>
          <Route exact path="/register">
            <Register/>
          </Route>
          <Route exact path="/loanform">
            <LoanForm  clientId={clientId}/>
          </Route>
          <Route exact path="/clientstatus">
            <ClientStatus clientId={clientId}/>
          </Route>
        </Switch>
      </div>
    </BrowserRouter>
  );

}

// ========================================

ReactDOM.render(
  <App />,
  document.getElementById('root')
);