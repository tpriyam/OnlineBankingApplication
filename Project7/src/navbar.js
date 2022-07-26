import React from 'react';

const NavBar = ({loggedIn, setLoggedIn}) =>  {
  
  const handleLogout = () => {
    sessionStorage.setItem("loggedIn", 'false');
    setLoggedIn('false');
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="http://localhost:5000/">Banking System</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            {/* <li className="nav-item active">
              <a className="nav-link" href="/">Home</a>
            </li> */}
            {
              loggedIn==='false' && 
              <li className="nav-item">
                <a className="nav-link" href="/login">Login</a>
              </li>
            }
            {
              loggedIn==='true' &&
              <li className="nav-item">
                <a className="nav-link" href="/loanform">Loan Application Form</a>
              </li>
            }
            {
              loggedIn==='true' &&
              <li className="nav-item">
                <a className="nav-link" href="/clientstatus">Client Status</a>
              </li>
            }
            {
              loggedIn==='true' &&
              <li className="nav-item">
                <a className="nav-link" href="/login" onClick={handleLogout}>Logout</a>
              </li>
            }

          </ul>
        </div>
      </nav>
    </div>
  );
}

export default NavBar;